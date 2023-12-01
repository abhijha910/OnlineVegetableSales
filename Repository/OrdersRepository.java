package org.vegetablesales.Repository;






import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vegetablesales.Model.Orders;
@Repository
public interface OrdersRepository extends JpaRepository<Orders,Integer>{
}
