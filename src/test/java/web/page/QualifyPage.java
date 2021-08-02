package web.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.FrameworkInitialize;

/**
 * A page modal for  Confirmation Popup
 */
public class QualifyPage extends FrameworkInitialize {
    /**
     * Locators
     */
    WebDriverWait wait = new WebDriverWait(driver, 30);

    private WebElement _menu = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"Open Site Menu\"]")));
    private WebElement _signOut = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[href=\"/funnel/logout\"]")));
    private WebElement loanAmount = wait.until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("[data-auto=\"userLoanAmount\"]"))));

    public WebElement getLoanAmount() {
        return loanAmount;
    }

    public WebElement get_menu() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[aria-label=\"Open Site Menu\"]"))));
        return _menu;
    }

    public WebElement get_signOut() {
        return _signOut;
    }

    public void signOut() {
        wait.until(ExpectedConditions.elementToBeClickable(_menu));
        _menu.click();
        wait.until(ExpectedConditions.elementToBeClickable(_signOut));
        _signOut.click();
    }
}

