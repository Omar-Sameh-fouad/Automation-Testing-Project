package Search;


import Base.BaseTest;
import Pages.SearchPage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

    public class SearchTests extends BaseTest {

        @Test
        public void searchUsingProductNames() {
            SearchPage search = new SearchPage(driver);
            String[] keywords = {"book", "laptop", "nike"};

            for (String ProductName : keywords) {
                search.enterProduct(ProductName);
                search.clickSearchButton();

                SoftAssert softAssert = new SoftAssert();

                String currentURL = search.getCurrentURL();
                softAssert.assertTrue(currentURL.contains("https://demo.nopcommerce.com/search?q="),
                        "URL is not correct " + ProductName);


                List<WebElement> results = search.getSearchResults();
                softAssert.assertTrue(results.size() > 0, "No search results found fo " + ProductName);

                for (WebElement result : results) {
                    String resultText = result.getText().toLowerCase();
                    softAssert.assertTrue(resultText.contains(ProductName.toLowerCase()),
                            "Result doesnot contain keyword " + ProductName);
                }

                softAssert.assertAll();
            }
        }
        @Test
        public void searchUsingSKU() {
            SearchPage searchPage = new SearchPage(driver);
            String[] skus = {"SCI_FAITH", "APPLE_CAM", "SF_PRO_11"};

            for (String sku : skus) {
                searchPage.enterProduct(sku);
                searchPage.clickSearchButton();
                searchPage.clickFirstResult();

                String actualSKU = searchPage.getSKUbyProcuct();

                org.testng.Assert.assertTrue(actualSKU.contains(sku),
                        "Expected SKU to contain: " + sku + ", but found: " + actualSKU);
            }
        }
    }




