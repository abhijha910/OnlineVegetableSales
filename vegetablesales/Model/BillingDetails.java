package org.vegetablesales.Model;

import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
@Component
@Entity
public class BillingDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer billingId;
	@OneToOne
	private Orders order;
	private String transactionMode;
	private LocalDateTime transactionDate;
	private String tranactionStatus;
	@OneToOne
	private Address billingAddress;
	public BillingDetails() {
		
	}
	
	public BillingDetails(Integer billingId, Orders order, String transactionMode, LocalDateTime transactionDate,
			String tranactionStatus, Address billingAddress) {
		super();
		this.billingId = billingId;
		this.order = order;
		this.transactionMode = transactionMode;
		this.transactionDate = transactionDate;
		this.tranactionStatus = tranactionStatus;
		this.billingAddress = billingAddress;
	}

	public Integer getBillingId() {
		return billingId;
	}
	public void setBillingId(Integer billingId) {
		this.billingId = billingId;
	}
	
	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTranactionStatus() {
		return tranactionStatus;
	}
	public void setTranactionStatus(String tranactionStatus) {
		this.tranactionStatus = tranactionStatus;
	}
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	@Override
	public String toString() {
		return "BillingDetails [billingId=" + billingId + ", order=" + order + ", transactionMode=" + transactionMode
				+ ", transactionDate=" + transactionDate + ", tranactionStatus=" + tranactionStatus
				+ ", billingAddress=" + billingAddress + "]";
	}

}
