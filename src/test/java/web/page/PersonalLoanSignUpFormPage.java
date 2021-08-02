package web.page;


import com.github.javafaker.Faker;
import helpers.HelpersFunctions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import util.FrameworkInitialize;

import java.time.LocalDate;

/**
 * A page modal for  Login Page
 */
public class PersonalLoanSignUpFormPage extends FrameworkInitialize {
    /**
     * Locators
     */
    //form 1
    private final WebElement _borrowerFirstName = driver.findElement(By.name("borrowerFirstName"));
    private final WebElement _borrowerLastName = driver.findElement(By.name("borrowerLastName"));
    private final WebElement _borrowerStreet = driver.findElement(By.name("borrowerStreet"));
    private final WebElement _borrowerState = driver.findElement(By.name("borrowerState"));
    private final WebElement _borrowerZipCode = driver.findElement(By.name("borrowerZipCode"));
    private final WebElement _borrowerZipCity = driver.findElement(By.name("borrowerCity"));
    private final WebElement _borrowerDateOfBirth = driver.findElement(By.name("borrowerDateOfBirth"));
    private final WebElement _continue = driver.findElement(By.cssSelector("[type=\"submit\"]"));

    public WebElement get_borrowerFirstName() {
        return _borrowerFirstName;
    }

    public WebElement get_borrowerLastName() {
        return _borrowerLastName;
    }

    public WebElement get_borrowerStreet() {
        return _borrowerStreet;
    }

    public WebElement get_borrowerState() {
        return _borrowerState;
    }

    public WebElement get_borrowerZipCode() {
        return _borrowerZipCode;
    }

    public WebElement get_borrowerDateOfBirth() {
        return _borrowerDateOfBirth;
    }

    public WebElement get_borrowerZipCity() {
        return _borrowerZipCity;
    }

    public WebElement get_continue() {
        return _continue;
    }

    /**
     * Click Continue
     **/
    public void clickContinue() {
        _continue.click();
    }

    public void fillForm(Faker faker) {
        this.get_borrowerFirstName().sendKeys(faker.name().firstName());
        this.get_borrowerLastName().sendKeys(faker.name().lastName());
        this.get_borrowerStreet().sendKeys(faker.address().streetAddress());
        this.get_borrowerStreet().click();
        this.get_borrowerStreet().sendKeys(Keys.TAB);
        this.get_borrowerZipCity().sendKeys(faker.address().city());
        // hardcoded the state as i don't know witch state is not accepted to take loan
        this.get_borrowerState().sendKeys("CA");
        this.get_borrowerZipCode().sendKeys(faker.address().zipCode());
        this.get_borrowerDateOfBirth().sendKeys(HelpersFunctions.dateBetween(LocalDate.of(1930, 01, 01), LocalDate.of(2000, 01, 01)));
    }
}

