package test;

import infra.AppiumWrapper;
import infra.TestContext;
import logic.AllEvents;
import logic.CalendarChecked;
import logic.ColorAndEventType;
import logic.SettingsVibrate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

import static java.lang.Thread.sleep;

public class Tests {
    private TestContext context = new TestContext();
    private static AppiumWrapper myAppWrapper;

    @BeforeEach
    public void SetUp() throws MalformedURLException {
        myAppWrapper = new AppiumWrapper();
        context.put("DriverWrapper",myAppWrapper.getDriver());
        WebDriverWait wait = new WebDriverWait(context.get("DriverWrapper"), 5);
    }

    @Test
    public void TestCalendar(){
        CalendarChecked calendar = new CalendarChecked(context.get("DriverWrapper"));
        calendar.ClickCalendar();
        Assertions.assertEquals(true,calendar.IsSelected());
    }
    @Test
    public void EnableDarkMode(){
        ColorAndEventType colorAndEventType=new ColorAndEventType(context.get("DriverWrapper"));
        colorAndEventType.DarkMode();
        Assertions.assertEquals("Enabled",colorAndEventType.DarkModeIsEnable());

    }
    @Test
    public void VibrateCheck(){
        SettingsVibrate SettingsVibrate =new SettingsVibrate(context.get("DriverWrapper"));
        SettingsVibrate.CheckVibrate();
        Assertions.assertEquals("true",SettingsVibrate.VibrateIsChecked());

    }
    @Test
    public void CheckAllEventsTitle(){
        AllEvents allEvents=new AllEvents(context.get("DriverWrapper"));
        allEvents.ClickAllEventsButton();
        Assertions.assertEquals("Events",allEvents.GetTitle());
    }

}
