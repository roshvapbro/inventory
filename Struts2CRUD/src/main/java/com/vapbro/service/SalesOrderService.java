package com.vapbro.service;

import java.util.List;

import com.vapbro.model.SalesOrder;;

public interface SalesOrderService
{
    public List<SalesOrder> getAllSalesOrders();

    public void updateSalesOrder(SalesOrder so);

    public void deleteSalesOrder(Integer id);

    public SalesOrder getSalesOrder(Integer id);

    public void insertSalesOrder(SalesOrder so);
}
