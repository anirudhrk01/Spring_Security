package com.gl.bed.gradedProject4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.bed.gradedProject4.Entity.Role;
import com.gl.bed.gradedProject4.Repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public Role saveRole(Role role) {
		System.out.println("Role " + role.toString());
		return this.roleRepository.save(role);
	}

	public List<Role> fetchAllRoles() {
		return this.roleRepository.findAll();
	}

}
