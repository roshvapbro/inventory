package com.vapbro.model.Finance;

import java.io.Serializable;

public class GroupMaster implements Serializable {
	private static final long serialVersionUID = 1L;
	private String groupName;
	private String groupParent;
	
	public GroupMaster() {
		
	}
	public GroupMaster(String groupName, String groupParent) {
		this.groupName = groupName;
		this.groupParent = groupParent;
	}
	

	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupParent() {
		return groupParent;
	}
	public void setGroupParent(String groupParent) {
		this.groupParent = groupParent;
	}

	

	
	

}
