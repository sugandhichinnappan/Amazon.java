package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\sugan\\eclipse-workspace\\amazon\\src\\test\\java\\GuestBddFramework\\Guest.feature",glue= {"stepDefinationAmazon"},
plugin={"pretty","html:target/Htmlreport.html"},monochrome=true)



public class GuestUser {

}
