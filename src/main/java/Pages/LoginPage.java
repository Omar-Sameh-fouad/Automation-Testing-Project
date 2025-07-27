package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class LoginPage {
    private WebDriver driver ;
    private By LoginBoutton =By.className("ico-login") ;
    private By email = By.className("email");
    private By password = By.id("Password");
    private By ClickLogin = By.cssSelector("button[class='button-1 login-button']");
    private By Accounticon = By.className("ico-account");
    private By ErorrLogin = By.cssSelector("div.message-error");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void ClickLogincon(){
        driver.findElement(LoginBoutton).click();
    }

    public void EnterEmail(String Email) {
        driver.findElement(email).sendKeys(Email);
    }

    public void EnterPassword(String Password) {
        driver.findElement(password).sendKeys(Password);
    }

    public void ClickLoginButton() {
        driver.findElement(ClickLogin).click();
    }
    public boolean AcounticonDisplayed() {
        return driver.findElement(Accounticon).isDisplayed();
    }
    public String getErrorMessage() {
        return driver.findElement(ErorrLogin).getText();
    }
    public String getErorrMessageColor() {
        String rgbaColor = driver.findElement(ErorrLogin).getCssValue("color");
        return Color.fromString(rgbaColor).asHex();

    }

}
