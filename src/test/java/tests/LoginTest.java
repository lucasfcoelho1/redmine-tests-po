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
import po.LoginPage;

/**
 *
 * @author coelho
 */
public class LoginTest {
     
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
    public void testSuccefulLogin() {
        String login = "user123";   
        String password = "pass123";  

        HomePage home = new HomePage(driver);

        HomePage homePage;
        homePage = (HomePage) home.getMenu().goToLoginPage().login(login, password);

        assertEquals(homePage.getMenu().loggedAs(), login);
    }

    @Test 
    public void testInvalidLogin() {
        String login = "wrongLogin";   
        String senha = "wrongPassword";  

        HomePage home = new HomePage(driver);

        LoginPage loginPage;
        loginPage = (LoginPage) home.getMenu().goToLoginPage().login(login, senha);

        assertTrue(loginPage.loginProblem());
    }
    
}
