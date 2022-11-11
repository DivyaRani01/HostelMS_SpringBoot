package com.Hms_Spring;

import com.Hms_SpringException.GlobalException;
import com.Hms_SpringServiceIMP.UserServiceIMP;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTEST {
	
	@Autowired
	private UserServiceIMP service;

	//positive test case 
	@Test
	void proTestDelete()throws GlobalException {
		
		var expected="deleted Succesfully";
			var actual=service.deleteUser(2);
			assertSame(expected,actual);
	}
	
	//negative test case-> user doesn't exist
	@Test
	void consTestDelete()throws GlobalException {
		var expected="deleted Succesfully";
			var actual=service.deleteUser(1001);
			assertSame(expected,actual);
	}
	
	//positive test case->As user is existed and details are valid to update
	@Test
	void positiveTestPhone()throws GlobalException {
		var expected="updated!...";
			var actual=service.updateContact(3,"9876543212");
			assertSame(expected,actual);
	}
	
	//negative test case->user having wrong data
	@Test
	void negativeTestPhone()throws GlobalException {
		var expected="deleted Succesfully";
			var actual=service.updateContact(1001,"090989098765");
			assertSame(expected,actual);
		}
}
