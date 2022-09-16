package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com");
        //Sayfayi "refresh" yapin
        Thread.sleep(2000);
        driver.navigate().refresh();
        //Sayfa basliginin "Spend less" ifadesi icerdigini test edin
        String actualResult = driver.getTitle();
        String expectedResult = "Spend less";
        if (actualResult.contains(expectedResult)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");
        //Gift Cards sekmesine basin
        WebElement giftCard = driver.findElement(By.xpath("(//*[@class='nav-a  '])[4]"));
        giftCard.click();
        //Birthday butonuna basin
        driver.findElement(By.xpath("//*[@alt='Birthday gift cards']")).click();
        //Best Seller bolumunden ilk urunu tiklayin
        driver.findElement(By.xpath("(//*[@alt='Amazon.com eGift Card'])[1]")).click();
        //Gift card details'den 25 $'i secin
     WebElement giftCardPrice =    driver.findElement(By.xpath("(//*[@id='gc-mini-picker-amount-1'])[1]"));
     giftCardPrice.click();
        //Urun ucretinin 25$ oldugunu test edin
        Thread.sleep(2000);
        WebElement productPrice = driver.findElement(By.xpath("//span[@id = 'gc-live-preview-amount']"));
        if (productPrice.getText().contains("25")){
            System.out.println("Product price check test passed");
        }else {
            System.out.println("Product price check test failed");
        }

        //Sayfayi kapatin
        Thread.sleep(2000);


    }
}
