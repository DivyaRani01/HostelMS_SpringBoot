package com.Hms_SpringService;
//importing required classes and packages
import java.util.List;

import com.Hms_SpringDTO.RoomDto;
import com.Hms_SpringException.GlobalException;
import com.Hms_SpringModel.Room;

//creating service interface for data abstraction
public interface RoomService {
	
	//creating unimplemented methods
	public Room addRoom(RoomDto r1);
	public List<Room> getRoom();
	public Room updateRoom(RoomDto r1);
	public String deleteRoom(long roomid) throws GlobalException;
	
	


}
