package com.vapbro.action.Finance;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.vapbro.model.Finance.LedgerMaster;
import com.vapbro.service.finance.LedgerMasterDaoService;
import com.vapbro.service.finance.LedgerMasterService;


public class LedgerMasterAction extends ActionSupport implements Preparable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List groupheads=new ArrayList();
	private static LedgerMasterService ledgerservice = new LedgerMasterDaoService();
	
	private LedgerMaster ledgermaster;


	public LedgerMaster getLedgermaster() {
		return ledgermaster;
	}

	public void setLedgermaster(LedgerMaster ledgermaster) {
		this.ledgermaster = ledgermaster;
	}

	public List getGroupheads() {
		return groupheads;
	}

	public void setGroupheads(List groupheads) {
		this.groupheads = groupheads;
	}
	
	public String execute() {
		
        setGroupheads(ledgerservice.getAllGroupHeads());

		return SUCCESS;
 
	}
	public String saveLedger() {
		ledgerservice.insert(ledgermaster);
		
		return SUCCESS;
	}
	@Override
	public void prepare() throws Exception {
		
	}

}
