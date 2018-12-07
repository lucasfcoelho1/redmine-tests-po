/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import po.*;

/**
 *
 * @author coelho
 */
public class ProjectTest {
    
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
    public void testCreateProject() {
        String login = "user123";   
        String password = "pass123";  

        HomePage home = new HomePage(driver);

        HomePage homePage;
        homePage = (HomePage) home.getMenu().goToLoginPage().login(login, password);
        
        Random random = new Random();
        int numeroRandom = random.nextInt(10000);
        
        String name = "teste" + numeroRandom;
        String description = "this is an automated test";

        
        ConfigurationPage configurationPage = new HomePage(driver)
                .getMenu()
                .goToProjectsPage()
                .createNewProject()
                .fillForm(name, description);

        assertTrue(configurationPage.projectCreated());
    }
    
    @Test
    public void testSearchField(){
        String busca = "Redmine searchfield";
        
        SearchPage searchPage = new HomePage(driver).search(busca);
        
        assertTrue(searchPage.searchIsFilledWith(busca));
        
    }
    
}
