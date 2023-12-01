package org.vegetablesales.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vegetablesales.Model.Cart;
import org.vegetablesales.Model.VegetableDTO;
import org.vegetablesales.Repository.CartRepository;


@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	private Cart cart;
	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart addCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public Cart getCartById(Integer cartId) {
		Optional<Cart> opt = cartRepository.findById(cartId);
		if(opt.isPresent())
			return opt.get();
		return null;
	}
	@Override
	public VegetableDTO addToCart(VegetableDTO veg) {
		List<VegetableDTO> list = cart.getVegetable();
		list.add(veg);
		return veg;
	}

	@Override
	public Cart increaseVegQuantity(Integer vegId, Integer quantity) {
		List<VegetableDTO> list = cart.getVegetable();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getVegId()==vegId) {
				int q=list.get(i).getQuantity()+quantity;
				list.get(i).setQuantity(q);
			}
			cart.setVegetable(list);
		}
		return cart;
	}

	@Override
	public Cart decreaseVegQuantity(Integer vegId, Integer quantity) {
		List<VegetableDTO> list = cart.getVegetable();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getVegId()==vegId) {
				int q=list.get(i).getQuantity()-quantity;
				list.get(i).setQuantity(q);
			}
			cart.setVegetable(list);
		}
		return cart;
	}

	@Override
	public Cart removeVegetable(Integer vegId) {
		List<VegetableDTO> list = cart.getVegetable();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getVegId()==vegId) {
				list.remove(i);
			}
			cart.setVegetable(list);
		}
		return cart;
	}

	@Override
	public Cart removeAllVegetables() {
		List<VegetableDTO> list = cart.getVegetable();
		list.clear();
		cart.setVegetable(list);
		return cart;
	}

	@Override
	public List<VegetableDTO> viewAllItems() {
		List<VegetableDTO> list = cart.getVegetable();
		return list;
	}

	

}
