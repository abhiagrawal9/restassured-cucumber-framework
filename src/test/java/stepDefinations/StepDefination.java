package stepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class StepDefination {

    @Given("^User is on the login page$")
    public void user_is_on_the_login_page() throws Throwable {
        System.out.println("Given step execution");
    }

    @When("^User login in to app with valid username and password$")
    public void user_login_in_to_app_with_valid_username_and_password() throws Throwable {
    	System.out.println("When step execution");
    }

    @Then("^User should see the home page$")
    public void user_should_see_the_home_page() throws Throwable {
    	System.out.println("Then step execution");
    }

    @And("^Products are displaying$")
    public void products_are_displaying() throws Throwable {
    	System.out.println("And step execution");
    }

} 
