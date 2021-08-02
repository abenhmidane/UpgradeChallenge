package web.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.FrameworkInitialize;

/**
 * A page modal for  Confirmation Popup
 */
public class ConfirmationPopup extends FrameworkInitialize {
    /**
     * Locators
     */
    WebDriverWait wait = new WebDriverWait(driver, 5);

    private WebElement _confirmIncome = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-auto=\"confirmIncome\"]")));
    private WebElement _cancelConfirmIncome = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-auto=\"cancelConfirmIncome\"]")));

    public WebElement get_confirmIncome() {
        return _confirmIncome;
    }

    public WebElement get_cancelConfirmIncome() {
        return _cancelConfirmIncome;
    }
}

