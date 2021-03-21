package com.appgate.regres.stepdefinitions;

import static com.appgate.regres.utils.Variables.ENV_URL;
import static com.appgate.regres.utils.Variables.loadEnvironmentVariables;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.appgate.regres.models.User;
import com.appgate.regres.models.UserCreateRequest;
import com.appgate.regres.models.UserCreateResponse;
import com.appgate.regres.models.UserUpdateRequest;
import com.appgate.regres.models.UserUpdateResponse;
import com.appgate.regres.questions.Quantity;
import com.appgate.regres.tasks.Create;
import com.appgate.regres.tasks.Delete;
import com.appgate.regres.tasks.Find;
import com.appgate.regres.tasks.Update;
import com.google.gson.Gson;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class GeneralStepDefinitions {

    @Before
    public void setTheStage() {
    	loadEnvironmentVariables();
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{actor} needs to consume the api")
    public void someoneSearchesTheUserAtPath(Actor actor) {
    	actor.whoCan(CallAnApi.at(ENV_URL));
    }
    
    @Given("he searches the user with id {int}")
    public void heSearchesTheUserWithId(Integer id) {
    	theActorInTheSpotlight().attemptsTo(Find.SigleUserWithId(id));
    }
    
    @Then("he should get the status code {int}")
    public void heShouldGetTheStatusCode(Integer statusCode) {
    	theActorInTheSpotlight().attemptsTo(Ensure.that(lastResponse().getStatusCode()).isEqualTo(statusCode));
    }
    
    @Then("he should get the same user info")
    public void heShouldGetTheUserInfo(User userInfo) {
    	theActorInTheSpotlight().attemptsTo(
    			Ensure.that(lastResponse().jsonPath().getObject("data",User.class).getAvatar()).isEqualTo(userInfo.getAvatar()),
    			Ensure.that(lastResponse().jsonPath().getObject("data",User.class).getEmail()).isEqualTo(userInfo.getEmail()),
    			Ensure.that(lastResponse().jsonPath().getObject("data",User.class).getFirst_name()).isEqualTo(userInfo.getFirst_name()),
    			Ensure.that(lastResponse().jsonPath().getObject("data",User.class).getLast_name()).isEqualTo(userInfo.getLast_name())		
    					);
    }
    
    @When("he searches all users")
    public void heSearchesAllUsers() {
    	theActorInTheSpotlight().attemptsTo(Find.AllUsers());
    }

    @Then("he should get the same as user quantity as the field TOTAL")
    public void heShouldGetTheSameAsUserQuantityAsTheFieldTOTAL() {
    	theActorInTheSpotlight().attemptsTo(
    			Ensure.thatTheAnswerTo(
    					Quantity.ofUsersIsTheSameAsFieldTotal()).isEqualTo(lastResponse().body().jsonPath().getInt("total")
    							)
    			);
    }
    
    @Then("he should get the same as user quantity as the field PER_PAGE")
    public void heShouldGetTheSameAsUserQuantityAsTheFieldPERPAGE() {
    	theActorInTheSpotlight().attemptsTo(
    			Ensure.thatTheAnswerTo(
    					Quantity.ofUsersIsTheSameAsFieldPerPage()).isEqualTo(lastResponse().body().jsonPath().getInt("per_page")
    							)
    			);
    }
    
    @Then("he should get the same as user quantity as the field TOTAL_PAGES")
    public void heShouldGetTheSameAsUserQuantityAsTheFieldTOTALPAGES() {
    	theActorInTheSpotlight().attemptsTo(
    			Ensure.thatTheAnswerTo(
    					Quantity.ofUsersIsTheSameAsFieldTotalPages()).isEqualTo(lastResponse().body().jsonPath().getInt("total_pages")
    							)
    			);
    }
    
    @When("he creates a user")
    public void heCreatesAUser(UserCreateRequest userCreateRequest) {
    	theActorInTheSpotlight().attemptsTo(Create.anUser(userCreateRequest));
    }
    
    @Then("he should get the response with the data requested")
    public void heShouldGetTheResponseWithTheDataRequested() {
    	theActorInTheSpotlight().attemptsTo(
    			Ensure.that(lastResponse().jsonPath().getObject("",UserCreateResponse.class).getId()).isNotBlank(),
    			Ensure.that(lastResponse().jsonPath().getObject("",UserCreateResponse.class).getCreatedAt()).isNotBlank(),
    			Ensure.that(lastResponse().jsonPath().getObject("",UserCreateResponse.class).getJob()).isEqualTo(UserCreateResponse.getUserCreateResponse().getJob()),
    			Ensure.that(lastResponse().jsonPath().getObject("",UserCreateResponse.class).getName()).isEqualTo(UserCreateResponse.getUserCreateResponse().getName())
    					);
    }
    
    @When("he deletes the user created")
    public void heDeletesTheUserCreated() {
        theActorInTheSpotlight().attemptsTo(Delete.theLastUser());
    }
    
    @When("he update the user last created user")
    public void heUpdateTheUserLastCreatedUser(UserUpdateRequest UserUpdateRequest) {
        theActorInTheSpotlight().attemptsTo(Update.anUser(UserUpdateRequest));
    }
    
    @Then("he should get the update response with the data requested")
    public void heShouldGetTheUpdateResponseWithTheDataRequested() {
    	theActorInTheSpotlight().attemptsTo(
    			Ensure.that(new Gson().fromJson(lastResponse().getBody().asString(), UserUpdateResponse.class).getUpdatedAt()).isNotBlank(),
    			Ensure.that(new Gson().fromJson(lastResponse().getBody().asString(), UserUpdateResponse.class).getJob()).isEqualTo(UserUpdateResponse.getUserUpdateResponse().getJob()),
    			Ensure.that(new Gson().fromJson(lastResponse().getBody().asString(), UserUpdateResponse.class).getName()).isEqualTo(UserUpdateResponse.getUserUpdateResponse().getName())
    					);
    }


}
