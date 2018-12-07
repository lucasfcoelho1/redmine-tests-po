/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package po;

import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author coelho
 */
public class LoginPage extends RedmineBasePage {
    
    @FindBy(id = "username")
    WebElement username;
    
    @FindBy(id = "password")
    WebElement password;
    
    @FindBy(name = "login")
    WebElement login;
    
    @FindBy(xpath = "//*[@id=\"login-form\"]/form/table/tbody/tr[4]/td[1]/a")
    WebElement askPassword;
    
    @FindBy(id = "flash_error")
    WebElement loginError;
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public ForgotPasswordPage clicarPerdiSenha(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(askPassword) );
        
        askPassword.click();
        
        return new ForgotPasswordPage(driver);
    }
    
    public RedmineBasePage login(String user, String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        
        login.click();
        
        if(getCurrentURL().equals("http://demo.redmine.org/"))
            return new HomePage(driver);
        else
            return new LoginPage(driver);
    }
    
    public boolean loginProblem(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(loginError) );
        
        return loginError.isDisplayed();
    }
    
}
