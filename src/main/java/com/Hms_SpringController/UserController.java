package com.Hms_SpringController;
//importing required classes and packages
import java.util.List;
import javax.validation.Valid;
import com.Hms_SpringDTO.UserDto;
import com.Hms_SpringException.GlobalException;
import com.Hms_SpringModel.User;
import com.Hms_SpringService.UserService;
import com.Hms_SpringServiceIMP.UserServiceIMP;
import com.Hms_SpringUtil.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwt;

//using class level annotation
@RestController
@RequestMapping("/user")
public class UserController {
	
	//injecting userserviceimp
	@Autowired
	private UserServiceIMP service;
	
	@Autowired
	AuthenticationManager authManager;

	@Autowired
	JwtUtil jwt;


	@PostMapping("/authentication")
	public String generateToken(@RequestBody authRequest ar) {
	
		authManager.authenticate(
				new UsernamePasswordAuthenticationToken(ar.getUserName(),ar.getUserPassword()));
		return jwt.generateToken(ar.getUserName());
		
	}

	@GetMapping("/get")
	public ResponseEntity<List<User>> getUsers(){	
		List<User> userList=service.getUser();
		return new ResponseEntity<>(userList,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addUsers(@RequestBody @Valid UserDto u1){
		
		return new ResponseEntity<>(service.addUser(u1),HttpStatus.ACCEPTED);
		
	}

	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody @Valid UserDto u1){
		return new ResponseEntity<>(service.updateUser(u1),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{userid}")
	public ResponseEntity<String> deleteUser(@PathVariable long userid) throws GlobalException{
		
		String status=service.deleteUser(userid);
		if(status!=null) {
			return new ResponseEntity<>(status,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/phone/{id}/{phone}")
	
	public ResponseEntity<String> updatePhone(@PathVariable long id,@PathVariable String phone) throws GlobalException{
		
		return new ResponseEntity<>(service.updateContact(id, phone),HttpStatus.OK);
		
	}
	
	@PutMapping("/allotroom/{userid}/{roomid}")
	public ResponseEntity<String> allotRoom(@PathVariable long userid,@PathVariable long roomid) throws GlobalException{
		
		return new ResponseEntity<>(service.allotRoom(userid, roomid),HttpStatus.OK);
		
	}
	
	@PutMapping("/updatefee/{userid}/{userfee}")
	public ResponseEntity<String> update(@PathVariable long userid,@PathVariable long userfee) throws GlobalException{
		
		return new ResponseEntity<>(service.updateFee(userid, userfee),HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
}
