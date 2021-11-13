package com.appgate.regres.stepdefinitions;


import io.cucumber.java.ParameterType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.Map;

public class ParameterDefinitions {


	@ParameterType(".*")
	public Actor actor(String actorName) {
		return OnStage.theActorCalled(actorName);
	}


}