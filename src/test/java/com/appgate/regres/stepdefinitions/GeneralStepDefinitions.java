package com.appgate.regres.stepdefinitions;

import com.appgate.regres.models.Root;
import com.appgate.regres.models.User;
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
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
public class GeneralStepDefinitions {

    @Before
    public void before(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("that {actor} connects to the api")
    public void thatPedroConnectsToTheApi(Actor actor) {
        actor.whoCan(CallAnApi.at("https://reqres.in/api"));
    }


    @When("he get the list of user in the page {int}")
    public void heGetTheListOfUserInThePage(Integer page) {
        theActorInTheSpotlight().attemptsTo(Get.resource("/users?page=" + page ));
    }

    @Then("he should see a maximum of {int} users per page")
    public void heShouldSeeAMaximumOfUsersPerPage(Integer userPerPage) {
        theActorInTheSpotlight().attemptsTo(Ensure.that(userPerPage).isEqualTo(SerenityRest.lastResponse().as(Root.class).getData().size()));
    }

    @When("he tries to log with credentials")
    public void heTriesToLogWithCredentials(List<User> users) {
        theActorInTheSpotlight().attemptsTo(Post.to("/login").withRequest(request -> request.body(users.get(0))));
    }

    @Then("he should see the status code {int}")
    public void heShouldSeeTheStatusCode(Integer statusCode) {
        theActorInTheSpotlight().attemptsTo(Ensure.that(statusCode).isEqualTo(SerenityRest.lastResponse().statusCode()));
    }

}
