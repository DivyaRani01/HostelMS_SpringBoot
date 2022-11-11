package com.Hms_SpringModel;
//Importing required classes and packages
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Adding annotations of lombok to reduce boilerplate code
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

	// @ID This annotation specifies the primary key of the entity
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long userId;
		private String userName;
		private String userPassword;
		private String userContact;
		private String userEmail;
		private String userRole;
		private long userFee;
		//creating manyToONe mapping as many user(student) can have one room
		@ManyToOne
		private Room userRoom;
}
