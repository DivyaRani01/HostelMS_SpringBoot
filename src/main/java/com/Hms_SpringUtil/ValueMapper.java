package com.Hms_SpringUtil;
//importing required classes and packages
import com.Hms_SpringDTO.RoomDto;
import com.Hms_SpringDTO.UserDto;
import com.Hms_SpringModel.Room;
import com.Hms_SpringModel.User;

//creating a value mapper class to Map the userDto value to a user value.
public class ValueMapper {
 
	//method 1 -> to convert userdto value to user value
	public static User convertoUser(UserDto u1) {
		User u2=new User(u1.getUserId(), u1.getUserName(),u1.getUserPassword(),u1.getUserContact(),u1.getUserEmail(),u1.getUserRole(),u1.getUserFee(),u1.getUserRoom());
		
		return u2;	
	}
	
	//method 2 -> to convert Roomdto value to room value
	public static Room convertoRoom(RoomDto r1) {
		
		Room r2=new Room(r1.getRoomId(),r1.getRoomName(),r1.getRoomType());
		return r2;
	}
}
