package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C01_Actions extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //Automationexercises.com sitesine gidelim
        driver.get("https://www.automationexercise.com");
        //Product bölümüne girelim
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
        //ilk ürüne tıklayalım
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        driver.findElement(By.xpath("(//*[@data-product-id='1'])[1]")).click();


    }
}
