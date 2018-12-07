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
public class ProjectPage extends RedmineBasePage{
    
    @FindBy(tagName = "h1")
    WebElement projectName;
    
    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[4]/a")
    WebElement newTask;
    
    @FindBy(id = "issue_subject")
    WebElement title;
    
    @FindBy(name = "commit")
    WebElement create;
    
    @FindBy(id = "flash_notice")
    WebElement success;
    
    public ProjectPage(WebDriver driver) {
        super(driver);
    }
    
    public ProjectPage createTask(String title){
        newTask.click();
        this.title.sendKeys(title);
        create.click();
        return this;
    }
    
    public boolean confirmTaskCreation(){
        return success.isDisplayed();
    }
    
}
