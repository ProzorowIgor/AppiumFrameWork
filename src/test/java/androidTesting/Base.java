package androidTesting;

import helpers.HelperProperties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

public class Base {

    // public static AppiumDriverLocalService service;
    AndroidDriver<AndroidElement> driver;
    // protected static HelperProperties hp = new HelperProperties(System.getProperty("device", "emulator"));
// TO START SERVER YOU NEED TO INSTALL NODE JS !!!!!!!!
    /*public AppiumDriverLocalService startServer()
    {
        //
        boolean flag = сheckIfServerIsRunnning(4723);
        if(!flag)
        {
            service=AppiumDriverLocalService.buildDefaultService();
            service.start();
        }
        return service;
    }

    public static boolean checkIfServerIsRunnning(int port) {
        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);

            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }*/


    public static AndroidDriver<AndroidElement> capabilities(String deviceName) throws IOException, InterruptedException {
        HelperProperties hp = new HelperProperties();
        hp.initProperties();
        // String device = hp.getDevice();
        String appl = hp.getApiDemo();
        String device = hp.getDevice();
        DesiredCapabilities cap = new DesiredCapabilities();
        File appDir = new File("src/test/resources");
        File app = new File(appDir, appl);

        if (device.equals("emulator")) {
            startEmulator();
            Thread.sleep(15000);
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "deviceName");
        } else if (device.equals("real")) {
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        }
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");//new step
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
      /*  new WebDriverWait(driver,10)
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@content-desc='Preference']"))).click();*/
        //driver.findElement(By.xpath("//android.widget.Te-desc='Preference']")).click();
        //        return driver;xtView[@content
   return driver;
    }




    // driver.findElementByAndroidUIAutomator("attribute("value")") example how works UIAutomator

    // driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

    // driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

    //  Validate clickable feature for all options
    //  driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");
    // System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
    public static void startEmulator() throws IOException, InterruptedException
    {
        Runtime.getRuntime().exec("src/test/resources/NewPixel.bat");
        Thread.sleep(15000);
    }

}
