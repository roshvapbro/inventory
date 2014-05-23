package com.vapbro.action.Finance;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import com.vapbro.model.Finance.GroupMaster;
import com.vapbro.service.finance.GroupMasterDaoService;
import com.vapbro.service.finance.GroupMasterService;

public class GroupMasterAction extends ActionSupport implements Preparable {
	
	private static Logger logger = Logger.getLogger(GroupMasterAction.class
			.getName());
	private static GroupMasterService groupService = new GroupMasterDaoService();
	private List groupheads=new ArrayList();


	public List getGroupheads() {
		return groupheads;
	}

	public void setGroupheads(List groupheads) {
		this.groupheads = groupheads;
	}


	private GroupMaster group;
	
	public GroupMaster getGroup() {
		return group;
	}

	public void setGroup(GroupMaster group) {
		this.group = group;
	}

	public String input() {
		logger.debug("in method input");

		if (group != null && group.getGroupName() != null) {
			logger.debug("GroupName is " + group.getGroupName());
		}
		return INPUT;
	}
	
	/**
	 * Saves a new Groupmaster 
	 * 
	 * @return success
	 */
	public String saveGroup() {
		logger.debug("in method save");
		logger.debug("in method GroupName"+group.getGroupName());


			groupService.insertGroup(group);
		
		return SUCCESS;
	}
	
	public String execute() {
        setGroupheads(groupService.getAllGroupHeads());
		 
		return SUCCESS;
 
	}


	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
