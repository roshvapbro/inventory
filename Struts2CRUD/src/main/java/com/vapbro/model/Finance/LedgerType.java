package com.vapbro.model.Finance;

public class LedgerType {
	
	
	private Integer ledgerId;
	private String ledgerHead;
	private Double currentBalanace;
	
	public LedgerType() {
		// TODO Auto-generated constructor stub
	}

	public LedgerType(Integer ledgerId, String ledgerHead,
			Double currentBalanace) {
		super();
		this.ledgerId = ledgerId;
		this.ledgerHead = ledgerHead;
		this.currentBalanace = currentBalanace;
	}

	public Integer getLedgerId() {
		return ledgerId;
	}

	public void setLedgerId(Integer ledgerId) {
		this.ledgerId = ledgerId;
	}

	public String getLedgerHead() {
		return ledgerHead;
	}

	public void setLedgerHead(String ledgerHead) {
		this.ledgerHead = ledgerHead;
	}

	public Double getCurrentBalanace() {
		return currentBalanace;
	}

	public void setCurrentBalanace(Double currentBalanace) {
		this.currentBalanace = currentBalanace;
	}

	@Override
	public String toString() {
		return "LedgerType [ledgerId=" + ledgerId + ", ledgerHead="
				+ ledgerHead + ", currentBalanace=" + currentBalanace + "]";
	}
	
	

}
