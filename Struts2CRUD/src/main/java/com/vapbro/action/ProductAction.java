package com.vapbro.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.vapbro.model.Category;
import com.vapbro.model.Product;
import com.vapbro.service.CategoryDaoService;
import com.vapbro.service.CategoryService;
import com.vapbro.service.ProductDaoService;
import com.vapbro.service.ProductService;

/**
 * Acts as a Struts 2 controller to hander interaction with the Service layer
 * and view layer for listing employees, saving a new employee, and updating an
 * employee.
 * 
 * @author muppi
 * 
 */
public class ProductAction extends ActionSupport implements Preparable {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ProductAction.class
			.getName());
	private static ProductService prodService = new ProductDaoService();
	private static CategoryService catService = new CategoryDaoService();
	private Product product;
	private List<Category> categories;

	/**
	 * Ensures that the collection of Department objects is always available to
	 * the view.
	 */
	public void prepare() throws Exception {
		categories = catService.getAllCategories();

		logger.debug("in method prepare");

	}

	/**
	 * Saves a new employee if the employee object's employeeId is null
	 * otherwise updates existing employee.
	 * 
	 * @return success
	 */
	public String save() {
		logger.debug("in method save");

		if (product.getPdocutId() == null) {
			prodService.insertProduct(product);
		} else {
			prodService.updateProduct(product);
		}
		return SUCCESS;
	}

	/**
	 * Gets a specific Employee objects so it can be displayed in the view.
	 * 
	 * @return input
	 */
	public String input() {
		logger.debug("in method input");

		if (product != null && product.getPdocutId() != null) {
			logger.debug("Prod ID is " + product.getPdocutId());
			product = prodService.getProduct(product.getPdocutId());
		}
		return INPUT;
	}
	public String execute() {
		 
		return SUCCESS;
 
	}
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Category> getCategories() {
		return categories;
	}
}
