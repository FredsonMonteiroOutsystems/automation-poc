package stepdefs.authentication;

import helpers.GlobalParameters;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.LoginUser;
import org.junit.Assert;
import pages.training.HomePage;
import pages.training.LoginPage;

public class LoginStepdefs {
    // Instances of pages
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    // Instances of Objects
    GlobalParameters parameters = GlobalParameters.getInstance();
    LoginUser loginUser = new LoginUser();
    // A context also could be used, but was not necessary in this case because it will be used only in this Stepdefs

    // Steps
    @When("I accept the cookies")
    public void acceptCookies() {
        homePage.acceptCookies();
    }
    @When("I access the login option")
    public void accessLoginOption() {
        homePage.accessLogin();
    }

    @And("I enter the email to login")
    public void enterEmailToLogin() {
        loginPage.fillEmailField(loginUser.getEmail());
        loginPage.pressLoginButton();
    }

    @And("I enter the password to login")
    public void enterPasswordToLogin() {
        loginPage.fillPasswordField(loginUser.getPassword());
        loginPage.pressLoginButton();
    }

    @Then("I will be redirected to training page with my user logged")
    public void userWillBeRedirectedToTrainingPageWithUserLogged() {
        String userEmail = homePage.getEmailLoggedUser();
        Assert.assertEquals("Different logged user", loginUser.getEmail(), userEmail);
    }

    @And("I have a valid User credential")
    public void iHaveAValidUserCredential() {
        String user = parameters.getProperty("USER_PORTAL_TRAINING");
        String password = parameters.getProperty("PASSWORD_PORTAL_TRAINING");

        // Double check is necessary because of missing parameters in cloud executions environment
        Assert.assertNotNull("Parameter USER_PORTAL_TRAINING not found in ENV", user);
        Assert.assertFalse("Parameter USER_PORTAL_TRAINING hasn't a value in ENV", user.isEmpty());
        Assert.assertNotNull("Parameter PASSWORD_PORTAL_TRAINING not found in ENV", password);
        Assert.assertFalse("Parameter PASSWORD_PORTAL_TRAINING not found or hasn't a value in ENV", password.isEmpty());
        loginUser.setEmail(user);
        loginUser.setPassword(password);
    }
}
