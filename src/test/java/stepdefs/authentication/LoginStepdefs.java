package stepdefs.authentication;

import helpers.GlobalParameters;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects.LoginUser;
import org.junit.Assert;
import pages.home.HomePage;
import pages.home.LoginPage;

public class LoginStepdefs {
    // Instances of pages
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    // Instances of Objects
    GlobalParameters parameters = GlobalParameters.getInstance();
    LoginUser loginUser = new LoginUser();
    // A context also could be used, but was not necessary in this case because it will be used only in this Stepdefs

    // Steps
    @When("access login option")
    public void accessLoginOption() {
        homePage.acceptCookies();
        homePage.accessLogin();
    }

    @And("enter email to login")
    public void enterEmailToLogin() {
        loginPage.fillEmailField(loginUser.getEmail());
        loginPage.pressLoginButton();
    }

    @And("enter password to login")
    public void enterPasswordToLogin() {
        loginPage.fillPasswordField(loginUser.getPassword());
        loginPage.pressLoginButton();
    }

    @Then("user will be redirected to training page with user logged")
    public void userWillBeRedirectedToTrainingPageWithUserLogged() {
        String userEmail = homePage.getEmailLoggedUser();
        Assert.assertEquals("Different logged user", loginUser.getEmail(), userEmail);
    }

    @And("I have a valid User credential")
    public void iHaveAValidUserCredential() {
        String user = parameters.getProperty("USER_PORTAL_TRAINING");
        String password = parameters.getProperty("PASSWORD_PORTAL_TRAINING");
        Assert.assertNotNull("Parameter USER_PORTAL_TRAINING not found or hasn't value in ENV", user);
        Assert.assertNotNull("Parameter PASSWORD_PORTAL_TRAINING not found or hasn't value in ENV", password);
        loginUser.setEmail(user);
        loginUser.setPassword(password);
    }
}
