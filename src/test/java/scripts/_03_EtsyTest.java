package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_EtsyTest extends Base{
    /*
    1. Go to https://www.etsy.com/
    2. Validate Etsy logo is displayed

    testEtsyLogo
     */

    // 2. Validation of test - test
    @Test(priority = 1)
    public void testEtsyLogo(){
        driver.get("https://www.etsy.com/");

        WebElement logo = driver.findElement(By.id("logo"));
        Assert.assertTrue(logo.isDisplayed());
    }

    /*
    1. Go to https://www.etsy.com/
    2. Validate Etsy search input box and search button is displayed

    testEtsySearch
     */
    @Test(priority = 3)
    public void testEtsySearch(){
        driver.get("https://www.etsy.com/");

        WebElement searchInputBox = driver.findElement(By.id("global-enhancements-search-query"));
        WebElement searchButton = driver.findElement(By.cssSelector("button[data-id='gnav-search-submit-button']"));

        Assert.assertTrue(searchInputBox.isDisplayed());
        Assert.assertTrue(searchButton.isDisplayed());
    }

    /*
    1. Go to https://www.etsy.com/
    2. Search for "canvas painting"
    3. Validate the results are more than zero
     */
    @Test(priority = 2, dependsOnMethods = "testEtsySearch")
    public void testEtsySearchResult(){
        driver.get("https://www.etsy.com/");

        WebElement searchInputBox = driver.findElement(By.id("global-enhancements-search-query"));

        searchInputBox.sendKeys("canvas painting" + Keys.ENTER);

        WebElement resultTag = driver.findElement(By.cssSelector(".wt-display-inline-flex-sm>span"));

        Assert.assertTrue(Integer.parseInt(resultTag.getText().replaceAll("[^0-9]", "")) > 0);
        // Assert.assertTrue(Integer.parseInt(resultTag.getText().substring(0, resultTag.getText().indexOf(" ")).replace(",", "")) > 0);
    }
}