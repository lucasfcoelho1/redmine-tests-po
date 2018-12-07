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
public class SearchPage extends RedmineBasePage {

    @FindBy(xpath = "//*[@id=\"search-input\"]")
    WebElement searchInput;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public boolean searchIsFilledWith(String query) {
        return searchInput.getAttribute("value").equals(query);
    }

}
