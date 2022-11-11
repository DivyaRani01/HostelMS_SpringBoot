package com.Hms_SpringRepository;
//importing required classes and packages
import com.Hms_SpringModel.Room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//creatinga interface roomrepo which extends jparepository
@Repository
public interface RoomRepo extends JpaRepository<Room,Long>  {
	
	@Query(value="select * from Room where room_id=?1",nativeQuery=true)
	Room findByRoomId(long roomid);

}
