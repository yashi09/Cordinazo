package com.pages;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.manager.UserManager;
import com.pojo.LoginDetailsDto;
import com.pojo.UserDetailsDto;

public class Login extends BasePage{
	//private HttpSession session;
	private UserManager userManager;
	private Integer userId;
	private String password;
	private String work;
	private String firstName;
	private String lastName;
	private int role;
	private String email;
	private boolean loggedIn;
	private Long phoneNo;
	private String loginEmail;
	private String loginPwd;
	
	@Override
	public void preProcess(Map<String,Object> map) {
		// TODO Auto-generated method stub
	}

	@Override
	public Map<String,Object> postProcess() {
		System.out.println("inside login postProcess. email= "+email+" .password= "+password);
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session  = null;
		if(work.equals("login")){
			if(loginEmail!=null && loginPwd!=null){
				LoginDetailsDto loginDetailsDto = userManager.getLoginDetails(loginEmail);
				String pwd =loginDetailsDto.getPwd();
				if(pwd.equals(loginPwd)){
					session = (HttpSession)context.getExternalContext().getSession(false);
					UserDetailsDto userDetailsDto = loginDetailsDto.getUserDetailsDto();
					session.setAttribute("loggedInDto", userDetailsDto);
					getContext().put("userKaObject", userDetailsDto);
					role = userDetailsDto.getRole();
					firstName = userDetailsDto.getFirstName();
					lastName = userDetailsDto.getLastName();
					System.out.println("role = "+role+" fName = "+firstName+"lName = "+lastName);
					loggedIn=true;
					
					return null;
				}
			}
		} else if(work.equals("logout")){
			loggedIn=false;
			session = (HttpSession)context.getExternalContext().getSession(false);
			session.invalidate();
		} else if(work.equals("signUp")){
			UserDetailsDto userDto = new UserDetailsDto();
			LoginDetailsDto loginDto = new LoginDetailsDto();
			userDto.setFirstName(firstName);
			userDto.setLastName(lastName);
			userDto.setEmail(email);
			userDto.setPhoneNo(phoneNo);
			userDto.setRole(role);
			loginDto.setEmail(email);
			loginDto.setPwd(password);
			//loginDto.setUserId(userId);
			loginDto.setUserDetailsDto(userDto);
			userDto.setLoginDetailsDto(loginDto);
			userManager.addUserDetails(userDto);
			
		}
		return null;
	}

	public UserManager getUserManager() {
		System.out.println("inside getUserManager in login.");
		return userManager;
	}
	public void setUserManager(UserManager userManager) {
		System.out.println("inside setUserManager in login. userManager = "+userManager);
		this.userManager = userManager;
	}


	public Integer getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		System.out.println("inside setUserId in login. user id = "+userId);
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		System.out.println("inside setPassword in login. password = "+ password);
		this.password = password;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	
}
