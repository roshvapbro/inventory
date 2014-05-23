package com.vapbro.action.Finance;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.vapbro.model.Finance.CashReceipt;
import com.vapbro.model.Finance.LedgerType;
import com.vapbro.model.Finance.TransType;
import com.vapbro.service.finance.ReceiptDaoService;
import com.vapbro.service.finance.ReceiptService;

public class ReceiptAction extends ActionSupport{
			
	private CashReceipt cashreceipt;
	
	public String input() {

		if (cashreceipt != null && cashreceipt.getTrans()!=null && cashreceipt.getLedger()!= null) {
			System.out.println("Trsn ID is " + cashreceipt.getTrans().getAcId());
			//product = prodService.getProduct(product.getPdocutId());
		}
		return INPUT;
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


}
