package com.vapbro.service.finance;

import java.util.List;

import com.vapbro.dao.Finance.ReceiptDBDao;
import com.vapbro.dao.Finance.ReceiptDao;
import com.vapbro.model.Finance.LedgerType;
import com.vapbro.model.Finance.TransType;

public class ReceiptDaoService  implements ReceiptService{

	ReceiptDao dao;
	public ReceiptDaoService() {
		this.dao=new ReceiptDBDao();
		
	}

	
	@Override
	public List<TransType> getAllTransTypes() {
		// TODO Auto-generated method stub
		return dao.getAllTransType();
	}


	@Override
	public List<LedgerType> getAllLedgerTypes() {
		// TODO Auto-generated method stub
		return dao.getAllLedgerTypes();
	}


	@Override
	public TransType getCurrentBalById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getCurrentBalById(id);
	}


	@Override
	public LedgerType getledgerBalById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getledgerBalById(id);
	}

}
