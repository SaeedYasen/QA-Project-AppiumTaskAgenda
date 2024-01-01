package test;

import infra.AppiumWrapper;
import infra.TestContext;
import logic.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

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
        //Arrange
        CalendarChecked calendar = new CalendarChecked(context.get("DriverWrapper"));
        //Act
        calendar.ClickCalendar();
        //Assert
        Assertions.assertEquals(true,calendar.IsSelected());
    }
    @Test
    public void EnableDarkMode(){
        //Arrange
        ColorAndEventType colorAndEventType=new ColorAndEventType(context.get("DriverWrapper"));
        //Act
        colorAndEventType.DarkMode();
        //Assert
        Assertions.assertEquals("Enabled",colorAndEventType.DarkModeIsEnable());

    }
    @Test
    public void VibrateCheck(){
        //Arrange
        SettingsVibrate SettingsVibrate =new SettingsVibrate(context.get("DriverWrapper"));
        //Act
        SettingsVibrate.CheckVibrate();
        //Assert
        Assertions.assertEquals("true",SettingsVibrate.VibrateIsChecked());

    }
    @Test
    public void CheckAllEventsTitle(){
        //Arrange
        AllEvents allEvents=new AllEvents(context.get("DriverWrapper"));
        //Act
        allEvents.ClickAllEventsButton();
        //Assert
        Assertions.assertEquals("Events",allEvents.GetTitle());
    }
    @Test
    public void CheckSaveButtonIfIsClickable(){
        //Arrange
        AddEventSaveButton addEventSaveButton=new AddEventSaveButton(context.get("DriverWrapper"));
        //Act
        addEventSaveButton.ChooseTodayChoice();
        //Assert
        Assertions.assertTrue(addEventSaveButton.SaveButtonIsClickable());
    }
}
