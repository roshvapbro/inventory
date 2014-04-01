package com.vapbro.dao;

import java.util.List;
import java.util.Map;

import com.vapbro.model.Category;
import com.vapbro.model.Product;

public interface CategoryDao
{
    public List<Category> getAllCategories();

    public Map<Integer, Category> getCategoriesMap();
    

    public Category getCategory(Integer id);

    public void update(Category cat);

    public void insert(Category cat);

    public void delete(Integer id);
}
