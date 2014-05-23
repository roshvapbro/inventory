package com.vapbro.model.Finance;

import java.io.Serializable;

import com.vapbro.model.Category;

public class CashReceipt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4065418221805817053L;
	/**
	 * 
	 */
	private TransType trans;
	private LedgerType ledger;
	
	public CashReceipt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CashReceipt(TransType trans, LedgerType ledger) {
		super();
		this.trans = trans;
		this.ledger = ledger;
	}
	public TransType getTrans() {
		return trans;
	}
	public void setTrans(TransType trans) {
		this.trans = trans;
	}
	public LedgerType getLedger() {
		return ledger;
	}
	public void setLedger(LedgerType ledger) {
		this.ledger = ledger;
	}

}
