package com.vapbro.dao;

import java.util.List;

import com.vapbro.model.SalesOrder;

public interface SalesOrderDao
{
    public List<SalesOrder> getAllSalesOrders();

    public SalesOrder getSalesOrder(Integer id);

    public void update(SalesOrder so);

    public void insert(SalesOrder so);

    public void delete(Integer id);
}
