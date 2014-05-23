package com.vapbro.dao.Finance;

import java.util.List;

import com.vapbro.model.Product;
import com.vapbro.model.Finance.GroupMaster;

public interface GroupMasterDao {

    public List getAllGroupHeads();

    public void insert(GroupMaster group);

	
}
