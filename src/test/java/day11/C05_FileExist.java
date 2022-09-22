package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_FileExist extends TestBaseBeforeAfter {
    @Test
    public void test() throws InterruptedException {
        //https://the-internet.herokuapp.com/download adresine gidelim.
       driver.get("https://the-internet.herokuapp.com/download");
        //test.txt dosyasını indirelim
        WebElement test = driver.findElement(By.xpath("//*[text()='test.txt']"));
        test.click();
        //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String text = "C:\\Users\\KADİR\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(text)));
        //İndirildiğini konsolda gösterin
        System.out.println(Files.exists(Paths.get(text)));
    }
}
