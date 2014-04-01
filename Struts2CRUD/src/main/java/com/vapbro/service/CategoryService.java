package com.vapbro.service;

import java.util.List;

import com.vapbro.model.Category;
import com.vapbro.model.Product;

public interface CategoryService
{
    public List<Category> getAllCategories();

    public void updateCategory(Category cat);

    public void deleteCategory(Integer id);

    public Category getCategory(Integer id);

    public void insertCategory(Category cat);
}
