package logic;

import infra.AppBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllEvents extends AppBasePage {
    public final String ALL_EVENTS_BUTTON="//android.widget.LinearLayout[@resource-id=\"com.claudivan.taskagenda:id/btEventos\"]";
    public MobileElement allEvents;
    public final String MENU = "//android.widget.ImageView[@resource-id=\"com.claudivan.taskagenda:id/hamburguer\"]";
    public MobileElement Menu;
    public final String ALL_EVENTS_Title="//android.widget.TextView[@text=\"Events\"]";
    public MobileElement allEventsPage;
    private WebDriverWait wait;
    public AllEvents(AndroidDriver<MobileElement> driver) {
        super(driver);
        this.Menu=driver.findElement(By.xpath(MENU));
        wait = new WebDriverWait(driver, 5);

    }
    public void ClickAllEventsButton(){
        Menu.click();
        this.allEvents=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ALL_EVENTS_BUTTON)));
        allEvents.click();
        this.allEventsPage=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ALL_EVENTS_Title)));
    }
    public String GetTitle(){
        return allEventsPage.getAttribute("text");
    }
}
