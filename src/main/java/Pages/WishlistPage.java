package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    public class WishlistPage {
        private WebDriver driver;

        private By htcWishlistBtn = By.xpath("//a[normalize-space()='HTC smartphone']");
        private By wishlistTab = By.xpath("//div[@id='main']//div[3]//div[1]//div[2]//div[3]//div[2]//button[3]");
        private By successmessageBar = By.cssSelector(".content");
        private By qtyInput = By.cssSelector("input.qty-input");


        public WishlistPage(WebDriver driver) {
            this.driver = driver;
        }


        public void clickHTCWishlist() {
            driver.findElement(htcWishlistBtn).click();
        }

        public WebElement getSuccessMessageElement() {
            return driver.findElement(successmessageBar);
        }

        public String getSuccessmessageText() {
            return getSuccessMessageElement().getText();
        }

        public String getsuccessmessagebackgroundcolor() {
            return getSuccessMessageElement().getCssValue("background-color");
        }

        public void clickwishlistsTab() {
            driver.findElement(wishlistTab).click();
        }

        public int getItemQty() {
            String qtyValue = driver.findElement(qtyInput).getAttribute("value");
            return Integer.parseInt(qtyValue);
        }
    }


