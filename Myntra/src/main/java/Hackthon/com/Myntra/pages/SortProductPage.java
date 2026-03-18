package Hackthon.com.Myntra.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Hackthon.com.Myntra.utils.WaitUtils;

public class SortProductPage {
WebDriver driver;
WaitUtils waits;
Actions action;
public static final Logger logger=LogManager.getLogger(SortProductPage.class);
public SortProductPage(WebDriver driver) {
	this.driver=driver;
    this.action = new Actions(driver); // ✅ correct place
	PageFactory.initElements( driver,this);
	waits=new WaitUtils(driver);
}

@FindBy(xpath="//a[@class='desktop-main'][normalize-space()='Men']")
WebElement firstman;

@FindBy(xpath="//a[@href='/men-tshirts']")
WebElement mentsirt;

@FindBy(xpath="//span[@class='product-discountedPrice']")
List<WebElement> productPrice;

@FindBy(xpath="//label[normalize-space()='Price: High to Low']")
WebElement hightoLow;

@FindBy(xpath="//label[normalize-space()='Price: Low to High']")
WebElement lowToHigh;

//span[normalize-space()='Rs. 949']
//span[normalize-space()='Rs. 539']


@FindBy(xpath="//div[@class='sort-sortBy']")
WebElement recommendance;


public void hoverOnMenMenu() {
	waits.waitForElementToBeVisible(firstman);
	action.moveToElement(firstman).perform();
}

public void clickManTsirt() {
	waits.waitForElementToBeClickable(mentsirt);
	mentsirt.click();
}
public void clickSortBy() {
	waits.waitForElementToBeVisible(recommendance);
	action.moveToElement(recommendance).perform();
}
public void highTOLow() {
	waits.waitForElementToBeClickable(hightoLow);
	hightoLow.click();

}
public void lowTOHigh() {
	waits.waitForElementToBeClickable(lowToHigh);
	lowToHigh.click();

}
public List<Integer>getFristFivePrices(){
	List<WebElement>priceElements=productPrice;
	List<Integer>priceList=new ArrayList<>();
	
	for(int i=0;i<5&&i<priceElements.size();i++) {
	String priceText=priceElements.get(i).getText();
	
	priceText =priceText.replaceAll("[^0-9]","");
	int price=Integer.parseInt(priceText);
	priceList.add(price);
	
	}
	return priceList;
	
}

}
