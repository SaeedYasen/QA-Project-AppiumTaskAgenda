package logic;

import infra.AppBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

import static java.lang.Thread.sleep;

public class SettingsVibrate extends AppBasePage {
    public final String MENU = "//android.widget.ImageView[@resource-id=\"com.claudivan.taskagenda:id/hamburguer\"]";
    public MobileElement Menu;
    public final String ALARM_AND_NOTIFICATION="//android.widget.LinearLayout[@resource-id=\"com.claudivan.taskagenda:id/itemNotificacoes\"]";
    public MobileElement alarmAndNotification;
    public final String SETTINGS="//android.widget.RelativeLayout[@resource-id=\"com.claudivan.taskagenda:id/btAjustes\"]";
    public final String VIBRATE="//android.widget.Switch[@resource-id=\"com.claudivan.taskagenda:id/swVibracaoAlarmeEvento\"]";
    private MobileElement settings;
    private MobileElement vibrate;
    private WebDriverWait wait;

    public SettingsVibrate(AndroidDriver<MobileElement> driver) {
        super(driver);
        this.Menu=driver.findElement(By.xpath(MENU));
        wait = new WebDriverWait(driver, 5);

    }
    public void ClickMenu(){
        Menu.click();
    }
    public void ClickSettings(){
        ClickMenu();
        this.settings=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SETTINGS)));
        settings.click();
    }
    public void CheckVibrate(){
        ClickSettings();
        this.alarmAndNotification=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ALARM_AND_NOTIFICATION)));
        alarmAndNotification.click();
        this.vibrate=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(VIBRATE)));


    }
    public String VibrateIsChecked(){
        String checked = vibrate.getAttribute("checked");
        System.out.println(checked);
        if(!(Objects.equals(checked, "true"))){
            vibrate.click();}
        try {
            sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return checked;

    }
}
