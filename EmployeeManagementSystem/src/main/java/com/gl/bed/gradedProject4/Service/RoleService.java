package com.gl.bed.gradedProject4.Service;

import java.util.List;

import com.gl.bed.gradedProject4.Entity.Role;

public interface RoleService {
	Role saveRole(Role role);

	List<Role> fetchAllRoles();
}
