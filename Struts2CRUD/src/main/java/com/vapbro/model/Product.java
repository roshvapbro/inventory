package com.vapbro.model;

import java.io.Serializable;

public class Product implements Serializable {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	private Integer pdocutId;
	private Integer barcodeId;
	private String description;
	private String type;
	private Category category;
	private String otherInfo;
	

	public Product() {
	}

	public Product(Integer pdocutId, String description, String type,
			Integer barcodeId, Category category, String otherInfo) {
		this.pdocutId = pdocutId;
		this.description = description;
		this.type = type;
		this.barcodeId = barcodeId;
		this.category = category;
		this.otherInfo = otherInfo;
	}

	public Integer getPdocutId() {
		return pdocutId;
	}

	public void setPdocutId(Integer pdocutId) {
		this.pdocutId = pdocutId;
	}

	public Integer getBarcodeId() {
		return barcodeId;
	}

	public void setBarcodeId(Integer barcodeId) {
		this.barcodeId = barcodeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

}
