/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.da;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author tuan5
 */
public class DBConnection {
    private static Connection connection;
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
    if(connection==null){
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    connection=DriverManager.getConnection("jdbc:sqlServer://localhost:1433","sa","12345");
    }
    return connection;
    }
}
