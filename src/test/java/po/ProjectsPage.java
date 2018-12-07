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
public class ProjectsPage extends RedmineBasePage{
    
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/a[1]")
    WebElement newProject;
    
    public ProjectsPage(WebDriver driver) {
        super(driver);
    }
    
    public NewProjectPage createNewProject(){
        newProject.click();
        
        return new NewProjectPage(driver);
    }
}
