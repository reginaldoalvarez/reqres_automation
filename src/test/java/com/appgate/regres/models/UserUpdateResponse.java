package com.appgate.regres.models;

public class UserUpdateResponse {

	private String updatedAt;
	private String name;
	private String job;
	
	private static UserUpdateResponse userUpdateResponse;
	
	public UserUpdateResponse(String updatedAt , String name, String job) {
		this.updatedAt=updatedAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getName() {
		if (name != null) {
			return name;
		}
		return "";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		if (job != null) {
			return job;
		}
		return "";
	}

	public void setJob(String job) {
		this.job = job;
	}

	public static UserUpdateResponse getUserUpdateResponse() {
		return userUpdateResponse;
	}

	public static void setUserUpdateResponse(UserUpdateResponse userUpdateResponse) {
		UserUpdateResponse.userUpdateResponse = userUpdateResponse;
	}

	@Override
	public String toString() {
		return "UserUpdateResponse [updatedAt=" + updatedAt + ", name=" + name + ", job=" + job + "]";
	}

}
