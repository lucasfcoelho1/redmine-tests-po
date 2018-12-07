/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author coelho
 */
public class Menu extends BasePage{
    @FindBy(xpath = "//*[@id=\"top-menu\"]/ul/li[1]/a")
    WebElement homePage;

    @FindBy(className = "projects")
    WebElement projects;

    @FindBy(xpath = "//*[@id=\"top-menu\"]/ul/li[3]/a")
    WebElement help;

    @FindBy(xpath = "//*[@id=\"loggedas\"]/a")
    WebElement profile;
    
    @FindBy(className = "my-account")
    WebElement myAccount;
    
    @FindBy(className = "logout")
    WebElement logout;
    
    @FindBy(xpath = "//*[@id=\"account\"]/ul/li[1]/a")
    WebElement login;

    @FindBy(xpath = "//*[@id=\"account\"]/ul/li[2]/a")
    WebElement signIn;

    public Menu(WebDriver driver) {
        super(driver);
    }
    
    public LoginPage goToLoginPage(){
        clickMenuOption(login);
        return new LoginPage(driver);
    }
    
    public HomePage goToHomePage(){
        clickMenuOption(homePage);
        return new HomePage(driver);
    }
    
    public SignInPage goToSignInPage(){
        clickMenuOption(signIn);
        return new SignInPage(driver);
    }
    
    public MyAccountPage goToMyAccountPage(){
        clickMenuOption(myAccount);
        return new MyAccountPage(driver);
    }
    
    public ProjectsPage goToProjectsPage(){
        clickMenuOption(projects);
        return new ProjectsPage(driver);
    }
    
    public String loggedAs(){
        return profile.getText();
    }
    
    public HomePage logout(){
        clickMenuOption(logout);
        return new HomePage(driver);
    }
    
    private void clickMenuOption(WebElement menuOption) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(menuOption));
        menuOption.click();
    }
}
