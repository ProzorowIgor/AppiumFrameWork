package testingIOS;

import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.util.HashMap;

public class SwipeTest extends IOSbase{

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        IOSDriver driver = DesiredCapabilities();
        //bundle id of App- ( installed in iphone)
        //com.apple.mobileslideshow

        HashMap<String,String> args1 =new HashMap<String,String>();
        args1.put("bundleId", "com.apple.mobileslideshow");
        driver.executeScript("mobile:launchApp", args1);
        driver.findElementByAccessibilityId("All Photos").click();
        int photosCount = driver.findElementsByXPath("//XCUIElementTypeCell").size();
        System.out.println(photosCount);
        driver.findElementByXPath("//XCUIElementTypeCell[1]").click();
        System.out.println(driver.findElementByXPath("//XCUIElementTypeNavigationBar").getAttribute("name"));
        for (int i =0;i<photosCount;i++)
        {
            HashMap<String,String> args2=new HashMap<String,String>();
            args2.put("direction", "left");
            driver.executeScript("mobile:swipe", args2);
            System.out.println(driver.findElementByXPath("//XCUIElementTypeNavigationBar").getAttribute("name"));
        }
        driver.navigate().back();
        driver.findElementByAccessibilityId("Albums").click();

        //	driver.resetInputState();
        //tear down - initial state

    }

}
