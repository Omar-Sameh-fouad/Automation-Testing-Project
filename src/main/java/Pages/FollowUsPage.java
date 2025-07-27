package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    public class FollowUsPage {

        private WebDriver driver;


        private By facebookIcon = By.cssSelector("li.facebook > a");
        private By twitterIcon = By.cssSelector("li.twitter > a");
        private By rssIcon = By.cssSelector("li.rss > a");
        private By youtubeIcon = By.cssSelector("li.youtube > a");


        public FollowUsPage(WebDriver driver) {
            this.driver = driver;
        }


        public void clickiconFacebook() {
            driver.findElement(facebookIcon).click();
        }

        public void clickiconTwitter() {
            driver.findElement(twitterIcon).click();
        }

        public void clickiconRSS() {
            driver.findElement(rssIcon).click();
        }

        public void clickiconYouTube() {
            driver.findElement(youtubeIcon).click();
        }

        public String getCurrentUrl() {
            return driver.getCurrentUrl();
        }
    }


