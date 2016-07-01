package com.dao;
import com.model.Resource;
import com.model.Role;

public interface RoleDao {

	public Role createRole(Role role)throws Exception;
	public boolean deleteRole(Resource resource)throws Exception;
	public Role updateRole(Role role)throws Exception;
	//public Role getRoleById(Role role) throws Exception;
}
