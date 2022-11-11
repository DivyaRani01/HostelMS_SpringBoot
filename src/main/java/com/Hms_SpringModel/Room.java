package com.Hms_SpringModel;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Adding annotations of lombok to reduce boilerplate code
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {
	
	// @ID This annotation specifies the primary key of the entity
		@Id
		private long roomId;
		private String roomName;
		private String roomType;


}
