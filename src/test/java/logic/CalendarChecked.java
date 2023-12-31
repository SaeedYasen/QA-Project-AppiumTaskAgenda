package logic;

import infra.AppBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CalendarChecked extends AppBasePage {
    private final String CALENDAR_BUTTON = "//android.widget.TextView[@resource-id=\"com.claudivan.taskagenda:id/tvTitulo\" and @text=\"Calendar\"]";
    private MobileElement CalendarButton;
    public CalendarChecked(AndroidDriver<MobileElement> driver) {
        super(driver);
        CalendarButton=  super.driver.findElement(By.xpath(CALENDAR_BUTTON));

    }
    public void ClickCalendar(){
        CalendarButton.click();
    }
    public boolean IsSelected(){
        String selected = CalendarButton.getAttribute("selected");
        return selected.equals("true");
    }
}
