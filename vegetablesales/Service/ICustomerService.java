package org.vegetablesales.Service;

import java.util.List;

import org.vegetablesales.Model.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer removeCustomer(Integer customerId);
	public Customer viewCustomer(Integer customerId);
	public List<Customer> viewCustomerList();

}
