package org.vegetablesales.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vegetablesales.Model.Customer;
import org.vegetablesales.Model.Feedback;
import org.vegetablesales.Model.Orders;
import org.vegetablesales.Repository.OrdersRepository;

@Service
public class OrdersServiceImpl implements IOrdersService{
	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private Customer customer;

	@Override
	public Orders addOrder(Orders order) {
		return ordersRepository.save(order);
	}

	@Override
	public Orders updateOrder(Orders order) {
		return ordersRepository.save(order);
	}

	@Override
	public Orders cancelOrder(Integer orderId) {
		Optional<Orders> opt = ordersRepository.findById(orderId);
        if(opt.isPresent()){
        	Orders order = opt.get();
        	ordersRepository.delete(order);
            return order;
        }
		return null;
	}

	@Override
	public Orders viewOrder(Integer orderId) {
		Optional<Orders> opt = ordersRepository.findById(orderId);
        if(opt.isPresent()){
        	Orders order = opt.get();
            return order;
        }
		return null;
	}

	@Override
	public List<Orders> viewAllOrders(Integer custId) {
		List<Orders> list1 = ordersRepository.findAll();
		List<Orders> list2 = new ArrayList<>();
		for(Orders order:list1) {
			customer = order.getCustomer();
			if(customer.getCustomerId()==custId)
				list2.add(order);
		}
        if(list2.isEmpty())
            return null;
        return list2;
	}

	@Override
	public List<Orders> viewOrderList() {
		return ordersRepository.findAll();
	}

}
