package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;


/**
 * @Before / @After class
 */
public class SeleniumTestSetup extends FrameworkInitialize {


    @BeforeClass
    public static void setupClass() throws IOException {
        WebDriverManager.chromedriver().setup();
        //loading application data from properties files
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "/application.properties");
        obj.load(objfile);
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Before
    public void setupTest() throws IOException {

    }

}