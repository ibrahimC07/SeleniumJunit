package homeworks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

         /*
    1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
    2- Add Element butonuna 10 kez basinız
    3- 10 kez Add element butonuna basıldığını test ediniz
    4 - Delete butonuna görünmeyene kadar basınız
    5- Delete butonunun görünmediğini test ediniz
    6- Sayfayı kapatınız
          */

        //1-https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.navigate().to("https://the-internet.herokuapp.com/add_remove_elements/");
        //2- Add Element butonuna 10 kez basinız
        WebElement add = driver.findElement(By.xpath("//*[@onclick='addElement()']"));

        int sayac =0;
        while (sayac<10){
            add.click();
            sayac++;
        }
        //3- 10 kez Add element butonuna basıldığını test ediniz
        //1.yol
        /*
        if (sayac==9){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");
        */
        //2.yol

       List<WebElement> addTest = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
       if (addTest.size()==10){
           System.out.println("TEST PASSED");
       }else System.out.println("TEST FAILED");
        //4 - Delete butonuna görünmeyene kadar basınız
        List<WebElement> deleteButon=driver.findElements(By.xpath("//*[@class='added-manually']"));
        int basmaSayisi=10;
        for (int i=0; i <10 ; i++) {
            deleteButon.get(i).click();
            basmaSayisi--;

        }
        //5- Delete butonunun görünmediğini test ediniz
        // 5- Delete butonunun görünmediğini test ediniz
        if(basmaSayisi==0){
            System.out.println("Delete butonuna 10 kez basıldığından Button görünmüyor test PASSED");
        }else System.out.println("Delete butonuna 10 kez basılmadığından test FAILED");
        driver.close();
        //6- Sayfayı kapatınız



    }
}
