package com.Hms_Spring;

import com.Hms_SpringException.GlobalException;
import com.Hms_SpringServiceIMP.RoomServiceIMP;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Room {

	@Autowired
	private RoomServiceIMP service;
	
	//positive test case
	@Test
	void proTestDelete()throws GlobalException {
		var expected="deleted";
			var actual=service.deleteRoom(10);
			assertSame(expected,actual);
	}
	//negative test case
	@Test
	void consTestDelete()throws GlobalException {
		var expected="deleted";
			var actual=service.deleteRoom(200);
			assertSame(expected,actual);
	}
}
