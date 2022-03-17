package androidTesting;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TestClass {
    Properties properties;

    public TestClass() {
        properties = new Properties();
    }


    @Test
    public void sometest() throws IOException {
        String target = System.getProperty("target", "data");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
        String app = properties.getProperty("apiDemo");
        System.out.println(app);

    }
}
