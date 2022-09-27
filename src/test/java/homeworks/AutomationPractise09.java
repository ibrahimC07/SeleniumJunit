package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class AutomationPractise09 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
 //       1. Launch browser
 //     2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
 //     3. Verify that home page is visible successfully
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
 //     4. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
 //     5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed());
 //     6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//*[@id='search_product']")).sendKeys("Men Tshirt");
        driver.findElement(By.xpath("//*[@id='submit_search']")).click();
 //     7. Verify 'SEARCHED PRODUCTS' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='title text-center']")).isDisplayed());
 //     8. Verify all the products related to search are visible
        String verify = driver.findElement(By.xpath("(//*[text()='Men Tshirt'])[1]")).toString();
        Assert.assertTrue(verify.contains("Men Tshirt"));
    }
}
