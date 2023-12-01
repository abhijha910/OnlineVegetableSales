package org.vegetablesales.Model;

import java.time.LocalDate;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer orderId;
	@OneToMany
	private List<VegetableDTO> vegetableList;
	private Double totalAmount;
	private String orderStatus;
	@OneToOne
	private BillingDetails billing; 
	@OneToOne
	private Customer customer;
	private LocalDate orderDate;
	public Orders() {
		
	}
	public Orders(Integer orderId, List<VegetableDTO> vegetableList, Double totalAmount, String orderStatus,
			BillingDetails billing, Customer customer, LocalDate orderDate) {
		super();
		this.orderId = orderId;
		this.vegetableList = vegetableList;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.billing = billing;
		this.customer = customer;
		this.orderDate = orderDate;
	}



	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public List<VegetableDTO> getVegetableList() {
		return vegetableList;
	}
	public void setVegetableList(List<VegetableDTO> vegetableList) {
		this.vegetableList = vegetableList;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public BillingDetails getBilling() {
		return billing;
	}

	public void setBilling(BillingDetails billing) {
		this.billing = billing;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", vegetableList=" + vegetableList + ", totalAmount=" + totalAmount
				+ ", orderStatus=" + orderStatus + ", billing=" + billing + ", customer=" + customer + ", orderDate="
				+ orderDate + "]";
	}



	

}
