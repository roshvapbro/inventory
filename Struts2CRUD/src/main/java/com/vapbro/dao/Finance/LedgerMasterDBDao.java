package com.vapbro.dao.Finance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vapbro.model.Finance.LedgerMaster;
import com.vapbro.util.DBUtil;

public class LedgerMasterDBDao implements LedgerMasterDao{
	private static Logger logger = Logger.getLogger(GroupMasterDBDao.class
			.getName());
	private static ArrayList heads;
	private Statement stmt;

	private ResultSet rs;
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

	@Override
	public void insert(LedgerMaster ledger) {
		Connection conn = null;
		
		String name = "";
		PreparedStatement ps = null;
		
		double acbal04=0,acbal05=0,acbal06=0,acbal07=0,acbal08=0,acbal09=0,acbal10=0,acbal11=0,acbal12=0,acbal01=0,acbal02=0,acbal03=0;
		int parentId=-1,groupLevel=-1,levelNo=-1;
		try {
			System.out.println("LedgerParentName:" + ledger.getGroupParent());
			System.out.println("LedgerHeadName:" + ledger.getLedgerName());
			conn = DBUtil.getDBConnection();
			
			String sql = "SELECT acID,acgrouplevel,aclevelno FROM accountmaster WHERE";
	         sql+=" acHead = ?";
	         PreparedStatement ps1 = conn.prepareStatement(sql);
	         ps1.setString(1, ledger.getGroupParent());
	         ResultSet rs = ps1.executeQuery();

	         while (rs.next()) {
	        	 	parentId = rs.getInt("acID");
					groupLevel = rs.getInt("acgrouplevel");
					levelNo = rs.getInt("aclevelno");
					//levelNo=levelNo+1;
					levelNo=8;
	         }
	         String DATE_FORMAT = "yyyy-MM-dd";

	         SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

	         String date = sdf.format(ledger.getOPDate()) ;		
			
			String insertTableSQL = "INSERT INTO accountmaster"
					+ "(acHead,acGroupLevel,acParentID,acLevelNo,acType,acOpenDate,acOpenBal,acBal01,acBal02,acBal03,acBal04,acBal05,acBal06,acBal07,acBal08,acBal09,acBal10,acBal11,acBal12,"
					+ "acaddr1,accity,acplace,actelno,acmobno,acemail,actin,accst,acpan,instrtype,creditdays,creditlimit,actrantype,opbalcrdr,remarks,isledger) VALUES"
					+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			ps = conn.prepareStatement(insertTableSQL);
			System.out.println("LedgerName:" + ledger.getLedgerName());
			ps.setString(1, ledger.getLedgerName());
			ps.setInt(2, groupLevel);
			ps.setInt(3, parentId);
			ps.setInt(4, levelNo);
			ps.setInt(5, 1);
			ps.setString(6, date);
			ps.setString(7,ledger.getOpBalance());
			ps.setDouble(8, acbal01);
			ps.setDouble(9, acbal02);
			ps.setDouble(10, acbal03);
			ps.setDouble(11, acbal04);
			ps.setDouble(12, acbal05);
			ps.setDouble(13, acbal06);
			ps.setDouble(14, acbal07);
			ps.setDouble(15, acbal08);
			ps.setDouble(16, acbal09);
			ps.setDouble(17, acbal10);
			ps.setDouble(18, acbal11);
			ps.setDouble(19, acbal12);

			ps.setString(20, ledger.getAddress());
			ps.setString(21, ledger.getArea());
			ps.setString(22, ledger.getPlace());
			ps.setString(23, ledger.getPhone());
			ps.setString(24, ledger.getMobile());
			ps.setString(25, ledger.getEmail());
			ps.setString(26, ledger.getTIN());
			ps.setString(27, ledger.getCST());
			ps.setString(28, ledger.getPAN());
			ps.setString(29, ledger.getInstType());
			ps.setString(30, ledger.getCrDays());
			ps.setString(31, ledger.getCrLimit());
			ps.setString(32, ledger.getACType());
			ps.setString(33, ledger.getOptype());
			ps.setString(34, ledger.getRemarks());
			ps.setInt(35, 1);
			ps.executeUpdate();
		}catch (Exception e) {
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

}
