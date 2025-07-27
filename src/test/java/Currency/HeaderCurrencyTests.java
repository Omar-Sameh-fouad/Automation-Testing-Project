package Currency;

import Base.BaseTest;
import Pages.HeaderCurrencyPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HeaderCurrencyTests extends BaseTest {
    @Test
    public void validateIfCurrencyISEuro() {
        HeaderCurrencyPage header = new HeaderCurrencyPage(driver);
        header.USDToEuro();
        List<WebElement> prices = header.getAllProductPrices();
        for (WebElement price : prices) {
            String priceText = price.getText();
            Assert.assertTrue(priceText.contains("€"),
                    "Expected Eoru ");
        }



    }
}