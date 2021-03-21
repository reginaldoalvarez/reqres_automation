package com.appgate.regres.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.core.annotations.Step;

public class GetAllUsers implements Task{
	
	private final int page;
	
	public GetAllUsers() {
		this.page=1;
	}
		
	public GetAllUsers(int page) {
		super();
		this.page = page;
	}

	@Override
	@Step("{0} searches the user with #id")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Get.resource("/api/users?page=" + page ));
	}
	
	
}
