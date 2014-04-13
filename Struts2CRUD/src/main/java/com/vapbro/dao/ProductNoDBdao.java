package com.vapbro.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vapbro.model.Category;
import com.vapbro.model.Product;

public class ProductNoDBdao implements ProductDao {
	private static Map<Integer, Category> categoriesMap;
	private static ArrayList<Product> products;
	static {
		products = new ArrayList<Product>();
		products.add(new Product(new Integer(1), "test","colgate", "Doe", new Integer(
				36), new Category(new Integer(100), "Accounting"), "50000"));
		products.add(new Product(new Integer(2),"test", "pepsodent", "Smith",
				new Integer(25), new Category(new Integer(300), "Sales"),
				"35000"));
		CategoryDao catDao = new CategoryNoDBdao();
		categoriesMap = catDao.getCategoriesMap();
	}

	
	public void update(Product prod) {
		Integer id = prod.getPdocutId();
		for (int i = 0; i < products.size(); i++) {
			Product temp = (Product) products.get(i);
			if (temp.getPdocutId().equals(id)) {
				prod.setCategory((Category) categoriesMap.get(prod.getCategory().getCategoryId()));
				break;
			}
		}
	}

	public void insert(Product prod) {
		int lastId = 0;
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product temp = (Product) iter.next();
			if (temp.getPdocutId().intValue() > lastId) {
				lastId = temp.getPdocutId().intValue();
			}
		}
		prod.setCategory((Category) categoriesMap.get(prod.getCategory().getCategoryId()));
		prod.setPdocutId(new Integer(lastId + 1));
		products.add(prod);
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
		return products;
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
}
