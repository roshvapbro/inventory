package com.vapbro.service.finance;

import java.util.List;

import com.vapbro.dao.Finance.GroupMasterDBDao;
import com.vapbro.dao.Finance.GroupMasterDao;
import com.vapbro.model.Finance.GroupMaster;

public class GroupMasterDaoService  implements GroupMasterService{

	private GroupMasterDao dao;

    public GroupMasterDaoService()
    {
        this.dao = new GroupMasterDBDao();
    }
	
	@Override
	public void insertGroup(GroupMaster group) {
	dao.insert(group);
		
	}

	@Override
	public List getAllGroupHeads() {
		// TODO Auto-generated method stub
		return dao.getAllGroupHeads();	}


	
	

}
