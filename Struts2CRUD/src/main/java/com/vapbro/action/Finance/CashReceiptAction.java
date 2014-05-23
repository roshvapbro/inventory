package com.vapbro.action.Finance;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.vapbro.model.Finance.CashReceipt;

public class CashReceiptAction extends ActionSupport implements Preparable {

	/**
	 * 
	 */
	private CashReceipt cashreceipt;

	

	public String saveCashReceipt() {
		System.out.println("Inside saveCashReceipt");


		if ( cashreceipt.getTrans().getAcId()!=null) {
			System.out.println("Trsn ID is " + cashreceipt.getTrans().getAcId());
			//product = prodService.getProduct(product.getPdocutId());
		}
		return SUCCESS;
	}
	public String execute() {
		 
		return SUCCESS;
 
	}
	public CashReceipt getCashreceipt() {
		return cashreceipt;
	}
	public void setCashreceipt(CashReceipt cashreceipt) {
		this.cashreceipt = cashreceipt;
	}
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
