package com.appgate.regres.stepdefinitions;

import com.appgate.regres.models.Root;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GeneralStepDefinitions {
    @Before
    public void before(){
        OnStage.setTheStage(new OnlineCast());

    }


    @Given("that {actor} connets to the api")
    public void thatPedroConnetsToTheApi(Actor actor) {
        actor.whoCan(CallAnApi.at("https://reqres.in/api"));

    }

    @When("he get the list of user in thr page {int}")
    public void heGetTheListOfUserInThrPage(Integer page) {
        OnStage.theActorInTheSpotlight().attemptsTo(Get.resource("/users?page=" + page));

    }

    @Then("he should get a maximum {int} user per page")
    public void heShouldGetAMaximumUserPerPage(Integer userPerPage) {
        theActorInTheSpotlight().attemptsTo(Ensure.that(userPerPage)
                .isEqualTo(SerenityRest.lastResponse().as(Root.class).getData().size()));


    }

}
