package web;

import com.github.javafaker.Faker;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;
import util.SeleniumTestSetup;
import web.page.*;

import java.util.Locale;
import java.util.Random;

import static org.junit.Assert.assertEquals;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class loanCreateAccountTest extends SeleniumTestSetup {
    Faker faker = new Faker(new Locale("en-US"));


    //setting variable that will be reused
    String email = "candidates+" + faker.number().randomNumber(4, true) + "@upgrade-challenge.com";
    //due to faker limitation sometime does not  include lowercase nor number i will force a  random lowercase and a random number at the end
    String password = faker.internet().password(6, 7, true, false) +
            (char) (new Random().nextInt(26) + 'a') + String.valueOf(faker.number().numberBetween(1, 9));


    String loanAmount = obj.getProperty("loanAmount");

    @Test
    public void step_0001_signUp() throws Exception {
        driver.get(obj.getProperty("signUpUrl"));
        PersonalLoanSignUpPage personalLoanSignUpPage = new PersonalLoanSignUpPage();
        personalLoanSignUpPage.signUp(loanAmount);
        personalLoanSignUpPage.getCheckYourRateButton().click();
    }

    @Test
    public void step_0002_fillForm() {
        PersonalLoanSignUpFormPage personalLoanSignUpFormPage = new PersonalLoanSignUpFormPage();

        personalLoanSignUpFormPage.fillForm(faker);
        personalLoanSignUpFormPage.clickContinue();
    }

    @Test
    public void step_0003_fillBorrowerIncomePage() {
        PersonalLoanBorrowerIncomePage personalLoanBorrowerIncomePage = new PersonalLoanBorrowerIncomePage();

        personalLoanBorrowerIncomePage.fillBorrowerIncome(faker);
        personalLoanBorrowerIncomePage.get_continue().sendKeys(Keys.RETURN);
        personalLoanBorrowerIncomePage.clickContinue();
    }

    @Test
    public void step_0004_setAccount() {
        PersonalLoanCreateAccountPage personalLoanCreateAccountPage = new PersonalLoanCreateAccountPage();
        personalLoanCreateAccountPage.setAccount(email, password);

        QualifyPage qualifyPage = new QualifyPage();
        //assertTrue(ExpectedConditions.elementToBeClickable(qualifyPage.get_menu()));
    }

    @Test
    public void step_0005_logOut() {
        QualifyPage qualifyPage = new QualifyPage();
        qualifyPage.signOut();
    }

    @Test
    public void step_0006_validateLoan() {
        //navigating to the login url
        driver.get(obj.getProperty("loanPageUrl"));

        PersonalLoanLoginPage personalLoanLoginPage = new PersonalLoanLoginPage();

        personalLoanLoginPage.login(email, password);

        //Loan Amount validation
        QualifyPage qualifyPage = new QualifyPage();
        assertEquals(qualifyPage.getLoanAmount().getText(), loanAmount);
    }

}
