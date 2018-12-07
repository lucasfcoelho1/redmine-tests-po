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
public class NewProjectPage extends RedmineBasePage{
    @FindBy(id = "project_name")
    WebElement projectName;
    
    @FindBy(id = "project_description")
    WebElement projectDescription;
    
    @FindBy(name = "commit")
    WebElement create;
    
    public NewProjectPage(WebDriver driver) {
        super(driver);
    }
    
    public ConfigurationPage fillForm(String projectName, String projectDescription){
        this.projectName.sendKeys(projectName);
        this.projectDescription.sendKeys(projectDescription);
        
        create.click();
        
        return new ConfigurationPage(driver);
    }
}
