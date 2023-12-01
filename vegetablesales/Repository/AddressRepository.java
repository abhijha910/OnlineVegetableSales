package org.vegetablesales.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vegetablesales.Model.Address;

public interface AddressRepository extends JpaRepository<Address,Integer>{

}
