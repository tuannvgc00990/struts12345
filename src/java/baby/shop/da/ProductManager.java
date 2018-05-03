/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.da;

import baby.shop.entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuan5
 */
public class ProductManager {

    private static PreparedStatement searchByNameStatement;
    private static PreparedStatement searchByIdStatement;

    public PreparedStatement getSearchbyNameStatement() throws SQLException, ClassNotFoundException {
        if (searchByNameStatement == null) {
            Connection conn = DBConnection.getConnection();
            searchByNameStatement = conn.prepareStatement("select id,[name],[price],[description] from product where [name] like ?");
        }
        return searchByNameStatement;
    }

    public PreparedStatement getSearchbyIdStatement() throws SQLException, ClassNotFoundException {
        if (searchByIdStatement == null) {
            Connection conn = DBConnection.getConnection();
            searchByIdStatement = conn.prepareStatement("select [name],[price],[description] from product where id=?");
        }
        return searchByIdStatement;
    }

    public List<Product> getProductByName(String keyword) {

        try {
            PreparedStatement statement = getSearchbyNameStatement();
            statement.setString(1, keyword);
            ResultSet rs = statement.executeQuery();
            List<Product> products = new LinkedList<Product>();
            while (rs.next()) {
                Product pr = new Product();
                pr.setId(rs.getInt("id"));
                pr.setName(rs.getString("name"));
                pr.setPrice(rs.getFloat("price"));
                pr.setDescription(rs.getString("description"));
                products.add(pr);
            }
            return products;

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new LinkedList<Product>();
    }

    public Product getProductById(int id) {

        try {
            PreparedStatement statement = getSearchbyIdStatement();
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Product pr = new Product();
                pr.setId(id);
                pr.setName(rs.getString("name"));
                pr.setPrice(rs.getFloat("price"));
                pr.setDescription(rs.getString("description"));
                return pr;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(ProductManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Product();
    }
}
