package com.Hms_SpringController;
//importing required classes and packages
import java.util.List;
import javax.validation.Valid;
import com.Hms_SpringDTO.RoomDto;
import com.Hms_SpringException.GlobalException;
import com.Hms_SpringModel.Room;
import com.Hms_SpringServiceIMP.RoomServiceIMP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//using class level annotation
@RestController
@RequestMapping("/room")
public class RoomController {
	//injecting serviceimp
	@Autowired
	private RoomServiceIMP service;
	
	@GetMapping("/get")
	public ResponseEntity<List<Room>> getRooms(){
		return new ResponseEntity<>(service.getRoom(),HttpStatus.OK);	
	}
	
	@PostMapping("/add")
	public ResponseEntity<Room> addRoom(@RequestBody @Valid RoomDto r1){
		
		return new ResponseEntity<>(service.addRoom(r1),HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Room> updateRoom(@RequestBody @Valid RoomDto r1){
		
		return new ResponseEntity<>(service.updateRoom(r1),HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/delete/{roomid}")
	public ResponseEntity<String> deleteRoom(@PathVariable long roomid) throws GlobalException{
		
		String st=service.deleteRoom(roomid);
		if(st!=null) {
			return new ResponseEntity<>(st,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(st,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
