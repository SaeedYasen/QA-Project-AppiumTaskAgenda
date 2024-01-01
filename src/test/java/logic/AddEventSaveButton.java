package logic;

import infra.AppBasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEventSaveButton extends AppBasePage {
    public final String ADD_EVENT_ICON="//android.widget.ImageButton[@resource-id=\"com.claudivan.taskagenda:id/btNovoEvento\"]";
    public final String TODAY_CHOICE="//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Today\"]";
    public final String SAVE_BUTTON="//android.widget.TextView[@resource-id=\"com.claudivan.taskagenda:id/item_salvar\"]";
    private MobileElement addEvent;
    private MobileElement saveButton;
    private WebDriverWait wait;

    public AddEventSaveButton(AndroidDriver<MobileElement> driver) {
        super(driver);
        wait = new WebDriverWait(driver, 5);

    }
    public void ClickAddEvent(){
        this.addEvent=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ADD_EVENT_ICON)));
        addEvent.click();
    }
    public void ChooseTodayChoice(){
        ClickAddEvent();
        MobileElement todayChoice = (MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(TODAY_CHOICE)));
        todayChoice.click();
    }
    public boolean SaveButtonIsClickable(){
        this.saveButton=(MobileElement) wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SAVE_BUTTON)));
        return saveButton.getAttribute("clickable").equals("true");
    }
}
