package com.vapbro.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vapbro.model.Category;
import com.vapbro.model.Product;
import com.vapbro.util.DBUtil;

public class ProductDBdao implements ProductDao {
	private static Map<Integer, Category> categoriesMap;
	private static ArrayList<Product> products;
	static {
		products = new ArrayList<Product>();
//		products.add(new Product(new Integer(1), "colgate", "Doe", new Integer(
//				36), new Category(new Integer(100), "Accounting"), "50000"));
//		products.add(new Product(new Integer(2), "pepsodent", "Smith",
//				new Integer(25), new Category(new Integer(300), "Sales"),
//				"35000"));
		CategoryDao catDao = new CategoryNoDBdao();
		categoriesMap = catDao.getCategoriesMap();
	}

	public void update(Product prod) {
		Integer id = prod.getPdocutId();
		for (int i = 0; i < products.size(); i++) {
			Product temp = (Product) products.get(i);
			if (temp.getPdocutId().equals(id)) {
				prod.setCategory((Category) categoriesMap.get(prod
						.getCategory().getCategoryId()));
				break;
			}
		}
	}

	public void insert(Product prod) {
//		int lastId = 0;
//		Iterator<Product> iter = products.iterator();
//		while (iter.hasNext()) {
//			Product temp = (Product) iter.next();
//			if (temp.getPdocutId().intValue() > lastId) {
//				lastId = temp.getPdocutId().intValue();
//			}
//		}
//		prod.setCategory((Category) categoriesMap.get(prod.getCategory()
//				.getCategoryId()));
//		prod.setPdocutId(new Integer(lastId + 1));
//		products.add(prod);
		writeIntoDatabase(prod);
	}

	public void delete(Integer id) {
		for (int i = 0; i < products.size(); i++) {
			Product temp = (Product) products.get(i);
			if (temp.getPdocutId().equals(id)) {
				products.remove(i);
				break;
			}
		}
	}

	@Override
	public List<Product> getAllProducts() {
		try {
			return readPorductsFromDB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product getProduct(Integer id) {
		Product prod = null;
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			prod = (Product) iter.next();
			if (prod.getPdocutId().equals(id)) {
				break;
			}
		}
		return prod;
	}

	public void readDatabase() {
		Connection conn = null;
		String name = "";
		try {
			String URL = "jdbc:mysql://localhost/struts_tutorial";
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("loaded driver successfully...");
			conn = DriverManager.getConnection(URL, "root", "root123");
			String sql = "SELECT name FROM login";
			// sql+=" user = ? AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			// ps.setString(1, user);
			// ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				name = rs.getString(1);
				System.out.println("Name:" + name);
				// ret = SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<Product> readPorductsFromDB() throws Exception{
		Connection dbConnection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT * FROM Product";

		try {
			dbConnection = DBUtil.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			//preparedStatement.setInt(1, 1001);

			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();

			products = new ArrayList<Product>();
			while (rs.next()) {

				int prodId = rs.getInt("Product_ID");
				int barcodeId = rs.getInt("Barcode_ID");
				String prodName = rs.getString("Product_Name");
				String prodType = rs.getString("Product_Type");
				String prodDesc = rs.getString("Product_Description");
				String otherInfo = rs.getString("Product_Other_Details");
					
				Product p = new Product();
				p.setBarcodeId(barcodeId);
				p.setDescription(prodDesc);
				p.setName(prodName);
				p.setType(prodType);
				p.setOtherInfo(otherInfo);
				p.setPdocutId(prodId);
				products.add(p);
				
				System.out.println("prodId : " + prodId);
				System.out.println("prodName : " + prodName);

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
		return products;
	}

	public void writeIntoDatabase(Product prod) {
		Connection conn = null;
		String name = "";
		PreparedStatement ps = null;
		try {
			// String URL = "jdbc:mysql://localhost/struts_tutorial";
			// Class.forName("com.mysql.jdbc.Driver");
			// System.out.println("loaded driver successfully...");
			// conn = DriverManager.getConnection(URL, "root", "root123");

			conn = DBUtil.getDBConnection();

			String insertTableSQL = "INSERT INTO Product"
					+ "(Barcode_ID, Product_Name, Product_Type,Product_Description,Product_Other_Details) VALUES"
					+ "(?,?,?,?,?)";

			ps = conn.prepareStatement(insertTableSQL);
			//ps.setInt(1, prod.getPdocutId());
			ps.setInt(1, prod.getBarcodeId());
			ps.setString(2, prod.getDescription());
			if(prod.getCategory()==null){
				ps.setInt(3, 0);
			}else{
				ps.setInt(3, prod.getCategory().getCategoryId());
			}
			ps.setString(4, prod.getDescription());
			ps.setString(5, prod.getOtherInfo());

			ps.executeUpdate();
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

}
