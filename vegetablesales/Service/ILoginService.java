package org.vegetablesales.Service;

import org.vegetablesales.Model.User;

public interface ILoginService {
	public User validateLogin(String email,String password);
	
}
