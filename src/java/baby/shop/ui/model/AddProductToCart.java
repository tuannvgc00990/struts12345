/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baby.shop.ui.model;
import baby.shop.biz.Cart;
import baby.shop.entity.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;

/**
 *
 * @author tuan5
 */
public class AddProductToCart extends ActionSupport{
    private

    @Override
    public String execute() throws Exception {
        Cart cart=(Cart)ActionContext.getContext().getSession().get("cart");
        if(cart==null){
        cart=new Cart();
        }
        Product
        
    }
    
            
}
