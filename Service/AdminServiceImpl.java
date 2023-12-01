package org.vegetablesales.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vegetablesales.Model.Admin;
import org.vegetablesales.Model.User;
import org.vegetablesales.Repository.AdminRepository;
@Service
public class AdminServiceImpl implements IAdminService{
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private IUserService userService;
	@Autowired
	private User user;

	@Override
	public Admin addAdmin(Admin admin) {
		userService.addUser(admin.getEmailid(), admin.getPassword(), "Admin");
		return adminRepository.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		Optional<Admin> opt = adminRepository.findById(admin.getAdminId());
		user.setUserId(userService.viewByEmail(opt.get().getEmailid()).getUserId());
		user.setEmail(admin.getEmailid());
		user.setPassword(admin.getPassword());
		user.setRole("Admin");
		userService.updateUser(user);
		return adminRepository.save(admin);
	}

	@Override
	public Admin removeAdmin(Integer adminId) {
		Optional<Admin> opt1 = adminRepository.findById(adminId);
		Admin ad = opt1.get();
		userService.deleteUser(userService.viewByEmail(ad.getEmailid()).getUserId());
		Optional<Admin> opt = adminRepository.findById(adminId);
        if(opt.isPresent()){
            Admin admin = opt.get();
            adminRepository.delete(admin);
            return admin;
        }
        return null;
	}

	@Override
	public Admin viewAdmin(Integer adminId) {
		Optional<Admin> opt = adminRepository.findById(adminId);
        if(opt.isPresent()){
            Admin admin = opt.get();
            return admin;
        }
		return null;
	}

	@Override
	public List<Admin> viewAdminList() {
		return adminRepository.findAll();
	}

}
