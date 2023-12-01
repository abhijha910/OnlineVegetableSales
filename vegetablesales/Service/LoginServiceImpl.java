package org.vegetablesales.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vegetablesales.Model.User;
import org.vegetablesales.Repository.UserRepository;
@Service
public class LoginServiceImpl implements ILoginService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private User user;
	
	@Override
	public User validateLogin(String email,String password) {
		user = userRepository.findByEmail(email); 
		if(user==null)
			return null;
		else {
			if(!user.getPassword().equals(password))
				return null;
			else
				return user;
		}
	}
}
