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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author coelho
 */
public class HomePage extends RedmineBasePage{
    
    @FindBy(id = "flash_notice")
    WebElement accountRemoved;
    
    @FindBy(xpath = "//*[@id=\"project_quick_jump_box\"]")
    WebElement selectProjects;
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
    public boolean removeAccount(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(accountRemoved) );
        
        return accountRemoved.isDisplayed();
    }
    

    
}
