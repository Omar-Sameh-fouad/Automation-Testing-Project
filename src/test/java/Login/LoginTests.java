package Login;

import Base.BaseTest;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.Color;

public class LoginTests extends BaseTest {
    @Test
    public void userCanLoginSuccessfully() {
        LoginPage login = new LoginPage(driver);
        login.ClickLogincon();
        login.EnterEmail("samhmr5745@gmail.com");
        login.EnterPassword("P@ssw0rd");
        login.ClickLoginButton();
        SoftAssert softAssert = new SoftAssert();
        String actualURL = driver.getCurrentUrl();
        softAssert.assertEquals(actualURL, "https://demo.nopcommerce.com/page-not-found", "URL is not correct");
        boolean AcounticonDisplayed = login.AcounticonDisplayed();
        softAssert.assertTrue(AcounticonDisplayed, "My account tab is not visible");
        softAssert.assertAll();


    }
    @Test
    public void userCanNOTLoginSuccessfully() {
        LoginPage login = new LoginPage(driver);
        login.ClickLogincon();
        login.EnterEmail("samhmr500@gmail.com");
        login.EnterPassword("P@ssw0441");
        login.ClickLoginButton();
        SoftAssert softAssert = new SoftAssert();
        String getErrorMessage = login.getErrorMessage();
        softAssert.assertEquals(getErrorMessage , "Login was unsuccessful.");
        String getErorrMessageColor = login.getErorrMessageColor();
        softAssert.assertEquals(getErorrMessageColor , "rgba(228, 67, 75, 1)");


    }
}
