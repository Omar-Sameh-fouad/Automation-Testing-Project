package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class HomePage {
        private WebDriver driver;

        private By nokia = By.xpath("(//img[@id='main-product-img-20'])[1]");
        private By iphone = By.xpath("(//img[@id='main-product-img-21'])[1]");

        public HomePage(WebDriver driver) {
            this.driver = driver;
        }

        public void clickonNokia() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(nokia)).click();
        }

        public void clickonIphone() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(iphone)).click();
        }
    }


