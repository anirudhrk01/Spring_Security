package com.gl.bed.gradedProject4.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	private String user_name;
	private String user_password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST })

	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))

	@Builder.Default
	private List<Role> roles = new ArrayList<Role>();

	public User(String username, String password, List<Role> roles) {
		this.user_name = username;
		this.user_password = password;
		this.roles = roles;
	}
}
