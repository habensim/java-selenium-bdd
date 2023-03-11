package heroku.logintest.tests.login;

import heroku.logintest.base.BaseTest;
import heroku.logintest.base.DriverBase;
import heroku.logintest.helper.ElementHelper;
import heroku.logintest.modules.dashboard.SecurePage;
import heroku.logintest.modules.login.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static heroku.logintest.base.BaseTest.baseUrl;
import static org.testng.Assert.assertEquals;

public class LoginStepdefs {
    WebDriver driver = DriverBase.getDriver();

    @Given("I am on the page login")
    public void iAmOnThePageLogin() {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @When("I put {string} and {string}")
    public void iPutUsernameAndPassword(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
    }
    @And("I click login button")
    public void iClickLoginButton() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSubmitButton();
    }
    @Then("I Success login")
    public void iSuccessLogin() {
        ElementHelper elementHelper = new ElementHelper(driver);
        String validUrl = BaseTest.validUrl;
        System.out.println(elementHelper.isValidUrl(validUrl));
    }
    @And("I verify alert success")
    public void iVerifyAlertSuccess() {
        SecurePage securePage = new SecurePage(driver);
        WebElement noticeMessage = securePage.getNoticeMessage();
        String expectedText = "You logged into a secure area!\n×";
        String actualText = noticeMessage.getText();
        assertEquals(expectedText, actualText);
    }

    @Then("I got error message")
    public void iGotErrorMessage() {
        SecurePage securePage = new SecurePage(driver);
        WebElement noticeMessage = securePage.getNoticeMessage();
        String expectedText = "Your username is invalid!\n×";
        String actualText = noticeMessage.getText();
        assertEquals(expectedText, actualText);
    }
}
