package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private By genderMale = By.id("gender-male");
    private By firstName = By.id("FirstName");
    private By lastName = By.id("LastName");
    private By email = By.id("Email");
    private By password = By.id("Password");
    private By confirmPassword = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");
    private By successMessage = By.xpath("//div[@class='result']");


    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void EntergenderMale() {
        driver.findElement(genderMale).click();
    }
    public void EnterfirstName(String FirstName) {
        driver.findElement(firstName).sendKeys(FirstName);
    }
    public void EnterlastName(String LirstName) {
        driver.findElement(lastName).sendKeys(LirstName);
    }
    public void EnterEmail(String Email) {
        driver.findElement(email).sendKeys(Email);
    }
    public void EnterPassword(String Password) {
        driver.findElement(password).sendKeys(Password);
    }
    public void EnterConfirmationPassword(String ConPassword) {
        driver.findElement(confirmPassword).sendKeys(ConPassword);
    }
    public void clickRegister() {
        driver.findElement(registerButton).click();
    }
    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
    public String getSuccessMessageColor() {
        return driver.findElement(successMessage).getCssValue("color");
    }




}
