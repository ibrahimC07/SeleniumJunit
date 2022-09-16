package day04;

import com.github.dockerjava.api.model.Link;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        /*
       1- https://www.amazon.com/ sayfasina gidelim
       2- arama kutusunu locate edelim
       3- “Samsung headphones” ile arama yapalim
       4- Bulunan sonuc sayisini yazdiralim
       5- Ilk urunu tiklayalim
       6- Sayfadaki tum basliklari yazdiralim
     */
        //1- https://www.amazon.com/ sayfasina gidelim
        driver.get(" https://amazon.com");
        //2- arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        //3- “Samsung headphones” ile arama yapalim
        aramaKutusu.sendKeys("Samsung headphones", Keys.ENTER);
        //4- Bulunan sonuc sayisini yazdiralim
        List<WebElement> bulunanSonuc = driver.findElements(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonuc = bulunanSonuc.get(0).getText();
        System.out.println(sonuc);
        //a. bulunan sonuctan sadece sonuc rakamini getir
        //i) normal yoldan cozum
        String[] sonucRakamiSadece = sonuc.split(" ");
        System.out.println("Sonuc rakami sadece :" + sonucRakamiSadece[2]);
        //ii) lambda ile cozum
        Arrays.stream(sonuc.split(" ")).limit(3).skip(2).forEach(System.out::println);
        //5- Ilk urunu tiklayalim
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='s-image'])[1]"));
        ilkUrun.click();

        //6- Sayfadaki tum basliklari yazdi
        List<WebElement> linkSayisi = driver.findElements(By.tagName("h"));



    }

}