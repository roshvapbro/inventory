package com.vapbro.dao;

import java.util.*;

import com.vapbro.model.Category;
import com.vapbro.model.Product;

public class CategoryNoDBdao implements CategoryDao
{
    private static final String CONSTANT = "Accounting"; //$NON-NLS-1$
    private static List<Category> categories;
    private static Map<Integer, Category> categoriesMap;
    static
    {
    	categories = new ArrayList<Category>();
    	categories.add(new Category(new Integer(100), CONSTANT));
    	categories.add(new Category(new Integer(200), "R & D"));
    	categories.add(new Category(new Integer(300), "Sales"));
    	categoriesMap = new HashMap<Integer, Category>();
        Iterator<Category> iter = categories.iterator();
        while (iter.hasNext())
        {
            Category cat = (Category) iter.next();
            categoriesMap.put(cat.getCategoryId(), cat);
        }
    }

   	@Override
	public List<Category> getAllCategories() {
		return categories;
	}

	@Override
	public Map<Integer, Category> getCategoriesMap() {
		return categoriesMap;
	}

	@Override
	public Category getCategory(Integer id) {
		System.out.println("sql select category with id:"+id);
		return null;
	}

	@Override
	public void update(Category cat) {
		System.out.println("sql update category with cat name:"+cat.getName());		
	}

	@Override
	public void insert(Category cat) {
	    System.out.println("insert into category with name: "+cat.getName());		
	}

	@Override
	public void delete(Integer id) {
	    System.out.println("delete form category with id:"+ id);
	}
}
