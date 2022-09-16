package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {
    /*
    -Amazon sayfasina gidelim
    3 farkli test methodu olusturalim
    a-Url'nin amazon icerdigini test edelim
    b-Title'in facebook icermedigini test edelim
    c-sol ust kosede amazon logosunun gorundugunu test edelim
     */

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }
    @AfterClass
    public  static void tearDown(){
        //driver.close();
    }
    @Test
    public void test1(){
// a-Url'nin amazon icerdigini test edelim
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
    @Test
    public void test2(){
      //  b-Title'in facebook icermedigini test edelim
        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(!actualTitle.contains(expectedTitle));
    }
    @Test
    public void test3(){
       // c-sol ust kosede amazon logosunun gorundugunu test edelim
        WebElement amazonLogosu = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(amazonLogosu.isDisplayed());
    }
    @Test
    public void test4(){
        //d- Url'nin www.facebook.com olduğunu test edin
        String expectedUrl = "www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl,actualUrl);
    }

}
