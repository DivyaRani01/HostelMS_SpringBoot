package com.Hms_SpringServiceIMP;
//importing required classes and packages
import java.util.List;

import com.Hms_SpringDTO.UserDto;
import com.Hms_SpringException.GlobalException;
import com.Hms_SpringModel.User;
import com.Hms_SpringRepository.UserRepo;
import com.Hms_SpringService.UserService;
import com.Hms_SpringUtil.ValueMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//Using class level annotation 
@Service
public class UserServiceIMP implements UserService {
	
	//injecting repository
   @Autowired
	private UserRepo urepo;

    //Method1 -> to add user in the database
	@Override
	public User addUser(UserDto u1) {
		// TODO Auto-generated method stub
		User u2=ValueMapper.convertoUser(u1);                                    //using value mapper class
		return urepo.save(u2);
	}

	//Method2 -> to show all the user in the database
	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return urepo.findAll(); 
	}

	//Method3 -> to update the user in the database
	@Override
	public User updateUser(UserDto u1) {
		// TODO Auto-generated method stub
		User u2=ValueMapper.convertoUser(u1);
		return urepo.save(u2);
	}

	//Method4 -> to delete the user from the database
	@Override
	public String deleteUser(long userid) throws GlobalException {
		// TODO Auto-generated method stub
		User u2=urepo.findByUserId(userid);
		if(u2!=null) {
			urepo.deleteById(userid);
			return "deleted";
		}
		else {
			throw new GlobalException("user not found");
		}
	}

	//Method5 -> to update the userContact detail in the database
	@Override
	public String updateContact(long userid, String phone) throws GlobalException {
		// TODO Auto-generated method stub
		long st=urepo.updatePhone(userid, phone);
		if(st==1) {
			return "Updated Sucessfully!...";
		}
		else {
			throw new GlobalException("Something went wrong..!TRY AGAIN...");
		}
	}

	//Method6 -> to allot Room to the user in the database
	@Override
	public String allotRoom(long userid, long roomid) throws GlobalException {
		// TODO Auto-generated method stub
		long st=urepo.allotRoom(userid, roomid);
		if(st==1) {
			return "Room Alloted Successfully to "+userid;
		}
		else {
			throw new GlobalException("something went wrong..!TRY AGAIN..");
		}
	}

	//Method7 -> to update the user's fee in the database
	@Override
	public String updateFee(long userid, long userfee) throws GlobalException {
		// TODO Auto-generated method stub
		long st=urepo.updateFee(userid, userfee);
		if(st==1) {
			return "Fee Updated Successfully to "+userid;
		}
		else {
			throw new GlobalException("Something went wrong..! TRY AGAIN...");
		}
	}

}
