package com.appgate.regres.models;

public class UserCreateRequest {
	private String name;
	private String job;
	
	private static UserCreateRequest userCreateRequest;
	
	public UserCreateRequest(String name, String job) {
		this.name = name;
		this.job = job;
	}
	

	public static UserCreateRequest getUserCreateRequest() {
		return userCreateRequest;
	}

	public static void setUserCreateRequest(UserCreateRequest userCreateRequest) {
		UserCreateRequest.userCreateRequest = userCreateRequest;
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

	@Override
	public String toString() {
		return "UserCreateRequest [name=" + name + ", job=" + job + "]";
	}
	
	
}
