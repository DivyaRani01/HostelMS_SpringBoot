package com.Hms_SpringServiceIMP;
//importing required classes and packages
import java.util.List;

import com.Hms_SpringDTO.RoomDto;
import com.Hms_SpringException.GlobalException;
import com.Hms_SpringModel.Room;
import com.Hms_SpringRepository.RoomRepo;
import com.Hms_SpringService.RoomService;
import com.Hms_SpringUtil.ValueMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//Using class level annotation 
@Service
public class RoomServiceIMP implements RoomService{
	
	//injecting repository class object
	@Autowired
	private RoomRepo repo;

	//Method1 -> to add room in the database
	@Override
	public Room addRoom(RoomDto r1) {
		// TODO Auto-generated method stub
		Room r2=ValueMapper.convertoRoom(r1);
		return repo.save(r2);
	}

	//Method2 -> to show all the room in the database
	@Override
	public List<Room> getRoom() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	//Method3 -> to update the roomdata in the database
	@Override
	public Room updateRoom(RoomDto r1) {
		// TODO Auto-generated method stub
		Room r2=ValueMapper.convertoRoom(r1);
		return repo.save(r2);
	}

	//Method4 -> to delete the room from the database
	@Override
	public String deleteRoom(long roomid) throws GlobalException {
		// TODO Auto-generated method stub
		Room r2=repo.findByRoomId(roomid);
		if(r2!=null) {
			repo.deleteById(roomid);
			return "Succesfully Deleted the Room..!";
		}
		else {
			throw new GlobalException("Room Not EXIST..!");
		}
	}
	

}
