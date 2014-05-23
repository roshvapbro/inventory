package com.vapbro.action.Finance;


import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	
private String acHead;
public String getAcHead() {
	return acHead;
}

public void setAcHead(String acHead) {
	this.acHead = acHead;
}

private Double currentBal;

public Double getCurrentBal() {
	return currentBal;
}

public void setCurrentBal(Double currentBal) {
	this.currentBal = currentBal;
}

public String save() throws Exception {
	
	if (getAcHead() != null && !getAcHead().equals("")) {
		
	System.out.println("Achead"+getAcHead());
	System.out.println("Achead"+getCurrentBal());

	return SUCCESS;
	} else {
	return SUCCESS;
	}

}

}
