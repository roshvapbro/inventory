package com.vapbro.dao;

import java.util.List;

import com.vapbro.model.Product;

public interface ProductDao
{
    public List<Product> getAllProducts();

    public Product getProduct(Integer id);

    public void update(Product prod);

    public void insert(Product prod);

    public void delete(Integer id);
}
