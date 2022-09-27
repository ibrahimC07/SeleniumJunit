package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseBeforeAfter;

public class AutomationPractise12 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        //4. Click 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        //5. Hover over first product and click 'Add to cart'
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        actions.moveToElement(driver.findElement(By.xpath("(//*[@alt='ecommerce website products'])[1]"))).perform();
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]")).click();
        //6. Click 'Continue Shopping' button
        driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']")).click();
        //7. Hover over second product and click 'Add to cart'
        actions.moveToElement(driver.findElement(By.xpath("(//*[@alt='ecommerce website products'])[2]"))).perform();
        driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[3]")).click();
        //8. Click 'View Cart' button
        driver.findElement(By.xpath("(//*[@href='/view_cart'])[2]")).click();
        //9. Verify both products are added to Cart
        Assert.assertTrue(driver.findElement(By.xpath("//*[@href='/product_details/1']")).isDisplayed());
        //10. Verify their prices, quantity and total price
        Assert.assertTrue(driver.findElement(By.xpath("//*[@href='/product_details/2']")).isDisplayed());
    }
}
