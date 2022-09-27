package day14;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcel {
    @Test
    public void readExcelTest1() throws IOException {
        //-Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //-WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //-sayfa 2'ye gidip satir sayisinin 6, kullanilan satir sayisinin ise 3 oldugunu test edin
        int sonSatir = workbook.getSheet("Sayfa2").getLastRowNum();
        System.out.println(sonSatir);
        int expectedResult = 6;
        Assert.assertEquals(expectedResult,sonSatir+1);// satir sayisini verir index sifirdan basladigi icin
        // sonsatir sonuna +1 koymayi unutma

        // kullanilan satir sayisini test edelim
        int kullanilanSatirSayisi = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        System.out.println(kullanilanSatirSayisi);
        int expectedResult1 = 3;
        Assert.assertEquals(expectedResult1,kullanilanSatirSayisi);
    }
}
