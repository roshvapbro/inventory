package com.vapbro.service;

import java.util.List;

import com.vapbro.model.Product;

public interface ProductService
{
    public List<Product> getAllProducts();

    public void updateProduct(Product prod);

    public void deleteProduct(Integer id);

    public Product getProduct(Integer id);

    public void insertProduct(Product prod);
}
