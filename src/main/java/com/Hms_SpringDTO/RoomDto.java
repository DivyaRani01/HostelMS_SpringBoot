package com.Hms_SpringDTO;
//importing required classes and packages
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Adding required annotation from lombok to reduce boilerplate code
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomDto {
	
	//using Regex validation annotations to validate the user's entered data.
	@NotNull(message="Room id cannot be null")
	private long roomId;
	@NotNull(message="Room name cannot be null")
	private String roomName;
	@NotNull(message="Room type cannot be null")
	private String roomType;

}
