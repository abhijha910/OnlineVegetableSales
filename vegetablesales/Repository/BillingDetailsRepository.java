package org.vegetablesales.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vegetablesales.Model.BillingDetails;
@Repository
public interface BillingDetailsRepository extends JpaRepository<BillingDetails,Integer>{

}
