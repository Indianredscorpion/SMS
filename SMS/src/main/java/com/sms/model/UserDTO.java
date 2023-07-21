package com.sms.model;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sms.entity.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	private int id;
	
	@NotNull(message="Username cannot be null")
	@NotBlank(message="Username is required")
	@Size(max=20, message="Maximum 20 characters allowed")
	@Size(min=2, message="Minimum 2 values required")
	private String userName;
	
	@NotNull(message="Password cannot be null")
	@NotBlank(message="Password is required")
	@Size(max=20, message="Maximum 20 characters allowed")
	@Size(min=4, message="Minimum 4 values required")
	private String password;
	
	@OneToOne
	private Role role;
}
