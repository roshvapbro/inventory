package com.vapbro.model;

import java.io.Serializable;
import java.sql.Date;

public class SalesOrder implements Serializable {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	private Integer salesOrderId;
	private Date date;
	private double price;
	private Integer productId;
	private String status;

	
	public SalesOrder() {
	}

	public SalesOrder(Integer id, Date date, double price) {
		this.salesOrderId = id;
		this.date = date;
		this.price = price;
	}

	public Integer getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(Integer salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
