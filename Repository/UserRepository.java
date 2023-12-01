package org.vegetablesales.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vegetablesales.Model.User;

public interface UserRepository extends JpaRepository<User,Integer>{
	public User findByEmail(String email);
}
