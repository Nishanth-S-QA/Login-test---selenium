package tests;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import utils.DriverSetup;
public class LogoutTest {
    WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void setUp() {
        driver = DriverSetup.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        // Login first before testing logout
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();
    }
    @Test(description = "TC05 - Logout should redirect back to login page")
    public void testLogout() {
        loginPage.clickLogout();
        Assert.assertTrue(loginPage.getCurrentUrl().contains("/login"),
            "Expected to be on login page after logout");
    }
    @AfterMethod
    public void tearDown() {
        DriverSetup.quitDriver();
    }
}
