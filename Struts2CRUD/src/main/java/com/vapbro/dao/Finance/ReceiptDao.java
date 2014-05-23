package com.vapbro.dao.Finance;

import java.util.List;

import com.vapbro.model.Finance.LedgerType;
import com.vapbro.model.Finance.TransType;

public interface ReceiptDao {
    public List<TransType> getAllTransType();

	public List<LedgerType> getAllLedgerTypes();

	public TransType getCurrentBalById(Integer id);

	public LedgerType getledgerBalById(Integer id);
}
