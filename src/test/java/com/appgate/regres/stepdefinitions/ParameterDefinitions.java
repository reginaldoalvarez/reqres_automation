package com.appgate.regres.stepdefinitions;

import java.util.Map;

import com.appgate.regres.models.User;
import com.appgate.regres.models.UserCreateRequest;
import com.appgate.regres.models.UserUpdateRequest;

import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

public class ParameterDefinitions {

	@ParameterType(".*")
	public Actor actor(String actorName) {
		return OnStage.theActorCalled(actorName);
	}

	@DataTableType
	public User user(Map<String, String> user) {
		return new User(user.get("first_name"), user.get("last_name"), user.get("email"), user.get("avatar"));
	}
	
	@DataTableType
	public UserCreateRequest userCreateRequest(Map<String, String> userCreate) {
		UserCreateRequest.setUserCreateRequest(new UserCreateRequest(userCreate.get("name"), userCreate.get("job")));
		return UserCreateRequest.getUserCreateRequest();
	}
	
	@DataTableType
	public UserUpdateRequest userUpdateRequest(Map<String, String> userUpdate) {
		UserUpdateRequest.setUserUpdateRequest(new UserUpdateRequest(userUpdate.get("name"), userUpdate.get("job")));
		return UserUpdateRequest.getUserUpdateRequest();
	}

}