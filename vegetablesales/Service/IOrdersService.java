package org.vegetablesales.Service;

import java.util.List;


import org.vegetablesales.Model.Orders;

public interface IOrdersService {
	public Orders addOrder(Orders order);
	public Orders updateOrder(Orders order);
	public Orders cancelOrder(Integer orderId);
	public Orders viewOrder(Integer orderId);
	public List<Orders> viewOrderList();
	public List<Orders> viewAllOrders(Integer custId);

}
