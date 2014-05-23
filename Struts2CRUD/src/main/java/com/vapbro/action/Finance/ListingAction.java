package com.vapbro.action.Finance;

import com.opensymphony.xwork2.ActionSupport;
import com.vapbro.model.Finance.LedgerType;
import com.vapbro.model.Finance.TransType;
import com.vapbro.service.finance.ReceiptDaoService;
import com.vapbro.service.finance.ReceiptService;

import java.util.ArrayList;
import java.util.List;

public class ListingAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static  ReceiptService receiptserv=new ReceiptDaoService();
	private List<TransType> transhead =new ArrayList<>() ;
	private List<LedgerType> ledgerheads =new ArrayList<>() ;
	private  LedgerType ledgertype;
	private Double currentbal=0.0 ;
	private Double ledgerbal=0.0 ;

	private Double lst;
	private TransType transtype;
	private Integer id;
	private Integer lid;

	
	public Integer getLid() {
		return lid;
	}


	public void setLid(Integer lid) {
		this.lid = lid;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public TransType getTranstype() {
		return transtype;
	}

	public void setTranstype(TransType transtype) {
		this.transtype = transtype;
	}

	public List<TransType> getTranshead() {
		return transhead;
	}

	
	public List<LedgerType> getLedgerheads() {
		return ledgerheads;
	}

	
	public LedgerType getLedgertype() {
		return ledgertype;
	}


	public void setLedgertype(LedgerType ledgertype) {
		this.ledgertype = ledgertype;
	}




	public String execute() throws Exception {
		transhead = receiptserv.getAllTransTypes();
		ledgerheads=receiptserv.getAllLedgerTypes();

		return SUCCESS;
	}


	public void prepare() throws Exception {


	}
	public Double getCurrentbal() {
		return currentbal;
	}
	
	public String getCurrentBalanceDB()throws Exception{
		
		System.out.println("If from jsp"+id);
		
		
		setLst(getCurrentBalanceByID(id));
		
		if (getLst() != null && !getLst().equals("")) {
			
			populateDetail(getLst());
			return SUCCESS;
			} else {
			return SUCCESS;
			}		
	}
public Double getCurrentBalanceByID(Integer id)throws Exception{
		
		
		if (id!= null) {
			transtype=receiptserv.getCurrentBalById(id);
			if (transtype != null ) {
			lst=transtype.getCurrentBal();
			System.out.println("CurBal"+lst);
			}
		}

		return lst;	

		
	}
	
public String getLedgerBalanceDB()throws Exception{
	
	System.out.println("Ledger Id from jsp"+lid);
	
	
	setLedgerbal(getledgerBalById(lid));
	
	if (getLedgerbal() != null && !getLedgerbal().equals("")) {
		
		populateDetail(getLedgerbal());
		return SUCCESS;
		} else {
		return SUCCESS;
		}		
}
public Double getledgerBalById(Integer lid)throws Exception{
	
	
	if (lid!= null) {
		ledgertype=receiptserv.getledgerBalById(lid);
		if (ledgertype != null ) {
		ledgerbal=ledgertype.getCurrentBalanace();
		System.out.println("Ledger CurBal"+ledgerbal);
		}
	}

	return ledgerbal;	

	
}
	
	
public String save() throws Exception {
	System.out.println("AcHead");
	System.out.println("Bal"+getLst());

	
	if (getLst() != null && !getLst().equals("")) {
		
	populateDetail(getLst());
	return SUCCESS;
	} else {
	return SUCCESS;
	}

}
public String saveledgerBal() throws Exception {
	
	if (getLedgerbal() != null && !getLedgerbal().equals("")) {
		
	populateDetail(getLedgerbal());
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
public Double getLedgerbal() {
	return ledgerbal;
}


public void setLedgerbal(Double ledgerbal) {
	this.ledgerbal = ledgerbal;
}

}

