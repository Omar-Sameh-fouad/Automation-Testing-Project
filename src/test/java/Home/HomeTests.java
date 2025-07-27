package Home;

import Base.BaseTest;
import Pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomeTests extends BaseTest {

        @Test
        public void validateNokiaSlider() {
            HomePage home = new HomePage(driver);
            home.clickonNokia();

            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.urlContains("nokia-lumia-1020"));

            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://demo.nopcommerce.com/nokia-lumia-1020",
                    "The URL after clicking Nokia slider is incorrect.");
        }
        @Test
        public void validateIphoneSlider() {
            HomePage home = new HomePage(driver);
            home.clickonIphone();

            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.urlContains("iphone-6"));

            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://demo.nopcommerce.com/iphone-6",
                    "The URL after clicking iPhone slider is incorrect.");
        }
    }


