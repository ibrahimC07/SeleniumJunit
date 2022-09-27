package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

public class AutomationPractise07 extends TestBaseBeforeAfter {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Test Cases' button
5. Verify user is navigated to test cases page successfully
     */

    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("( //*[text()='Test Cases'])[1]")).click();
        //5. Verify user is navigated to test cases page successfully
        Assert.assertTrue(driver.getCurrentUrl().contains("test_cases") );
    }


}
