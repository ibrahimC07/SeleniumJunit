package homeworks;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBaseBeforeAfter;

public class AutomationPractise14 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/");
        //4. Add products to cart
        actions.moveToElement(driver.findElement(By.xpath("(//*[@class='btn btn-default add-to-cart'])[1]"))).click().
                click(driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']"))).
               moveToElement(driver.findElement(By.xpath("(//*[@alt='ecommerce website products'])[2]"))).
               click().
                click(driver.findElement(By.xpath("//*[@class='btn btn-success close-modal btn-block']"))).perform();
        //5. Click 'Cart' button
        //6. Verify that cart page is displayed
        //7. Click Proceed To Checkout
        //8. Click 'Register / Login' button
        //9. Fill all details in Signup and create account
        //10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        //11. Verify ' Logged in as username' at top
        //12.Click 'Cart' button
        //13. Click 'Proceed To Checkout' button
        //14. Verify Address Details and Review Your Order
        //15. Enter description in comment text area and click 'Place Order'
        //16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        //17. Click 'Pay and Confirm Order' button
        //18. Verify success message 'Your order has been placed successfully!'
        //19. Click 'Delete Account' button
        //20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    }
}
