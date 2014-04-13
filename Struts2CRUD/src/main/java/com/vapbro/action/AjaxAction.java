package com.vapbro.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.vapbro.model.Category;
import com.vapbro.model.Product;
import com.vapbro.service.ProductDaoService;
import com.vapbro.service.ProductService;


/**
 * Acts as a Struts 2 controller to handle interaction between 
 * the service layer and the view to get a collection of Employee
 * objects.
 * @author bphillips
 *
 */
public class AjaxAction
{
  
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
    private static Logger logger = Logger.getLogger( AjaxAction.class.getName() );
    private static ProductService prodService = new ProductDaoService();
    private List<Product> products;


    AjaxAction(){
    	products.add(new Product(1, "name1","desc1", "type1",1,new Category(1,"categ1"), "other1"));
    	products.add(new Product(2, "name2","desc2", "type2",2,new Category(2,"categ2"), "other2"));
    	products.add(new Product(3,"name3", "desc3", "type3",3,new Category(3,"categ3"), "other3"));
    	products.add(new Product(4,"name4", "des4", "type4",4,new Category(4,"categ4"), "other4"));
    	products.add(new Product(5,"name5", "des5", "type5",5,new Category(5,"categ5"), "other5"));
    	
    }
    /**
     * Create collection of product objects.
     * @return success
     */
    public String execute() throws Exception 
    {
        //setProducts(prodService.getAllProducts());
        
        return Action.SUCCESS;
        
    }



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products =products;
	}


}
