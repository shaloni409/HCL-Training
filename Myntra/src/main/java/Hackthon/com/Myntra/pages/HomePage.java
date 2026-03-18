package Hackthon.com.Myntra.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Hackthon.com.Myntra.utils.WaitUtils;

public class HomePage {
	WebDriver driver;
	WaitUtils waits;
	public static final Logger logger=LogManager.getLogger(HomePage.class);
public HomePage(WebDriver driver) {
	this.driver=driver;
 PageFactory.initElements( driver,this);
 waits = new WaitUtils(driver);   // ⭐ FIX

}
@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
WebElement searchbar;

@FindBy(xpath="//span[@class='myntraweb-sprite desktop-iconSearch sprites-search']")
WebElement search;

public void search(String s) {
	logger.info("Search the Element");
	waits.waitForElementToBeVisible(searchbar);
    searchbar.clear();

	searchbar.sendKeys(s);
    searchbar.sendKeys(Keys.ENTER);
	
}
public void search2() {
	logger.info("Btn to be clickable");
	waits.waitForElementToBeClickable(search);
    searchbar.clear();
	search.click();
}
}
