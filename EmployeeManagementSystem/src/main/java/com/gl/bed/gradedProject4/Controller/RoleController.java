package com.gl.bed.gradedProject4.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.bed.gradedProject4.Entity.Role;
import com.gl.bed.gradedProject4.Service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {

	@Autowired(required = true)
	private RoleService roleService;

	@PostMapping("/add")
	public Role addRole(String name) {
		Role role = new Role();
		role.setName(name);
		return roleService.saveRole(role);
	}

	public List<Role> fetchAllRoles() {
		return roleService.fetchAllRoles();
	}
}
