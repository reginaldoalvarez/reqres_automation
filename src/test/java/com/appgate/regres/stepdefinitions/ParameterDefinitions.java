package com.appgate.regres.stepdefinitions;


import com.appgate.regres.models.User;
import io.cucumber.java.DataTableType;
import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;
import java.util.Map;

public class ParameterDefinitions {


	@ParameterType(".*")
	public Actor actor(String actorName) {
		return OnStage.theActorCalled(actorName);
	}

	@DataTableType
	public User instatiateUser(Map<String,String> data){
		User user=new User();
		user.setEmail(data.get("email"));
		user.setAvatar(data.get("avatar"));
		user.setFirst_name(data.get("first_name"));
		user.setLast_name(data.get("last_name"));
		user.setPassword(data.get("password"));
		return user;
	}


}