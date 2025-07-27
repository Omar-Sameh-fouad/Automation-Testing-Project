package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

    public class HeaderCurrencyPage {
        private WebDriver driver;
        private By currency = By.id("customerCurrency");
        private By productPrices = By.xpath("//span[@class='price actual-price']");

        public HeaderCurrencyPage(WebDriver driver) {
            this.driver = driver;
        }

        public void USDToEuro() {
            Select select = new Select(driver.findElement(currency));
            select.selectByVisibleText("Euro");
        }

        public List<WebElement> getAllProductPrices() {
            return driver.findElements(productPrices);
        }
    }


