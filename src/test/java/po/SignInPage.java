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
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author coelho
 */
public class SignInPage extends RedmineBasePage{
    
    @FindBy(id = "user_login")
    WebElement user;
    
    @FindBy(id = "user_password")
    WebElement password;
    
    @FindBy(id = "user_password_confirmation")
    WebElement confirmation;
    
    @FindBy(id = "user_firstname")
    WebElement name;
    
    @FindBy(id = "user_lastname")
    WebElement lastName;
    
    @FindBy(id = "user_mail")
    WebElement email;
    
    @FindBy(id = "user_language")
    WebElement language;
    Select select = new Select(language);
    
    @FindBy(xpath = "//*[@id=\"new_user\"]/input[3]")
    WebElement send;
    
    @FindBy(id = "errorExplanation")
    WebElement error;
    
    public SignInPage(WebDriver driver) {
        super(driver);
    }
    
    public RedmineBasePage signIn(String myUser,
            String myPw,
            String myPwConf,
            String myName,
            String myLastname,
            String myEmail,
            String myLanguage){
        user.sendKeys(myUser);
        password.sendKeys(myPw);
        confirmation.sendKeys(myPwConf);
        name.sendKeys(myName);
        lastName.sendKeys(myLastname);
        email.sendKeys(myEmail);
        select.selectByVisibleText(myLanguage);
        
        send.click();
        
        return new MyAccountPage(driver);
    }
    
}
