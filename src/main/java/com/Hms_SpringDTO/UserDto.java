package com.Hms_SpringDTO;
//importing required classes and packages
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.Hms_SpringModel.Room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Adding required annotation from lombok to reduce boilerplate code
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	//using Regex validation annotations to validate the user's entered data.
	@NotNull(message="user id cannot be null")
	private long userId;
	@NotEmpty(message="Username cannot be empty")
	private String userName;
	@Pattern(regexp = "^((?=.*[A-Z])(?=.*[!@#$&*])([a-z0-9])){4,12}$",
            message = "Your password is not that much strong..!\n Use atleast one uppercase letter and spcl character to make it strong..!")
	private String userPassword;
	@Pattern(regexp="[0-9]{10}")
	private String userContact;
	@Email(message = "Email should be valid")
	private String userEmail;
	@NotNull(message="role cannot be empty")
	private String userRole;
	@Min(1000)
	@Max(8000)
	private long userFee;
	private Room userRoom;

}
