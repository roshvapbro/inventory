package com.vapbro.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.vapbro.model.Category;
import com.vapbro.service.CategoryDaoService;
import com.vapbro.service.CategoryService;


/**
 * Acts as a Struts 2 controller to handle interaction between 
 * the service layer and the view to get a collection of category
 * objects.
 * @author bphillips
 *
 */
public class ListCategoryAction extends ActionSupport 
{
  
    private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
    private static Logger logger = Logger.getLogger( ListCategoryAction.class.getName() );
    private static CategoryService catService = new CategoryDaoService();
    private List<Category> categories;



    /**
     * Create collection of Employee objects.
     * @return success
     */
    public String execute() throws Exception 
    {
        setCategories(catService.getAllCategories());
        
        return SUCCESS;
        
    }



	public List<Category> getCategories() {
		return categories;
	}



	public void setCategories(List<Category> categories) {
		this.categories =categories;
	}


}
