package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeAfter;

import java.util.Set;

public class C01_Cookie extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");
        //2-tum cookie’leri listeleyin
        Set<Cookie> tumCookie = driver.manage().getCookies();
        System.out.println(tumCookie);
        int sayac = 1;
        for (Cookie w:tumCookie) {
            System.out.println(sayac+". Cookie :"+w);
            System.out.println(sayac+". Value :"+w.getValue());
            System.out.println(sayac+". name :"+w.getName());
            sayac++;
        }
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(tumCookie.size()>5);
        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w :tumCookie) {
            if (w.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",w.getValue());
            }
        }
        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie newCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(newCookie);
        tumCookie = driver.manage().getCookies();

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(tumCookie.size()==9);
        //7-ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        tumCookie = driver.manage().getCookies();
        Cookie isim = driver.manage().getCookieNamed("skin");
        Assert.assertFalse(tumCookie.contains(isim));
        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookie=driver.manage().getCookies();
        Assert.assertTrue(tumCookie.isEmpty());

    }
}
