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

/**
 *
 * @author coelho
 */
public class RemoveAccountPage extends RedmineBasePage {
    
    @FindBy(id = "confirm")
    WebElement confirmYes;
    
    @FindBy(name = "commit")
    WebElement removeAccount;
    
    public RemoveAccountPage(WebDriver driver) {
        super(driver);
    }
    
    public HomePage confirmRemoveAccount(){
        confirmYes.click();
        removeAccount.click();
        return new HomePage(driver);
    }
    
}
