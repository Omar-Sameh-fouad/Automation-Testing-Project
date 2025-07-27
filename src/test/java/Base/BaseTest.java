package Base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
        protected WebDriver driver;

        @BeforeMethod
        public void setUp() {
            driver = new ChromeDriver();
            driver.get("https://demo.nopcommerce.com/register?returnUrl=%2Fpage-not-found");
            driver.manage().window().maximize();
        }
        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
}

