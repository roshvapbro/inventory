package com.vapbro.service;

import java.util.List;

import com.vapbro.dao.ProductDBdao;
import com.vapbro.dao.ProductDao;
import com.vapbro.model.Product;

public class ProductDaoService implements ProductService
{
    private ProductDao dao;

    public ProductDaoService()
    {
        this.dao = new ProductDBdao();
    }

   
	@Override
	public List<Product> getAllProducts() {
	   return dao.getAllProducts();
	}

	@Override
	public void updateProduct(Product prod) {
		 dao.update(prod);
	}

	@Override
	public void deleteProduct(Integer id) {
	     dao.delete(id);	     	
	}

	@Override
	public Product getProduct(Integer id) {
		 return dao.getProduct(id);
	}

	@Override
	public void insertProduct(Product prod) {
		dao.insert(prod);
	}
}
