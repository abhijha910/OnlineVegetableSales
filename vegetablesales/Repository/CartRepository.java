package org.vegetablesales.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vegetablesales.Model.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{

}
