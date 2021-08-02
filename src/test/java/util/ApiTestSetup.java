package util;

import org.junit.Before;
import org.junit.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;


/**
 * @Before / @After class
 */
public class ApiTestSetup extends FrameworkInitialize {


    @BeforeClass
    public static void setupClass() throws IOException {
        //loading application data from properties files
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "/application.properties");
        obj.load(objfile);
    }

    @Before
    public void setupTest() throws IOException {
        //add some prerequisite steps in the future
    }

}