package com.vapbro.model.Finance;

import java.io.Serializable;

public class TransType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3449607541612146243L;
	
	private Integer acId;
	private String acHead;
	private Double currentBal;
	
	public TransType() {
		// TODO Auto-generated constructor stub
	}
	
	public TransType(Integer acId, String acHead) {
		super();
		this.acId = acId;
		this.acHead = acHead;
	}
	
	public Integer getAcId() {
		return acId;
	}

	public void setAcId(Integer acId) {
		this.acId = acId;
	}

	public String getAcHead() {
		return acHead;
	}

	public void setAcHead(String acHead) {
		this.acHead = acHead;
	}
	
	
	public Double getCurrentBal() {
		return currentBal;
	}

	public void setCurrentBal(Double currentBal) {
		this.currentBal = currentBal;
	}

	public String toString(){
		return "[AccountHead="+ acHead + "," + "id=" +acId +"CurrentBalance=" +currentBal +"]";
		
	}

	

}
