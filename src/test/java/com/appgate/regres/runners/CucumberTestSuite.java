package com.appgate.regres.runners;


import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;




@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "com.appgate.regres.stepdefinitions",
		snippets = SnippetType.CAMELCASE,
		dryRun = false
		)
public class CucumberTestSuite {}
