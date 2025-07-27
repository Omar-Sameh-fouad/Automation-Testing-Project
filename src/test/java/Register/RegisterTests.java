package Register;

import Base.BaseTest;
import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTests extends BaseTest {
    @Test
    public void userCanRegisterSuccessfully() {
        RegisterPage register = new RegisterPage(driver);
        register.EntergenderMale();
        register.EnterfirstName("automation");
        register.EnterlastName("tester");
        register.EnterEmail("samhmr5745@gmail.com");
        register.EnterPassword("P@ssw0rd");
        register.EnterConfirmationPassword("P@ssw0rd");
        register.clickRegister();
        String getSuccessMessage = register.getSuccessMessage();
        Assert.assertEquals(getSuccessMessage , "Your registration completed");
        String getSuccessMessageColor = register.getSuccessMessageColor();
        Assert.assertEquals(getSuccessMessageColor , "rgba(76, 177, 124, 1)");
    }
}
