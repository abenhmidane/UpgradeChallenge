package web.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.FrameworkInitialize;

/**
 * A page modal for  Login Page
 */
public class PersonalLoanCreateAccountPage extends FrameworkInitialize {
    /**
     * Locators
     */

    private final WebElement _username = driver.findElement(By.name("username"));
    private final WebElement _password = driver.findElement(By.name("password"));
    private final WebElement _agreeCheckbox = driver.findElement(By.cssSelector("div > label > div"));
    private final WebElement _checkYourRateButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));

    public WebElement get_username() {
        return _username;
    }

    public WebElement get_password() {
        return _password;
    }

    public WebElement get_agreeCheckbox() {
        return _agreeCheckbox;
    }

    public WebElement get_checkYourRateButton() {
        return _checkYourRateButton;
    }

    public void setAccount(String email, String password) {
        this.get_username().sendKeys(email);
        this.get_password().sendKeys(password);
        this.get_agreeCheckbox().click();
        this.get_checkYourRateButton().click();
    }
}

