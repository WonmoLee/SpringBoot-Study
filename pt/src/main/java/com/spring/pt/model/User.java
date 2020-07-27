package com.spring.pt.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	private int id;
	private String userName;
	private String passWord;
	private String email;
	private String profile;
	private String role;
	private Timestamp createDate;
	
}
