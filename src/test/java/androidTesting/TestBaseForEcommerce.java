package androidTesting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseForEcommerce {
    AndroidDriver<AndroidElement> driver;


    public static AndroidDriver<AndroidElement> capabilities(String device) throws IOException, InterruptedException {
        DesiredCapabilities cap = new DesiredCapabilities();
        File appDir = new File("src/test/resources");
        File app = new File(appDir, "General-Store.apk");

        if(device.equals("emulator")) {
            startEmulator();
            Thread.sleep(15000);
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Pix");
        }
        else if (device.equals("real")){
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        }
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");//new step
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,10);

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
      /*  new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@content-desc='Preference']"))).click();*/
        //driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Preference']")).click();
        return driver;
    }
    public static void startEmulator() throws IOException, InterruptedException
    {
        Runtime.getRuntime().exec("src/test/resources/NewPixel.bat");
        Thread.sleep(15000);
    }

}
