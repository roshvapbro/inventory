package com.vapbro.service;

import java.util.List;

import com.vapbro.dao.CategoryDao;
import com.vapbro.dao.CategoryNoDBdao;
import com.vapbro.model.Category;
import com.vapbro.model.Product;

public class CategoryDaoService implements CategoryService
{
    private CategoryDao dao;

    public CategoryDaoService()
    {
        this.dao = new CategoryNoDBdao();
    }

   	@Override
	public List<Category> getAllCategories() {
		return dao.getAllCategories();
	}

	@Override
	public void updateCategory(Category cat) {
		dao.update(cat);
	}

	@Override
	public void deleteCategory(Integer id) {
		dao.delete(id);
		
	}

	@Override
	public Category getCategory(Integer id) {
		return dao.getCategory(id);		
	}

	@Override
	public void insertCategory(Category cat) {
		dao.insert(cat);
	}
}
