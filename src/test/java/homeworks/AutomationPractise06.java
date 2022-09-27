package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class AutomationPractise06 extends TestBaseBeforeAfter {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully
     */

    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed());
        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[@href='/contact_us']")).click();
        //5. Verify 'GET IN TOUCH' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='title text-center'])[2]")).isDisplayed());
        //6. Enter name, email, subject and message
        WebElement EnterName = driver.findElement(By.xpath("(//*[@type='text'])[1]"));
        actions.click(EnterName).sendKeys("ibrahim").sendKeys(Keys.TAB).sendKeys("bcbcbc@gmail.com").
                sendKeys(Keys.TAB).sendKeys("Subject").sendKeys(Keys.TAB).sendKeys("HelloWorld").perform();
        //7. Upload file
       WebElement uploadFile =  driver.findElement(By.xpath("//*[@type='file']"));
       uploadFile.sendKeys("C:\\Users\\KADİR\\Downloads\\test.txt");
       //8. Click 'Submit' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
        //9. Click OK button
        driver.switchTo().alert().accept();
        //10. 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@style='display: block;'])[1]")).isDisplayed());
        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("(//*[text()=' Home'])[1]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@class='girl img-responsive'])[1]")).isDisplayed());
        //2.Way
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");

    }
}
