package testingIOS;

import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;

public class AppiumClickTest extends IOSbase{

    public static void main(String[] args) throws MalformedURLException {

        IOSDriver driver = DesiredCapabilities();
        driver.findElementByAccessibilityId("Alert Views").click();

        //tagname[@attribute='value']

        driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Text Entry']").click();
        driver.findElementByXPath("//XCUIElementTypeCell").sendKeys("Hello");
        driver.findElementByAccessibilityId("OK").click();
        driver.findElementByAccessibilityId("Confirm / Cancel").click();
        System.out.println(driver.findElementByXPath("//*[contains(@name,'message')]").getText());
        driver.findElementByAccessibilityId("Confirm").click();
        //scroll,swipe,longpress


    }
}
