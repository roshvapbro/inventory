package com.vapbro.model.Finance;

import java.io.Serializable;
import java.util.Date;

public class LedgerMaster implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private String groupParent; 
	private String ledgerName;
	private String Address;
	private String Area;
	private String Place;
	private String Phone;
	private String Mobile;
	private String Fax;
	private String Email;
	private String TIN;
	private String CST;
	private String PAN;
	private String InstType;
	private String ACType;
	private String CrLimit;
	private String CrDays;
	private String OpBalance;
	private String Optype;
	private Date OPDate;
	private String Remarks;
	
	
	public LedgerMaster() {
		
	}


	public LedgerMaster(String groupParent, String ledgerName, String address,
			String area, String place, String phone, String mobile, String fax,
			String email, String tIN, String cST, String pAN, String instType,
			String aCType, String crLimit, String crDays, String opBalance,
			String optype, Date oPDate, String remarks) {
		super();
		this.groupParent = groupParent;
		this.ledgerName = ledgerName;
		Address = address;
		Area = area;
		Place = place;
		Phone = phone;
		Mobile = mobile;
		Fax = fax;
		Email = email;
		TIN = tIN;
		CST = cST;
		PAN = pAN;
		InstType = instType;
		ACType = aCType;
		CrLimit = crLimit;
		CrDays = crDays;
		OpBalance = opBalance;
		Optype = optype;
		OPDate = oPDate;
		Remarks = remarks;
	}


	public String getGroupParent() {
		return groupParent;
	}


	public void setGroupParent(String groupParent) {
		this.groupParent = groupParent;
	}


	public String getLedgerName() {
		return ledgerName;
	}


	public void setLedgerName(String ledgerName) {
		this.ledgerName = ledgerName;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getArea() {
		return Area;
	}


	public void setArea(String area) {
		Area = area;
	}


	public String getPlace() {
		return Place;
	}


	public void setPlace(String place) {
		Place = place;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public String getMobile() {
		return Mobile;
	}


	public void setMobile(String mobile) {
		Mobile = mobile;
	}


	public String getFax() {
		return Fax;
	}


	public void setFax(String fax) {
		Fax = fax;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getTIN() {
		return TIN;
	}


	public void setTIN(String tIN) {
		TIN = tIN;
	}


	public String getCST() {
		return CST;
	}


	public void setCST(String cST) {
		CST = cST;
	}


	public String getPAN() {
		return PAN;
	}


	public void setPAN(String pAN) {
		PAN = pAN;
	}


	public String getInstType() {
		return InstType;
	}


	public void setInstType(String instType) {
		InstType = instType;
	}


	public String getACType() {
		return ACType;
	}


	public void setACType(String aCType) {
		ACType = aCType;
	}


	public String getCrDays() {
		return CrDays;
	}


	public void setCrDays(String crDays) {
		CrDays = crDays;
	}


	public String getCrLimit() {
		return CrLimit;
	}


	public void setCrLimit(String crLimit) {
		CrLimit = crLimit;
	}


	public String getOpBalance() {
		return OpBalance;
	}


	public void setOpBalance(String opBalance) {
		OpBalance = opBalance;
	}


	public String getOptype() {
		return Optype;
	}


	public void setOptype(String optype) {
		Optype = optype;
	}


	public Date getOPDate() {
		return OPDate;
	}


	public void setOPDate(Date oPDate) {
		OPDate = oPDate;
	}


	public String getRemarks() {
		return Remarks;
	}


	public void setRemarks(String remarks) {
		Remarks = remarks;
	}



	
	

}
