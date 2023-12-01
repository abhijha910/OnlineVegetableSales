package org.vegetablesales.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vegetablesales.Model.User;
import org.vegetablesales.Repository.UserRepository;
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private UserRepository userRepository;
//	@Autowired
//	private User user;

	@Override
	public User addUser(String email,String password,String role) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(role);
		return userRepository.save(user);
	}

	@Override
	public User viewUser(Integer userId) {
		Optional<User> opt = userRepository.findById(userId);
		if(opt.isPresent())
			return null;
		else
			return opt.get();
	}

	@Override
	public List<User> viewAllUser() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		
		return userRepository.save(user);
	}

	@Override
	public User viewByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User deleteUser(Integer userId) {
		Optional<User> opt = userRepository.findById(userId);
        if(opt.isPresent()){
            User user = opt.get();
            userRepository.delete(user);
            return user;
        }
        return null;
	}

}
