package androidTesting;

import androidTesting.Base;
import helpers.HelperProperties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ScrollBasic extends Base {

    // IT IS APLICABLE ONLY TO THE NODE JS
 /*   @BeforeTest
    public void killAllNodes() throws IOException, InterruptedException
    {
        //taskkill /F /IM node.exe
        Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(3000);

    }*/

    @Test
    public void scrollTest() throws IOException, InterruptedException {
       // service = startServer();
       // HelperProperties hp = new HelperProperties(System.getProperty("device", "emulator"));
        HelperProperties hp = new HelperProperties();
        hp.initProperties();
        String deviceName = hp.getDeviceName();
        AndroidDriver<AndroidElement> driver = capabilities(deviceName);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
     //   service.stop();
    }
}