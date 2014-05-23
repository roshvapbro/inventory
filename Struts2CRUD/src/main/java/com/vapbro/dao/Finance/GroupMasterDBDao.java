package com.vapbro.dao.Finance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vapbro.action.Finance.GroupMasterAction;
import com.vapbro.model.Product;
import com.vapbro.model.Finance.GroupMaster;
import com.vapbro.util.DBUtil;

public class GroupMasterDBDao implements GroupMasterDao{
	private static Logger logger = Logger.getLogger(GroupMasterDBDao.class
			.getName());
	private int acGroupLevel=0,acParentID=0,acLevelNo=0;
	private static ArrayList heads;


	public static String getCodeName(java.sql.Connection conn, String query)
	{
		String codename = "";
		java.sql.Statement st = null;
		java.sql.ResultSet rst = null;

		try
		{
			st = conn.createStatement();
//		System.out.println(query);
			rst = st.executeQuery(query);
			if(rst.next())
				codename = rst.getString(1);
			st.close();
		}
		catch(Exception e)
		{
			System.err.println("getCodeNameException "+e);
			try{st.close();}catch(Exception E){}
		}
		return codename;
	}
	@Override
	public void insert(GroupMaster group) {
		Connection conn = null;
		String name = "";
		PreparedStatement ps = null;
		try {
			System.out.println("ParentName:" + group.getGroupParent());
			System.out.println("AcHeadName:" + group.getGroupName());


			 
			conn = DBUtil.getDBConnection();
			
			if(!group.getGroupParent().isEmpty()){
				
				acParentID = Integer.parseInt(getCodeName(conn,"select acID from accountmaster where acHead='"+group.getGroupParent()+"'"));
				System.out.println("ParentID" + acParentID);

				acLevelNo = Integer.parseInt(getCodeName(conn,"select acLevelNo from accountmaster where acHead='"+group.getGroupParent()+"'"))+1;
				if(acLevelNo>1){
					acGroupLevel = Integer.parseInt(getCodeName(conn,"select acGroupLevel from accountmaster where acID="+acParentID+""));
				}else{
					acGroupLevel = acParentID;
				}
			}
			if(acLevelNo <= 7)
					{
				String insertTableSQL = "INSERT INTO accountmaster"
						+ "(acHead,acGroupLevel,acParentId,acLevelNo) VALUES"
						+ "(?,?,?,?)";

				ps = conn.prepareStatement(insertTableSQL);
				System.out.println("DBServiceName:" + group.getGroupName());
				ps.setString(1, group.getGroupName());
				ps.setInt(2, acGroupLevel);
				ps.setInt(3, acParentID);
				ps.setInt(4, acLevelNo);

				ps.executeUpdate();
					}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

	
		
	}
	@Override
	public List getAllGroupHeads() {
		try {
			return readGroupHeadsFromDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public List readGroupHeadsFromDB() throws Exception{
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "select acHead from accountmaster";

		try {
			dbConnection = DBUtil.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			//preparedStatement.setInt(1, 1001);

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();

			heads = new ArrayList();
			while (rs.next()) {

				String achead = rs.getString("achead");
				if(achead!=null)
				{
					heads.add(achead);
				}
			
				System.out.println("Accoutn Head : " + achead);

			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
		return heads;
	}
}
