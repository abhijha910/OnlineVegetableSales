package org.vegetablesales.Model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
@Entity
public class Customer{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer customerId;
	private String name;
	private String mobileNumber;
	@OneToOne(cascade=CascadeType.ALL)
	//@JoinColumn(name="addressId")
	private Address address;
	private String email;
	private String password;
	private String confirmPassword;
	@OneToOne
	private Cart cart = new Cart();
	public Customer() {
		
	}
	
	public Customer(Integer customerId, String name, String mobileNumber, Address address, String email,
			String password, String confirmPassword, Cart cart) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.cart = cart;
	}

	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobieNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", address="
				+ address + ", email=" + email + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", cart=" + cart + "]";
	}

	

}

	
	

