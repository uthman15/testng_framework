package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FacebookPage {

    public FacebookPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[data-testid='open-registration-form-button']")
    public WebElement createAccountLink;

    //Sign in form elements
    @FindBy (className = "_8esa")
    public List<WebElement> radioButtonsGender;

    @FindBy(css = "input[name='firstname']")
    public WebElement firstNameInputBox;

    @FindBy(css = "input[name='lastname']")
    public WebElement lastNameInputBox;

    @FindBy(css = "input[name='reg_email__']")
    public WebElement emailOrPhoneInputBox;

    @FindBy(css = "input[name='reg_email_confirmation__']")
    public WebElement emailReEnterInputBox;

    @FindBy(css = "input[name='reg_passwd__']")
    public WebElement passwordInputBox;

    @FindBy(id = "month")
    public WebElement monthDropdown;

    @FindBy(id = "day")
    public WebElement dayDropdown;

    @FindBy(id = "year")
    public WebElement yearDropdown;

    @FindBy(css = "button[name='websubmit']")
    public WebElement signUpButton;

    @FindBy(id = "reg_error_inner")
    public WebElement errorMessage;




}