package androidTesting;

import androidTesting.Base;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class Gestures extends Base {


    // public static void main(String[] args) throws MalformedURLException {
    @Test
    public void test() throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        AndroidDriver<AndroidElement> driver = capabilities("emulator");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        //Tap
        TouchAction t = new TouchAction(driver);
        WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
        t.tap(tapOptions().withElement(element(expandList))).perform();
        driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();
        WebElement pn = driver.findElementByXPath("//android.widget.TextView[@text='People Names']");

        t.longPress(longPressOptions().withElement(element(pn)).withDuration(ofSeconds(2))).release().perform();
        //Thread.sleep(2000);
        System.out.println(driver.findElementById("android:id/title").isDisplayed());
    }


}
