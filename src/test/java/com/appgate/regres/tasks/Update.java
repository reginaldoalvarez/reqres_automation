package com.appgate.regres.tasks;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

import com.appgate.regres.models.UserCreateResponse;
import com.appgate.regres.models.UserUpdateRequest;
import com.appgate.regres.models.UserUpdateResponse;
import com.google.gson.Gson;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class Update implements Task{
	
	private final UserUpdateRequest UserUpdateRequest;
	private String id;
	
	public Update(UserUpdateRequest UserUpdateRequest) {
		this.UserUpdateRequest = UserUpdateRequest;
		this.id=UserCreateResponse.getUserCreateResponse().getId();
	}
	

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Put.to("/api/users/" + id).with(
						request -> 
							request.header("Content-Type", "application/json")
							.body(new Gson().toJson(UserUpdateRequest))));
		UserUpdateResponse.setUserUpdateResponse(new Gson().fromJson(lastResponse().getBody().asString(), UserUpdateResponse.class)); 
	}
	
	public Update withId(String id) {
		this.id=id;
		return this;
	}
	
	public static Update anUser(UserUpdateRequest userCreateRequest) {
		return Tasks.instrumented(Update.class, userCreateRequest);
	}
	
}
