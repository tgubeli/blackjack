package com.redhat.samples.blackjack.model.obp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ObpUserData {
	
//	{  "email":"chrystian@example.com",  
//	"username":"chrystian",  
//	"password":"Dealerr3dh4t1!",  
//	"first_name":"Chrystian",  
//	"last_name":"Duarte"}
	
	private String email;
	private String username;
	private String password;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	

}
