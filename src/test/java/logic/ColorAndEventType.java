package logic;

import infra.AppBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ColorAndEventType extends AppBasePage {
    public final String MENU = "//android.widget.ImageView[@resource-id=\"com.claudivan.taskagenda:id/hamburguer\"]";
    public final String COLOR_AND_EVENT_TYPE="//android.widget.LinearLayout[@resource-id=\"com.claudivan.taskagenda:id/btCores\"]";
    public final String DARK_MODE = "//android.widget.LinearLayout[@resource-id=\"com.claudivan.taskagenda:id/itemTemaEscuro\"]";
    public final String ENABLE_DARK_MODE = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Enabled\"]";
    public final String DARK_MODE_IS_ENABLE="//android.widget.TextView[@resource-id=\"com.claudivan.taskagenda:id/tvTemaEscuroValor\"]";
    public MobileElement darkModeIsEnable;
    public MobileElement darkMode;
    public MobileElement enableDarkMode;
    public MobileElement Menu;
    public MobileElement ColorAndEventType;
    private WebDriverWait wait;
    public ColorAndEventType(AndroidDriver<MobileElement> driver) {
        super(driver);
        this.Menu=driver.findElement(By.xpath(MENU));
        wait = new WebDriverWait(driver, 5);

    }
    public void ClickMenu(){
        Menu.click();
    }
    public void ClickColorAndEventType(){
        this.ColorAndEventType= (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(COLOR_AND_EVENT_TYPE)));
        ColorAndEventType.click();
    }


    public void DarkMode(){
        ClickMenu();
        ClickColorAndEventType();
        this.darkMode= (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(DARK_MODE)));
        darkMode.click();
        this.enableDarkMode= (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ENABLE_DARK_MODE)));
        enableDarkMode.click();

    }
    public String DarkModeIsEnable(){
        darkModeIsEnable = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(DARK_MODE_IS_ENABLE)));
        return darkModeIsEnable.getAttribute("text");
    }

}