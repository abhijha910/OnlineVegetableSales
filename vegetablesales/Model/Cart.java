package org.vegetablesales.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
@Entity
@Component
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cartId;
	@OneToMany
	private List<VegetableDTO> vegetable = new ArrayList<>();
	public Cart() {
		
	}
	
	public Cart(Integer cartId, List<VegetableDTO> vegetable) {
		super();
		this.cartId = cartId;
		this.vegetable = vegetable;
	}

	public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	
	public List<VegetableDTO> getVegetable() {
		return vegetable;
	}
	public void setVegetable(List<VegetableDTO> vegetable) {
		this.vegetable = vegetable;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", vegetable=" + vegetable + "]";
	}
	
}
