package com.appgate.regres.questions;

import com.appgate.regres.models.User;
import com.appgate.regres.tasks.Find;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TotalPages implements Question<Integer> {

	@Override
	public Integer answeredBy(Actor actor) {
		int contPages = 0;
		while (!SerenityRest.lastResponse().body().jsonPath().getList("data", User.class).isEmpty()) {
			contPages++;
			actor.attemptsTo(Find.AllUsersWithPage(SerenityRest.lastResponse().body().jsonPath().getInt("page") + 1));
		}
		return contPages;
	}

}
