package com.vapbro.service.finance;

import java.util.List;

import com.vapbro.model.Finance.LedgerType;
import com.vapbro.model.Finance.TransType;

public interface ReceiptService {
	
    public List<TransType> getAllTransTypes();

	public List<LedgerType> getAllLedgerTypes();

	public TransType getCurrentBalById(Integer id);

	public LedgerType getledgerBalById(Integer id);

}
