package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class _06_RadioButtonTest extends Base{

    /*
Go to https://www.facebook.com/
Click on "Create New Account" link
Validate "Female", "Male" and "Custom" radio buttons are displayed, enabled and not selected
Select "Female" and validate it is selected
Select "Male" radio button and validate "Male" is selected and "Female" is deselected
 */
    @Test(priority = 1, description = "TC234: Validate Facebook gender radio buttons")
    public void testFacebookGenderRadioButtons(){
        driver.get("https://www.facebook.com/");

        facebookPage.createAccountLink.click();
        Waiter.pause(2);
        for (WebElement element : facebookPage.radioButtonsGender){
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.isEnabled());
            Assert.assertFalse(element.isSelected());
        }
        facebookPage.radioButtonsGender.get(0).click();
        Assert.assertTrue(facebookPage.radioButtonsGender.get(0).isSelected());
        facebookPage.radioButtonsGender.get(1).click();
        Assert.assertTrue(facebookPage.radioButtonsGender.get(1).isSelected());
        Assert.assertFalse(facebookPage.radioButtonsGender.get(0).isSelected());

    }
}