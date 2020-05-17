

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.net.MalformedURLException;

public class MyStepdefs extends Pega {
    @Given("^User launches the application url$")
    public void user_launches_the_application_url() throws MalformedURLException {
        LaunchBrowser("http://52.56.199.177:8081/prweb/xKPfyQNbqfZXXEWuWAGBgVNPdU_jfS5W*/!STANDARD?", "local");
    }

    @When("^User enters valid login credentials$")
    public void userEntersValidLoginCredentials() {
        LoginValid();
    }

    @Then("^User should be able to login to the application$")
    public void userShouldBeAbleToLoginToTheApplication() {
        ValidateLogin();
    }

    @When("^User enters invalid login credentials$")
    public void userEntersInvalidLoginCredentials() {
        LoginInValid();

    }

}
