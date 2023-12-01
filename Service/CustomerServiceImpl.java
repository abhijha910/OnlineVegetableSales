package org.vegetablesales.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vegetablesales.Model.Address;
import org.vegetablesales.Model.Admin;
import org.vegetablesales.Model.Customer;
import org.vegetablesales.Model.User;
import org.vegetablesales.Repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements ICustomerService{
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private IUserService userService;
	@Autowired
	private User user;

	@Override
	public Customer addCustomer(Customer customer) {
		userService.addUser(customer.getEmail(), customer.getPassword(), "Customer");
		return customerRepository.save(customer);
		
		}
		

	@Override
	public Customer updateCustomer(Customer customer) {
		Optional<Customer> opt = customerRepository.findById(customer.getCustomerId());
		user.setUserId(userService.viewByEmail(opt.get().getEmail()).getUserId());
		user.setEmail(customer.getEmail());
		user.setPassword(customer.getPassword());
		user.setRole("Customer");
		userService.updateUser(user);
		return customerRepository.save(customer);
	}

	@Override
	public Customer removeCustomer(Integer customerId) {
		Optional<Customer> opt1 = customerRepository.findById(customerId);
		userService.deleteUser(userService.viewByEmail(opt1.get().getEmail()).getUserId());
		Optional<Customer> opt = customerRepository.findById(customerId);
        if(opt.isPresent()){
            Customer cstmr = opt.get();
            customerRepository.delete(cstmr);
            return cstmr;
        }
        return null;

	}

	@Override
	public Customer viewCustomer(Integer customerId) {
		Optional<Customer> opt = customerRepository.findById(customerId);
        if(opt.isPresent()){
            Customer cstmr = opt.get();
            return cstmr;
        }
        return null;
	}

	@Override
	public List<Customer> viewCustomerList() {
		return customerRepository.findAll();
	}
	
}
