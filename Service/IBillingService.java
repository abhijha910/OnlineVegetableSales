package org.vegetablesales.Service;

import org.vegetablesales.Model.BillingDetails;

public interface IBillingService {
	public BillingDetails addBill(BillingDetails bill);
	public BillingDetails updateBill(BillingDetails bill);
	public BillingDetails viewBill(Integer billId);
}
