/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import po.HomePage;
import po.MyAccountPage;

/**
 *
 * @author coelho
 */
public class AccountTest {
    
    
    private WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        chromeOptions.addArguments("window-size=1200x600");
        chromeOptions.addArguments("lang=en-US");
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://demo.redmine.org/");
    }

    @After
    public void tearDown() {
        driver.close();
    }
    
    
    @Test
    public void testCreateAccount() {
        String user = "testUsertest";
        String password = "testPassword";
        String passwordConfirmation = "testPassword";
        String name = "testName";
        String lastName = "testLastName";
        String email = "testemail@testemail.com";
        String language = "Portuguese/Brasil (Português/Brasil)";

        HomePage home = new HomePage(driver);

        MyAccountPage myAccount = 
                (MyAccountPage) home
                        .getMenu()
                        .goToSignInPage()
                        .signIn(user, password, passwordConfirmation, name, lastName, email, language);

        assertEquals(myAccount.getMenu().loggedAs(), user);

        assertTrue(myAccount.removeAccount().confirmRemoveAccount().removeAccount());
    }
}
