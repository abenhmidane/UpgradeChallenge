package web.page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import util.FrameworkInitialize;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A page modal for  Login Page
 */
public class PersonalLoanSignUpPage extends FrameworkInitialize {
    /**
     * Locators
     */

    private final WebElement _loanAmount = driver.findElement(By.name("desiredAmount"));
    private final WebElement _checkYourRateButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
    private final Select _purposeLoan = new Select(driver.findElement(By.name("loan-purpose")));

    public WebElement getLoanAmount() {
        return _loanAmount;
    }

    public WebElement getCheckYourRateButton() {
        return _checkYourRateButton;
    }

    public Select get_purposeLoan() {
        return _purposeLoan;
    }


    /**
     * Enter an amount
     **/
    public void enterLoanAmount(String loanAmount) {
        _loanAmount.sendKeys(loanAmount);

    }

    /**
     * Click check rate
     **/
    public void clickCheckYourRate() {
        _checkYourRateButton.click();
    }

    public void signUp(String loanAmount) {
        this.enterLoanAmount(loanAmount);
        //random dropdown select between 1-2( options index) other may give another form
        int randomNum = ThreadLocalRandom.current().nextInt(1, 2 + 1);
        this.get_purposeLoan().selectByIndex(randomNum);
    }
}

