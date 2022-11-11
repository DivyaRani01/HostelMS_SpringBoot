package com.Hms_SpringRepository;
import com.Hms_SpringModel.User;

//importing required classes and packages
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//creatinga interface userrepo which extends jparepository
@Repository
public interface UserRepo extends JpaRepository<User,Long> {
	
	//using springframework different annotation as per requirement
	@Query(value="select * from User where user_id=?1",nativeQuery=true)
	User findByUserId(long userid);

	@Query(value="select * from User where user_name=?1",nativeQuery=true)
	User findByUserName(String username);
	
	@Transactional 
	@Modifying
	@Query(value="update User set user_phone=:userphone where user_id=:userid")
	int updatePhone(long userid,String userphone);
	
	@Transactional 
	@Modifying
	@Query(value="update User set user_fee=:userFee where user_id=:userid")
	long updateFee(long userid,long userFee);
	
	
	
	@Transactional 
	@Modifying
	@Query(value="update User set user_room_room_id=:roomid where user_id=:userid")
	long allotRoom(long userid,long roomid);

}
