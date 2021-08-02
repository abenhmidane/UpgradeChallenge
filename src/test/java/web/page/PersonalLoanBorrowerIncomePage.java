package web.page;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import util.FrameworkInitialize;

/**
 * A page modal for  Login Page
 */
public class PersonalLoanBorrowerIncomePage extends FrameworkInitialize {
    /**
     * Locators
     */

    //form 2
    private final WebElement _borrowerIncome = driver.findElement(By.name("borrowerIncome"));
    private final WebElement _borrowerAdditionalIncome = driver.findElement(By.name("borrowerAdditionalIncome"));
    private final WebElement _continue = driver.findElement(By.cssSelector("[type=\"submit\"]"));


    public WebElement get_continue() {
        return _continue;
    }

    public WebElement get_borrowerIncome() {
        return _borrowerIncome;
    }

    public WebElement get_borrowerAdditionalIncome() {
        return _borrowerAdditionalIncome;
    }

    /**
     * Click Continue
     **/
    public void clickContinue() {
        _continue.click();
    }

    public void fillBorrowerIncome(Faker faker) {
        //income form
        // i supposed that people owning more then 2 million does not need to barrow money or else a small function to make it infinite...
        this.get_borrowerIncome().sendKeys(String.valueOf(faker.number().randomDouble(0, 120000, 400000)));

        this.get_borrowerAdditionalIncome().sendKeys(String.valueOf((faker.number().randomDouble(0, 5000, 100000))));

        // handling confirmation popup that pop from time to time.
        try {
            ConfirmationPopup confirmationPopup = new ConfirmationPopup();
            if (confirmationPopup.get_confirmIncome().isDisplayed()) {
                confirmationPopup.get_confirmIncome().click();
            }
        } catch (Exception exception) {
            System.out.println("Element does not exist! or Timed out");
        }



    }
}

