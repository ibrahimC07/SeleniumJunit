package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class AutomationPractise05 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        /*
        1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
         */

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[3]")).isDisplayed());
        //6. Enter name and already registered email address and Click 'Signup' button
        WebElement alreadyHave = driver.findElement(By.xpath("//*[@type='text']"));
        actions.click(alreadyHave).sendKeys("ibrahim").sendKeys(Keys.TAB).
                sendKeys("bcbcbc@gmail.com").sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //7Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@style='color: red;']")).isDisplayed());
    }
}
