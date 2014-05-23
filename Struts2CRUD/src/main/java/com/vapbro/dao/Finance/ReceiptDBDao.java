package com.vapbro.dao.Finance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vapbro.dao.CategoryDao;
import com.vapbro.dao.CategoryNoDBdao;
import com.vapbro.model.Category;
import com.vapbro.model.Product;
import com.vapbro.model.Finance.LedgerType;
import com.vapbro.model.Finance.TransType;
import com.vapbro.util.DBUtil;

public class ReceiptDBDao implements ReceiptDao {
    private static List<TransType> transtypes;
    private static List<LedgerType> ledgertypes;
    //public Integer id;
    //private TransType trans;
    static {
    	transtypes = new ArrayList<TransType>();
    	ledgertypes = new ArrayList<LedgerType>();

//		
	}


	@Override
	public List<TransType> getAllTransType() {
		// TODO Auto-generated method stub
		try {
			return readGroupHeadsFromDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public List<TransType> readGroupHeadsFromDB() throws Exception{
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "select acId,acHead ,acCurrentBal from accountmaster WHERE";
		selectSQL+=" instrtype  in (?) ";
		try {
			dbConnection = DBUtil.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "Cash");

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();

			transtypes = new ArrayList<TransType>();
			while (rs.next()) {

				int acId = rs.getInt("acid");
				String achead = rs.getString("achead");
				Double currntbalance=rs.getDouble("acCurrentBal");
				
			TransType trans=new TransType();
				trans.setAcId(acId);
				trans.setAcHead(achead);
				trans.setCurrentBal(currntbalance);
				transtypes.add(trans);
				
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
		return transtypes;
	}


	@Override
	public List<LedgerType> getAllLedgerTypes() {
		try {
			return readLedgerTypesFromDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	private List<LedgerType> readLedgerTypesFromDB() throws Exception {
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "select acId,acHead ,acCurrentBal from accountmaster WHERE";
		selectSQL+=" instrtype not in (?,?)  and isLedger=?";
		try {
			dbConnection = DBUtil.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setString(1, "Cash");
			preparedStatement.setString(2, "Bank");
			preparedStatement.setInt(3, 1);



			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();

			ledgertypes = new ArrayList<LedgerType>();
			while (rs.next()) {

				int acId = rs.getInt("acid");
				String achead = rs.getString("achead");
				Double currntbalance=rs.getDouble("acCurrentBal");
				
			LedgerType ledger=new LedgerType();
				ledger.setLedgerId(acId);
				ledger.setLedgerHead(achead);
				ledger.setCurrentBalanace(currntbalance);
				ledgertypes.add(ledger);
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
		return ledgertypes;
	}
	

	public TransType getCurrentBalById(Integer id) {
		TransType tarns=null;
				
				Iterator<TransType> iter = transtypes.iterator();
		while (iter.hasNext()) {
			tarns = (TransType) iter.next();
			if (tarns.getAcId().equals(id)) {
				break;
			}
		}
		return tarns;
	}
	public LedgerType getledgerBalById(Integer id) {
		LedgerType ledger=null;
				
				Iterator<LedgerType> iter = ledgertypes.iterator();
		while (iter.hasNext()) {
			ledger = (LedgerType) iter.next();
			if (ledger.getLedgerId().equals(id)) {
				break;
			}
		}
		return ledger;
	}
	/*public TransType getCurrentBalById(Integer id) {
		try {
			return getCurrentBalByDBId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
	/*public TransType getCurrentBalByDBId(Integer id) throws Exception{
		// TODO Auto-generated method stub
		this.id=id;
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "select acId,acHead ,acCurrentBal from accountmaster WHERE";
		selectSQL+=" acId=?";
		try {
			dbConnection = DBUtil.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);
			

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();

			ledgertypes = new ArrayList<LedgerType>();
			while (rs.next()) {

				int acId = rs.getInt("acid");
				String achead = rs.getString("achead");
				Double currntbalance=rs.getDouble("acCurrentBal");
				
				TransType trans=new TransType();
				trans.setAcId(acId);
				trans.setAcHead(achead);
				trans.setCurrentBal(currntbalance);
				
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
		return trans;	
		}
	*/
	

}
