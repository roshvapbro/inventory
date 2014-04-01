package com.vapbro.model;

import java.io.Serializable;

public class Category implements Serializable {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	Integer categoryId;
	String name;

	public Category() {
	}

	public Category(Integer id, String name) {
		this.categoryId = id;
		this.name = name;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
