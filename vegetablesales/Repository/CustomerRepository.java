package org.vegetablesales.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vegetablesales.Model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer>{
	public Customer findByEmail(String email);
}
