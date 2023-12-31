package infra;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppBasePage {
    protected AndroidDriver<MobileElement> driver;

    public AppBasePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }
}
