package org.vegetablesales.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
@Entity
public class VegetableDTO {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer vegId;
	private String name;
	private String type;
	private Double price;
	private Integer quantity;
//	@ManyToOne
//	private Cart cart;
	public VegetableDTO() {
		
	}
	
	public VegetableDTO(Integer vegId, String name, String type, Double price, Integer quantity) {
		super();
		this.vegId = vegId;
		this.name = name;
		this.type = type;
		this.price = price;
		this.quantity = quantity;
		//this.cart = cart;
	}

	public Integer getVegId() {
		return vegId;
	}
	public void setVegId(Integer vegId) {
		this.vegId = vegId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
//	public Cart getCart() {
//		return cart;
//	}
//
//	public void setCart(Cart cart) {
//		this.cart = cart;
//	}

	@Override
	public String toString() {
		return "VegetableDTO [vegId=" + vegId + ", name=" + name + ", type=" + type + ", price=" + price + ", quantity="
				+ quantity + "]";
	}

	
}
