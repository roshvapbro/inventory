package com.vapbro.action.Finance;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class CashReceiptDetailAction extends ActionSupport {
/**
	 * 
	 */
	private static final long serialVersionUID = 4626270027321771432L;
	private Double lst=0.0;
	private Double cur=0.0;

	public Double getCur() {
		return cur;
	}

	public void setCur(Double cur) {
		this.cur = cur;
	}

	private Double currentbal=0.0 ;


public Double getCurrentbal() {
		return currentbal;
	}
	
public String execute() throws Exception {
	
	if (getLst() != null && !getLst().equals("")) {
		
	populateDetail(getLst());
	return SUCCESS;
	} else {
	return SUCCESS;
	}

}
private void populateDetail(Double currentbal) {
	
	this.currentbal = currentbal;

}


public Double getLst() {
return lst;
}

public void setLst(Double lst) {
this.lst= lst;
}
}