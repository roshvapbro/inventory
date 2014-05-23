package com.vapbro.service.finance;

import java.util.List;

import com.vapbro.model.Finance.LedgerMaster;

public interface LedgerMasterService {

	public List getAllGroupHeads();

    public void insert(LedgerMaster ledger);
}
