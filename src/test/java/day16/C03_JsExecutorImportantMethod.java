package day16;

import org.junit.Test;
import utilities.TestBaseBeforeAfter;

public class C03_JsExecutorImportantMethod extends TestBaseBeforeAfter {

    @Test
    public void test() {
        /*
        js.executeScript("arguments[0].scrollIntoView(true);", auto.downloadInvoiceButton);
try {
     driver.findElement(By.linkText("Scans")).click();
  } catch (Exception e) {
     JavascriptExecutor executor = (JavascriptExecutor) driver;
     executor.executeScript("arguments[0].click();", driver.findElement(By.linkText("Scans")));
  }
         */
    }
}
