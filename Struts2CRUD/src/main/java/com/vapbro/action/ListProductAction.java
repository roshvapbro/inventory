package com.vapbro.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
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
public class ListProductAction extends ActionSupport 
{
  
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
    private static Logger logger = Logger.getLogger( ListProductAction.class.getName() );
    private static ProductService prodService = new ProductDaoService();
    private List<Product> products;



    /**
     * Create collection of Employee objects.
     * @return success
     */
    public String execute() throws Exception 
    {
        setProducts(prodService.getAllProducts());
        
        return SUCCESS;
        
    }



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products =products;
	}


}
