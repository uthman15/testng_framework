package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

import java.util.List;

public class _13_Tables extends Base{
    /*
    Go to http://the-internet.herokuapp.com/
    Click on "Sortable Data Tables" link
    Validate the table 1 headers to be displayed as below
    Last Name
    First Name
    Email
    Due
    Web Site
    Action
     */

    @Test(priority = 1, description = "Tables | headers")
    public void testTableHeaders(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        //Locate a List of web elements that returns all 6 headers and validate their texts with expected texts

        String[] expectedTextTableHeaders = {"Last Name",
                "First Name",
                "Email",
                "Due",
                "Web Site",
                "Action"};

        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(heroAppPage.table1Headers.get(i).getText(), expectedTextTableHeaders[i]);
        }
        Waiter.pause(2);
    }

    /*
    Go to http://the-internet.herokuapp.com/
    Click on "Sortable Data Tables" link
    Validate the table 1 row 1 to be displayed as below
    Smith
    John
    jsmith@gmail.com
    $50.00
    http://www.jsmith.com
    edit delete
     */
    @Test(priority = 2, description = "Tables | first row")
    public void testFirstRow(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        String[] table1Row1Texts = {"Smith", "John", "jsmith@gmail.com", "$50.00", "http://www.jsmith.com", "edit delete"};
        List<WebElement> table1Row1Cells = driver.findElements(By.cssSelector("#table1>tbody>tr:nth-child(1)>td"));

        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(table1Row1Cells.get(i).getText(), table1Row1Texts[i]);
        }
    }

    /*
    Go to http://the-internet.herokuapp.com/
    Click on "Sortable Data Tables" link
    Validate the table 1 column 2 (First Name) to be displayed as below
    John
    Frank
    Jason
    Tim
     */

    @Test(priority = 3, description = "Tables | 2nd column")
    public void testSecondColumn(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        String[] firstNames = {"John", "Frank", "Jason", "Tim"};
        List<WebElement> firstNameCells = driver.findElements(By.cssSelector("#table1>tbody td:nth-child(2)"));

        for (int i = 0; i < 4; i++) {
            Assert.assertEquals(firstNameCells.get(i).getText(), firstNames[i]);
        }
    }

    @Test(priority = 4, description = "Tables | all cells")
    public void testAllCells(){
        driver.get("http://the-internet.herokuapp.com/");
        heroAppPage.clickOnLink("Sortable Data Tables");

        List<WebElement> allCells = driver.findElements(By.cssSelector("#table1 td"));
        System.out.println(allCells.size()); // 24

        for(WebElement element : allCells){
            System.out.println(element.getText());
            Assert.assertNotEquals(element.getText(), "");
        }
    }
}