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
public class ConfigurationPage extends RedmineBasePage{
    @FindBy(id = "flash_notice")
    WebElement sucesso;
    
    public ConfigurationPage(WebDriver driver) {
        super(driver);
    }
    
    public boolean projectCreated(){
        return sucesso.getText().equals("Criado com sucesso.");
    }
    
}
