package stepdefs.outsystem;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.home.HomePage;
import pages.home.LoginPage;

public class AuthenticationStepdefs {
    // Instances of pages
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    // Steps
    @When("access login option")
    public void accessLoginOption() {
        homePage.acceptCookies();
        homePage.accessLogin();
    }

    @And("enter email {} to login")
    public void enterEmailToLogin(String email) {
        loginPage.fillEmailField(email);
        loginPage.pressLoginButton();
    }

    @And("enter password {} to login")
    public void enterPasswordToLogin(String password) {
        loginPage.fillPasswordField(password);
        loginPage.pressLoginButton();
    }

    @Then("user {} will be redirected to training page with user logged")
    public void userWillBeRedirectedToTrainingPageWithUserLogged(String email) {
        String userEmail = homePage.getEmailLoggedUser();
        Assert.assertEquals("Different logged user", email, userEmail);
    }
}
