package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

    public class SearchPage {
        private WebDriver driver;

        private By searchfaild = By.id("small-searchterms");
        private By searchButton = By.cssSelector("button[type='submit']");
        private By GetResult = By.cssSelector("div.product-item");
        private By SKU = By.cssSelector("div.sku span.value");

        public SearchPage(WebDriver driver) {
            this.driver = driver;
        }

        public void enterProduct(String ProductName) {
            driver.findElement(searchfaild).clear();
            driver.findElement(searchfaild).sendKeys(ProductName);
        }

        public void clickSearchButton() {
            driver.findElement(searchButton).click();
        }

        public String getCurrentURL() {
            return driver.getCurrentUrl();
        }

        public List<WebElement> getSearchResults() {
            return driver.findElements(GetResult);
        }
        public void clickFirstResult() {
            List<WebElement> results = getSearchResults();
            if (!results.isEmpty()) {
                results.get(0).click();
            }
        }

        public String getSKUbyProcuct() {
            return driver.findElement(SKU).getText();
        }
    }



