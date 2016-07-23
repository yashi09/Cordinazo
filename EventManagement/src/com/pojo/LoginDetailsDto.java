package com.pojo;

public class LoginDetailsDto {
	private String pwd;
	private UserDetailsDto userDetailsDto;
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public UserDetailsDto getUserDetailsDto() {
		return userDetailsDto;
	}
	public void setUserDetailsDto(UserDetailsDto userDetailsDto) {
		this.userDetailsDto = userDetailsDto;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
