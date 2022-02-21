package androidTesting;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Base {
    AndroidDriver<AndroidElement> driver;

   /* @Test
    public void setUp() throws MalformedURLException {*/
    public static AndroidDriver<AndroidElement> capabilities(String device) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        File appDir = new File("src/test/resources");
        File app = new File(appDir, "ApiDemos-debug.apk");

        if(device.equals("emulator")) {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "2XL_API_30");
        }
        else if (device.equals("real")){
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        }
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");//new step
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

       AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
      /*  new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@content-desc='Preference']"))).click();*/
        //driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Preference']")).click();
   return driver;
    }

    // driver.findElementByAndroidUIAutomator("attribute("value")") example how works UIAutomator

	    // driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

    // driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

    //  Validate clickable feature for all options
    //  driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");
	// System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());


}
