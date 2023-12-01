package org.vegetablesales.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vegetablesales.Model.BillingDetails;
import org.vegetablesales.Repository.BillingDetailsRepository;
@Service
public class BillingServiceImpl implements IBillingService{
	@Autowired
	private BillingDetailsRepository billingDetailsRepository;

	@Override
	public BillingDetails addBill(BillingDetails bill) {
		return billingDetailsRepository.save(bill);
	}

	@Override
	public BillingDetails updateBill(BillingDetails bill) {
		return billingDetailsRepository.save(bill);
	}

	@Override
	public BillingDetails viewBill(Integer billId) {
		Optional<BillingDetails> opt = billingDetailsRepository.findById(billId);
        if(opt.isPresent()){
        	BillingDetails bill = opt.get();
            return bill;
        }
		return null;
	}
	

}
