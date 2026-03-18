package Hackthon.com.Myntra.pages;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Hackthon.com.Myntra.utils.WaitUtils;

public class ProductPage {
WebDriver driver;
WaitUtils waits;
public static final Logger logger=LogManager.getLogger(ProductPage.class);
public ProductPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	waits=new WaitUtils(driver);
	
}
@FindBy(xpath="(//li[@class='product-base'])[1]")
WebElement element1;

@FindBy(xpath="(//div[@class='size-buttons-size-buttons']//button)[1]")
WebElement  size;

@FindBy(xpath="//div[normalize-space()='ADD TO BAG']")
WebElement addcard;

@FindBy(xpath="//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")
WebElement bag;
@FindBy(xpath="//a[contains(@class,'desktop-cart')]//span[contains(@class,'desktop-badge')]")
WebElement badgeCount;

@FindBy(xpath="//body/div[contains(@class,'layout')]/div[@id='mountRoot']/div[@id='appContent']/div[contains(@class,'')]/div/div/div[contains(@class,'desktop-base-cartLayout')]/div[contains(@class,'itemBlock-base-leftBlock')]/div[@id='cartItemsList']/div[contains(@class,'itemContainer-base-itemMargin')]/div/div[1]/div[2]/div[3]//*[name()='svg']")
WebElement crosh;
@FindBy(xpath="//body/div[@class='layout']/div[@id='mountRoot']/div[@id='appContent']/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[3]//*[name()='svg']//*[name()='path' and contains(@fill,'#000')]")
WebElement crosh2;
@FindBy(xpath="//body/div[contains(@class,'layout')]/div[@id='mountRoot']/div[@id='appContent']/div[contains(@class,'')]/div/div/div[contains(@class,'desktop-base-cartLayout')]/div[contains(@class,'itemBlock-base-leftBlock')]/div[@id='cartItemsList']/div[contains(@class,'itemContainer-base-itemMargin')]/div/div[2]/div[2]/div[3]//*[name()='svg']")
WebElement crosh3;

@FindBy(xpath="//div[@class='modal-base-modal itemComponents-base-modalDesktop itemComponents-base-modalMoveOutOfBag']//*[name()='svg']")
WebElement croshpopup;

@FindBy(xpath="//div[contains(@class,'confirmOrCancelModal-buttonClass')]//button[contains(@class,'inlinebuttonV2-base-actionButton')][normalize-space()='REMOVE']")
WebElement remove;

@FindBy(xpath="//div[@id='cartItemsList']/div")
List<WebElement> cartItems;

public void element() {
    waits.waitForElementToBeClickable(element1);
	element1.click();
	Set<String> windows = driver.getWindowHandles();

    for(String window : windows){
        driver.switchTo().window(window);
    }
  //span[@class='bulkActionStrip-itemSelected']
  //span[@class='bulkActionStrip-itemSelected']
}
public void size() {
    waits.waitForElementToBeClickable(size);
	size.click();
}

public void addCard() {
    waits.waitForElementToBeClickable(addcard);
	addcard.click();
}
public void clickBag() {
	waits.waitForElementToBeClickable(bag);
	waits.waitForElementToBeVisible(bag);
	bag.click();
}
public void crosh() {
	waits.waitForElementToBeClickable(crosh);
	crosh.click();
}
public void crosh1() {
	waits.waitForElementToBeClickable(crosh2);
	crosh2.click();
}

public void crosh2() {
	waits.waitForElementToBeClickable(crosh3);
	crosh3.click();
}

public void remove() {
	waits.waitForElementToBeClickable(remove);
	remove.click();
}

public void crosspopUp() {
	waits.waitForElementToBeClickable(croshpopup);
	croshpopup.click();
}
public int getBadgeCount() {

    waits.waitForElementToBeVisible(badgeCount);

    String text = badgeCount.getText();

    System.out.println("Badge Count = " + text);

    return Integer.parseInt(text);
}
public int getCartItemsCount() {

    waits.waitForElementsToBeVisible(cartItems);

    int count = cartItems.size();

    System.out.println("Cart Items Count = " + count);

    return count;
}
}
