package com.vapbro.service.finance;

import java.util.List;

import com.vapbro.dao.Finance.LedgerMasterDBDao;
import com.vapbro.dao.Finance.LedgerMasterDao;
import com.vapbro.model.Finance.LedgerMaster;

public class LedgerMasterDaoService implements LedgerMasterService {
	
	
	LedgerMasterDao dao;
	public LedgerMasterDaoService() {
		this.dao=new LedgerMasterDBDao();
		
	}


	@Override
	public List getAllGroupHeads() {
		// TODO Auto-generated method stub
		return dao.getAllGroupHeads();
	}

	@Override
	public void insert(LedgerMaster ledger) {
		dao.insert(ledger);
	}

}
