package org.vegetablesales.Service;

import java.util.List;

import org.vegetablesales.Model.Admin;

public interface IAdminService {
	public Admin addAdmin(Admin admin);
	public Admin updateAdmin(Admin admin);
	public Admin removeAdmin(Integer adminId);
	public Admin viewAdmin(Integer adminId);
	public List<Admin> viewAdminList();
}
