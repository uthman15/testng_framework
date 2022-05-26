package scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04_GoogleSearchTest extends Base{

    /*
    TC765: Validate Google search
    1. Go to "https://www.google.com/"
    2. Search for "Selenium"
    3. Validate the results are more than zero
     */

    @Test
    public void testGoogleSearch(){
        driver.get("https://www.google.com/");

        googleSearchPage.searchInputBox.sendKeys("Apple" + Keys.ENTER);

        String results = googleSearchResultPage.resultTag.getText(); //About 1,220,000,000 results (0.51 seconds)

        Assert.assertTrue(Long.parseLong(results.substring(results.indexOf(" ")+1, results.indexOf("results")-1).replace(",", "")) > 0);
    }
}