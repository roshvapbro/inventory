package com.vapbro.dao.Finance;

import java.util.List;

import com.vapbro.model.Finance.LedgerMaster;

public interface LedgerMasterDao {
	
	public List getAllGroupHeads();

    public void insert(LedgerMaster ledger);

}
