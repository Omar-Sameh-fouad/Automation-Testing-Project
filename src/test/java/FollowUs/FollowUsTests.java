package FollowUs;

import Base.BaseTest;
import Pages.FollowUsPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.util.Set;

public class FollowUsTests extends BaseTest {

    private FollowUsPage followUsPage;
    private SoftAssert softAssert;

    @Test
    public void validateFacebookLink() {
        followUsPage = new FollowUsPage(driver);
        softAssert = new SoftAssert();

        String originalTab = driver.getWindowHandle();
        followUsPage.clickiconFacebook();
        switchToNewTab(originalTab);

        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/nopCommerce", "Facebook URL mismatch");
        softAssert.assertAll();
    }

    @Test
    public void validateeTwitterLink() {
        followUsPage = new FollowUsPage(driver);
        softAssert = new SoftAssert();

        String originalTab = driver.getWindowHandle();
        followUsPage.clickiconTwitter();
        switchToNewTab(originalTab);

        softAssert.assertEquals(driver.getCurrentUrl(), "https://twitter.com/nopCommerce", "Twitter URL mismatch");
        softAssert.assertAll();
    }

    @Test
    public void validateRSSLink() {
        followUsPage = new FollowUsPage(driver);
        softAssert = new SoftAssert();

        followUsPage.clickiconRSS();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://demo.nopcommerce.com/new-online-store-is-open";

        softAssert.assertEquals(actualUrl, expectedUrl, "RSS URL mismatch (expected to fail)");
        softAssert.assertAll();
    }

    @Test
    public void validateYouTubeLink() {
        followUsPage = new FollowUsPage(driver);
        softAssert = new SoftAssert();

        String originalTab = driver.getWindowHandle();
        followUsPage.clickiconYouTube();
        switchToNewTab(originalTab);

        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.youtube.com/user/nopCommerce", "YouTube URL mismatch");
        softAssert.assertAll();
    }


    private void switchToNewTab(String originalTab) {
        Set<String> allTabs = driver.getWindowHandles();
        for (String tab : allTabs) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }
    }
}
