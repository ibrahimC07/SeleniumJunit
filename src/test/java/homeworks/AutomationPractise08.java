package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

public class AutomationPractise08 extends TestBaseBeforeAfter {
    /*
    1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. The products list is visible
7. Click on 'View Product' of first product
8. User is landed to product detail page
9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
     */

    @Test
    public void test01() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed());
        //6. The products list is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='All Products']")).isDisplayed());
        //7. Click on 'View Product' of first product
        driver.findElement(By.xpath("(//*[@style='color: brown;'])[1]")).click();
        //8. User is landed to product detail page
        Assert.assertTrue(driver.getCurrentUrl().contains("product_details/1"));
        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        Assert.assertTrue(driver.getCurrentUrl().contains("product_details/1"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Blue Top']")).isDisplayed());//product name
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Category: Women > Tops']")).isDisplayed());//category
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Rs. 500']")).isDisplayed());//price
        Assert.assertTrue(driver.findElement(By.xpath("(//b)[1]")).isDisplayed());//availability
        Assert.assertTrue(driver.findElement(By.xpath("(//b)[2]")).isDisplayed());//condition
        Assert.assertTrue(driver.findElement(By.xpath("(//b)[3]")).isDisplayed()); // brand


    }
}
