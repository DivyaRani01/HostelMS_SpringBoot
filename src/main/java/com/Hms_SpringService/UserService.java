package com.Hms_SpringService;
//importing required classes and packages
import java.util.List;

import com.Hms_SpringDTO.UserDto;
import com.Hms_SpringException.GlobalException;
import com.Hms_SpringModel.User;

//creating service interface for data abstraction
public interface UserService {
	
	//creating unimplemented methods
	public User addUser(UserDto u1);
	public List<User> getUser();
	public User updateUser(UserDto u1);
	public String deleteUser(long userid) throws GlobalException;
	public String updateContact(long userid,String phone)throws GlobalException;
	public String allotRoom(long userid,long roomid)throws GlobalException;
	public String updateFee(long userid,long userfee)throws GlobalException;

}
