package scripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DropdownHandler;
import utilities.Waiter;

public class _07_DropdownTest extends Base{

        /*
    Go to https://www.facebook.com/
    Click on "Create New Account" link
    Enter below information and click on Sign Up button
    First name = John
    Last Name = Doe
    Email address = johndoe55555@gmail.com
    Password = abcd1234
    Birthday = April 1, 1990
    Gender = Male
    Validate below error message is displayed with expected text
    Please choose a more secure password. It should be longer than 6 characters, unique to you, and difficult for others to guess.
     */

    @Test(priority = 1, description = "TC763: Validate Facebook sign in error message for password")
    public void testUnsecurePasswordErrorMessage(){

        driver.get("https://www.facebook.com/");

        facebookPage.createAccountLink.click();
        facebookPage.firstNameInputBox.sendKeys("John");
        facebookPage.lastNameInputBox.sendKeys("Doe");
        facebookPage.emailOrPhoneInputBox.sendKeys("johndoe55555@gmail.com");
        facebookPage.emailReEnterInputBox.sendKeys("johndoe55555@gmail.com");
        facebookPage.passwordInputBox.sendKeys("abcd1234");

        //To be able to select an option from dropdown we need an instance of Select class
        //Select monthSelector = new Select(facebookPage.monthDropdown);
        // monthSelector.selectByValue("4");
        // monthSelector.selectByVisibleText("Apr");
        //monthSelector.selectByIndex(3); //index starts from 0
        DropdownHandler.selectOptionByIndex(facebookPage.monthDropdown, 3);

        //Select daySelector = new Select(facebookPage.dayDropdown);
        //daySelector.selectByVisibleText("1");
        DropdownHandler.selectOptionByVisibleText(facebookPage.dayDropdown, "1");

        //Select yearSelector = new Select(facebookPage.yearDropdown);
        //yearSelector.selectByValue("1990");
        DropdownHandler.selectOptionByValue(facebookPage.yearDropdown, "1990");

        facebookPage.radioButtonsGender.get(1).click();
        facebookPage.signUpButton.click();

        String expectedMessage = "Please choose a more secure password. It should be longer than 6 characters, unique to you, and difficult for others to guess.";

        //new WebDriverWait(driver, 30).until(ExpectedConditions.textToBePresentInElement(facebookPage.errorMessage, expectedMessage));
        Waiter.waitUntilTextToBePresentInElement(driver, 60, facebookPage.errorMessage, expectedMessage);
        Assert.assertEquals(facebookPage.errorMessage.getText(), expectedMessage);
    }

    @Test(priority = 2, description = "TC578: Validate Expedia dropdowns")
    public void testExpediaDropdowns(){
        driver.get("https://www.expedia.com");

        expediaPage.moreTravelDropdown.click();
        expediaPage.flights.click();

        //Manual captcha solution
        //Waiter.pause(60);
        expediaPage.flightTypesDropdown.click();
        expediaPage.flightOptions.get(1).click();

        Assert.assertEquals(expediaPage.flightTypesDropdown.getText(), "Premium economy");
    }

    /*
    Go to https://www.ebay.com/
    Select "Art" from "All Categories" dropdown
    Click on "Search" button
    Validate "Welcome to eBay Art" heading1
    Validate "Find Prints, Paintings, Posters, and More." heading2

    NOTE: Validation includes headings to be displayed and texts to be exactly matching above texts
     */

    @Test(priority = 3, description = "TC242: Validate Ebay dropdown")
    public void testEbayDropdown(){

    }



}