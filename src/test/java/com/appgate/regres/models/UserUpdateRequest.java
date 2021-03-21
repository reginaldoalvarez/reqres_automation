package com.appgate.regres.models;

public class UserUpdateRequest{
	
	private String name;
	private String job;
	
	private static UserUpdateRequest userUpdateRequest;
	
	public UserUpdateRequest(String name, String job) {
		this.name=name;
		this.job=job;
	}
	
	public static UserUpdateRequest getUserUpdateRequest() {
		return userUpdateRequest;
	}

	public static void setUserUpdateRequest(UserUpdateRequest userUpdateRequest) {
		UserUpdateRequest.userUpdateRequest = userUpdateRequest;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

}
