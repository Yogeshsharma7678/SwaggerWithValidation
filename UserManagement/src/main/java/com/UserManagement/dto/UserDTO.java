package com.UserManagement.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	@NotNull(message = "id can't be null")
	private int userId;
	
	@NotNull(message = "username can't be null")
	private String userName;
	
	@Pattern(regexp = "[0-9]{10}")
	private String userPhone;
	
	@Email
	private String userEmail;
	
	@Pattern(regexp = "[a-zA-Z0-9#$]{6-15}")
	private String userPassword;
	
}
