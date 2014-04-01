package com.vapbro.action;



import org.apache.log4j.Logger;





import com.opensymphony.xwork2.ActionSupport;
import com.vapbro.model.Product;
import com.vapbro.service.ProductDaoService;
import com.vapbro.service.ProductService;

/**
 * Acts as a Struts 2 controller to handle interaction between
 * the Service layer and the view for deleting an Employee.
 * @author bphillips
 *
 */
public class ProductDeleteAction extends ActionSupport
{

    private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger( ProductDeleteAction.class.getName() );
    private static ProductService prodService = new ProductDaoService();
 
    private Product product;




    /**
     * Delete the Employee object based on the value
     * of the employeeId field from the data repository.
     * @return success
     */
    public String delete()
    {
    	logger.debug("in method delete");
        
    	if (product != null && product.getPdocutId() != null)
        {
        	logger.debug("Product ID is " + product.getPdocutId());
            
        }
    	prodService.deleteProduct(product.getPdocutId());
        return SUCCESS;
    }

 


    public Product getProduct()
    {
        return product;
    }

 
    public void setProduct(Product prod)
    {
        this.product = prod;
    }

 
}
