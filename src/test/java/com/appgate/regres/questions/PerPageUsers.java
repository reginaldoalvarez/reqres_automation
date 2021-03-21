package com.appgate.regres.questions;

import com.appgate.regres.models.User;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class PerPageUsers implements Question<Integer> {

	@Override
	public Integer answeredBy(Actor actor) {
		return SerenityRest.lastResponse().body().jsonPath().getList("data", User.class).size();
	}

}
