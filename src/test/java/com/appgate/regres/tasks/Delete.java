package com.appgate.regres.tasks;

import static com.appgate.regres.models.UserCreateResponse.getUserCreateResponse;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class Delete implements Task{
	
	private final String id;
	
	public Delete(String id) {
		this.id = id;
	}
	
	public Delete() {
		this.id = getUserCreateResponse().getId();
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				net.serenitybdd.screenplay.rest.interactions.Delete.from("/api/users/" + id).with(
						request -> 
							request.header("Content-Type", "application/json")
							)
				);
	}
	
	public static Delete theLastUser() {
		return Tasks.instrumented(Delete.class);
	}
	
	public static Delete theUserWithId(String id) {
		return Tasks.instrumented(Delete.class,id);
	}
	
}
