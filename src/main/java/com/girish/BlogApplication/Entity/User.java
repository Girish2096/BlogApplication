package com.girish.BlogApplication.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="User_id")
	private Integer userid;
	
	@Column(name="User_Name")
	private String username;
	
	@Column(name="User_Email")
	private String email;
	
	@Column(name="User_Password")
	private String password;
	
	@Column(name=" About ")
	private String About;

}
