package web.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.FrameworkInitialize;

/**
 * A page modal for  Login Page
 */
public class PersonalLoanLoginPage extends FrameworkInitialize {
    /**
     * Locators
     */

    private final WebElement _username = driver.findElement(By.name("username"));
    private final WebElement _password = driver.findElement(By.name("password"));
    private final WebElement _signInButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));

    public WebElement get_signInButton() {
        return _signInButton;
    }

    public WebElement get_username() {
        return _username;
    }

    public WebElement get_password() {
        return _password;
    }

    public void login(String email, String password) {
        this.get_username().sendKeys(email);
        this.get_password().sendKeys(password);
        this.get_signInButton().click();
    }
}

