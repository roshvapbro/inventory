package com.vapbro.service;

import java.util.List;

import com.vapbro.dao.SalesOrderDBdao;
import com.vapbro.dao.SalesOrderDao;
import com.vapbro.model.SalesOrder;

public class SalesOrderDaoService implements SalesOrderService {
	private SalesOrderDao dao;

	public SalesOrderDaoService() {
		this.dao = new SalesOrderDBdao();
	}

	@Override
	public List<SalesOrder> getAllSalesOrders() {
		return dao.getAllSalesOrders();
	}

	@Override
	public void updateSalesOrder(SalesOrder so) {
		dao.update(so);
	}

	@Override
	public void deleteSalesOrder(Integer id) {
		dao.delete(id);
	}

	@Override
	public SalesOrder getSalesOrder(Integer id) {
		return dao.getSalesOrder(id);
	}

	@Override
	public void insertSalesOrder(SalesOrder so) {
		dao.insert(so);
	}
}
