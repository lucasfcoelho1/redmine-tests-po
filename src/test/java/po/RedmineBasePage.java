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
public class RedmineBasePage extends BasePage{
    
    @FindBy(tagName = "h2")
    WebElement title;
    
    @FindBy(id = "q")
    WebElement search;
    
    Menu menu;
    
    public RedmineBasePage(WebDriver driver) {
        super(driver);
        menu = new Menu(driver);
    }
    
    public Menu getMenu(){
        return menu;
    }
    
    public String getTitle(){
        return title.getText();
    }
    
    public SearchPage search(String query){
        search.sendKeys(query);
        search.submit();
        
        return new SearchPage(driver); 
    }
    
}
