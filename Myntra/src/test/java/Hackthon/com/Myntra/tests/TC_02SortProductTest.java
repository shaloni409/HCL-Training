package Hackthon.com.Myntra.tests;

import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import Hackthon.com.Myntra.pages.HomePage;
import Hackthon.com.Myntra.pages.SortProductPage;

public class TC_02SortProductTest extends BaseTest {
HomePage home;
SortProductPage sortproduct;
public static final Logger logger=LogManager.getLogger(TC_02SortProductTest.class);

@Test
public void TC_01ProductListning() {
	sortproduct=new SortProductPage(driver);
	
	test=extent.createTest("Verify user can navigate");
	test.info("T-shirt product navigate test");
	logger.info("Test product listing page");
	
	sortproduct.hoverOnMenMenu();
	sortproduct.clickManTsirt();
	
	Assert.assertTrue(driver.getPageSource().contains("T-Shirts"));
	logger.info("Successfully naviagate to the Man T-shirt");
	test.info("Successfully naviagate to the Man T-shirt");

		}

@Test
public void TC_02captureFirstFiveProductPrice() {
	sortproduct=new SortProductPage(driver);
	
	test=extent.createTest("Verify price of  first five product ");
	test.info("price of First five product ");
	logger.info("price of first fice product");
	
    // Navigate to T-Shirts
    sortproduct.hoverOnMenMenu();
	sortproduct.clickManTsirt();
	
    // Capture first 5 prices
	List<Integer>prices=sortproduct.getFristFivePrices();
	
    // Print prices (for debugging)
    System.out.println("Captured Prices: " + prices);

    Assert.assertEquals(prices.size(), 5,"Less than 5 products found!");
    
    for(Integer price:prices) {
    	Assert.assertTrue(price>0, "Invalid price found!");
    }	
}

@Test
public void TC_03PriceLowToHigh() {
	sortproduct=new SortProductPage(driver);
	
	test=extent.createTest("Verify price of  first five product ");
	test.info("price of First five product ");
	logger.info("price of first fice product");
	
    // Navigate to T-Shirts
    sortproduct.hoverOnMenMenu();
	sortproduct.clickManTsirt();
	sortproduct.clickSortBy();
    sortproduct.lowTOHigh();
    
    List<Integer>actualPrices=sortproduct.getFristFivePrices();

    List<Integer>expectedPrices=new ArrayList<>(actualPrices);
    Collections.sort(expectedPrices);
    
    Assert.assertEquals(actualPrices, expectedPrices,"Prices are not shorted in low to high");
    
    System.out.println("Actula:"+actualPrices);
    System.out.println("Expected:"+expectedPrices);
}


}
