package com.Hms_SpringModel;
//importing required packages and classes
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Adding annotations of lombok to reduce boilerplate code
@Data
@AllArgsConstructor
@NoArgsConstructor
public class login {
	
	//Data members
	private String userName;
	private String userPassword;

}
