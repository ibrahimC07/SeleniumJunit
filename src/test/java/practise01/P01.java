package practise01;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
       // tüm hayvan emojilerine tıklayın
        List<WebElement> animalsemoji = driver.findElements(By.xpath("//*[@id='nature']//img"));

      //  for (WebElement w:animalsemoji) {
      //      w.click();
      //  }
        animalsemoji.forEach(t->t.click());
        driver.switchTo().defaultContent();
       // formu doldurun (dilediğinizi yazabilirsiniz)
        List<WebElement> text = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        List<String> box = new ArrayList<>(Arrays.asList("bu","nu","mu","po","poi","[po","gh","fg","dsf","tr","ty"));
        for (int i = 0; i < text.size() ; i++) {
            text.get(i).sendKeys(box.get(i));
        }
       // apply butonuna tıklayın
        driver.findElement(By.xpath("//button[@id='send']")).click();
    }
}
