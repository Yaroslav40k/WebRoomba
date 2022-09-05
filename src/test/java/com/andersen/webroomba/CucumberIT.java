package com.andersen.webroomba;

import com.andersen.webroomba.bdd.config.CucumberSpringConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
                glue = {"com.andersen.webroomba.bdd.steps", "com.andersen.webroomba.bdd.config"},
                features = "src/test/resources/bdd/features")
public class CucumberIT extends CucumberSpringConfig {

}
