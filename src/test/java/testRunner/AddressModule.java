package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\sugan\\eclipse-workspace\\amazon\\src\\test\\java\\addressBDDFramework\\address.feature",glue= {"C:\\Users\\sugan\\eclipse-workspace\\amazon\\src\\test\\java\\testRunner\\AddressModule.java"},
plugin={"pretty","html:target/Htmlreport.html"},monochrome=true)



public class AddressModule {
	

}
