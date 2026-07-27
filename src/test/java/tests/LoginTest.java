package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.DriverSetup;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = DriverSetup.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.navigateTo();
    }

    @Test(description = "TC01 - Valid login should redirect to secure area")
    public void testValidLogin() {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("/secure"),
            "Expected URL to contain /secure after valid login");
    }

    @Test(description = "TC02 - Invalid password should show error message")
    public void testInvalidPassword() {
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLogin();

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Your password is invalid"),
            "Expected invalid password error message");
    }

    @Test(description = "TC03 - Invalid username should show error message")
    public void testInvalidUsername() {
        loginPage.enterUsername("unknownuser");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        String error = loginPage.getErrorMessage();
        Assert.assertTrue(error.contains("Your username is invalid"),
            "Expected invalid username error message");
    }

    @Test(description = "TC04 - Blank fields should show error")
    public void testBlankFields() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLogin();

        String error = loginPage.getErrorMessage();
        Assert.assertFalse(error.isEmpty(),
            "Expected an error message for blank fields");
    }

    @AfterMethod
    public void tearDown() {
        DriverSetup.quitDriver();
    }
}
