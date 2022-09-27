package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class AutomationPractice03 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click on 'Signup / Login' button
        5. Verify 'Login to your account' is visible
        6. Enter incorrect email address and password
        7. Click 'login' button
        8. Verify error 'Your email or password is incorrect!' is visible
         */

        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()=' Home']")).isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //5. Verify 'Login to your account' is visible
        Assert.assertTrue(driver.findElement(By.xpath("(//h2)[1]")).isDisplayed());
        //6.Enter incorrect email address and password and Click 'login' button
        WebElement enterAccount = driver.findElement(By.xpath("(//*[@type='email'])[1]"));
        actions.click(enterAccount).sendKeys("bccbcbc@gmail.com").sendKeys(Keys.TAB).sendKeys("123c456").
                sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        //7. Verify error 'Your email or password is incorrect!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@style='color: red;']")).isDisplayed());


    }
}
