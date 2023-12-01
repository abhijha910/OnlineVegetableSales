package org.vegetablesales.Service;

import java.util.List;

import org.vegetablesales.Model.Cart;
import org.vegetablesales.Model.VegetableDTO;

public interface ICartService {
	public Cart addCart(Cart cart);
	public Cart getCartById(Integer cartId);
	public VegetableDTO addToCart(VegetableDTO vegId);
	public Cart increaseVegQuantity(Integer vegId,Integer quantity);
	public Cart decreaseVegQuantity(Integer vegId,Integer quantity); 
	public Cart removeVegetable(Integer vegId);
	public Cart removeAllVegetables();
	public List<VegetableDTO> viewAllItems();
}
