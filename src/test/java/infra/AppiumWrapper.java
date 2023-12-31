package infra;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumWrapper {
    private AndroidDriver<MobileElement> driver;

    public AppiumWrapper() throws MalformedURLException {
        init();
    }

    public AndroidDriver<MobileElement> getDriver(){
        return driver;
    }
    public void init() throws MalformedURLException {
        PropertiesWrapper propertiesWrapper = new PropertiesWrapper();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", propertiesWrapper.getProperties("platformName"));
        caps.setCapability("deviceName", propertiesWrapper.getProperties("deviceName"));
        caps.setCapability("platformVersion", propertiesWrapper.getProperties("platformVersion"));
        caps.setCapability("automationName", propertiesWrapper.getProperties("automationName"));
        caps.setCapability("appPackage", propertiesWrapper.getProperties("appPackage"));
        caps.setCapability("appActivity", propertiesWrapper.getProperties("appActivity"));
        driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723"), caps);
    }
}
