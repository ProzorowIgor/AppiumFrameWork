package helpers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class HelperProperties {
    Properties properties;
  //  String device;

    public HelperProperties() {
        properties = new Properties();
      //  this.device = device;
    }


    public void initProperties() throws IOException {
        String target = System.getProperty("target", "data");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));


    }


    public String getDevice() {
        return properties.getProperty("device");
    }

    public String getApiDemo() {
        return properties.getProperty("apiDemo");
    }

    public String getDeviceName() {
        return properties.getProperty("deviceName");
    }
}
