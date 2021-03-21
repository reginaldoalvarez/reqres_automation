package com.appgate.regres.models;

public class UserCreateResponse{

	private String id;
	private String createdAt;
	private String name;
	private String job;
	
	
	private static UserCreateResponse userCreateResponse;
	
	public UserCreateResponse( String id, String createdAt , String name, String job) {
		this.id=id;
		this.createdAt=createdAt;
		this.name=name;
		this.job=job;
	}
	
	public static UserCreateResponse getUserCreateResponse() {
		return userCreateResponse;
	}

	public static void setUserCreateResponse(UserCreateResponse userCreateResponse) {
		UserCreateResponse.userCreateResponse = userCreateResponse;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
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
