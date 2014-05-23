package com.vapbro.service.finance;

import java.util.List;

import com.vapbro.model.Product;
import com.vapbro.model.Finance.GroupMaster;


public interface GroupMasterService {
	
    public List getAllGroupHeads();

	public void insertGroup(GroupMaster group);

}
