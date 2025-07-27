package Wishlist;



import Base.BaseTest;
import Pages.WishlistPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.time.Duration;

    public class WishlistTests extends BaseTest {

        private WishlistPage wishlistPage;
        private SoftAssert softAssert;

        @Test
        public void addItemToWishlistAndVerifySuccessMessage() {
            wishlistPage = new WishlistPage(driver);
            softAssert = new SoftAssert();

            wishlistPage.clickHTCWishlist();


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(wishlistPage.getSuccessMessageElement()));

            String actualMsg = wishlistPage.getSuccessmessageText().trim();
            softAssert.assertTrue(actualMsg.contains("The product has been added to your wishlist"), "Success message text mismatch");

            String actualColor = wishlistPage.getsuccessmessagebackgroundcolor();
            String actualHex = rgbaToHex(actualColor);

            softAssert.assertEquals(actualHex.toLowerCase(), "#4bb07a", "Background color is not green");

            softAssert.assertAll();
        }

        @Test
        public void validateItemAppearsInWishlist() {
            wishlistPage = new WishlistPage(driver);
            softAssert = new SoftAssert();

            wishlistPage.clickHTCWishlist();


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOf(wishlistPage.getSuccessMessageElement()));

            wishlistPage.clickwishlistsTab();

            int qty = wishlistPage.getItemQty();
            softAssert.assertTrue(qty > 0, "Item was not added to wishlist (Qty = 0)");

            softAssert.assertAll();
        }


        private String rgbaToHex(String rgbaColor) {
            rgbaColor = rgbaColor.replace("rgba(", "").replace(")", "");
            String[] parts = rgbaColor.split(",");
            int r = Integer.parseInt(parts[0].trim());
            int g = Integer.parseInt(parts[1].trim());
            int b = Integer.parseInt(parts[2].trim());
            return String.format("#%02x%02x%02x", r, g, b);
        }
    }


