package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_JuniCheckBox {
    /*
      a. Verilen web sayfasına gidin.
      https://the-internet.herokuapp.com/checkboxes
      b. Checkbox1 ve checkbox2 elementlerini locate edin.
      c. Checkbox1 seçili değilse onay kutusunu tıklayın
      d. Checkbox2 seçili değilse onay kutusunu tıklayın
     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void method1() throws InterruptedException {
        driver.get("  https://the-internet.herokuapp.com/checkboxes");
        WebElement checkboxBir = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkboxIki = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        Thread.sleep(2000);
        if (!checkboxBir.isSelected()){
            checkboxBir.click();
        }
        Thread.sleep(2000);
        if (!checkboxIki.isSelected()){
            checkboxIki.click();
        }
    }
    @After
    public void tearDown(){
        driver.quit();
    }


}