package org.vegetablesales.Service;

import java.util.List;


import org.vegetablesales.Model.User;

public interface IUserService {
	public User addUser(String email,String password,String role);
	public User viewUser(Integer userId);
	public User updateUser(User user);
	public User deleteUser(Integer userId);
	public User viewByEmail(String email);
	public List<User> viewAllUser();

}
