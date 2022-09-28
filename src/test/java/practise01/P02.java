package practise01;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P02 extends TestBaseBeforeAfter {
    @Test
    public void test01() {
        //Verify that we have pom.xml file in our project => please try in 4 min s

        String path = "pom.xml";

        Assert.assertTrue(Files.exists(Paths.get(path)));
    }
}
