package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class AutomationPractise13 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        //4. Click 'View Product' for any product on home page
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//*[@style='color: brown;'])[1]")).click();
        //5. Verify product detail is opened
        Assert.assertTrue(driver.getCurrentUrl().contains("product_details/1"));
        //6. Increase quantity to 4
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='quantity']"))).click().
                sendKeys(Keys.BACK_SPACE).sendKeys("4").build().perform();
        //7. Click 'Add to cart' button
        driver.findElement(By.xpath("//*[@class='btn btn-default cart']")).click();
        //8. Click 'View Cart' button
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[2]")).click();
        //9. Verify that product is displayed in cart page with exact quantity
        Assert.assertEquals("4",driver.findElement(By.xpath("//*[text()='4']")).getText());
    }
}
