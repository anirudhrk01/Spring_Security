package com.gl.bed.gradedProject4.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.bed.gradedProject4.Entity.User;
import com.gl.bed.gradedProject4.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public User addUser(User user) {
		return userService.addUser(user);
	}

}
