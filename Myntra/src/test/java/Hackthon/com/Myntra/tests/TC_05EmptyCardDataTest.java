
package Hackthon.com.Myntra.tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Hackthon.com.Myntra.pages.HomePage;
import Hackthon.com.Myntra.pages.ProductPage;
import Hackthon.com.Myntra.utils.FileReaderUtils;

import java.util.List;

public class TC_05EmptyCardDataTest extends BaseTest {
	
HomePage home;
ProductPage p;

public static final Logger logger=LogManager.getLogger(TC_05EmptyCardDataTest.class);
       
    
    @Test 
    public void TC_02SearchProduct() throws Exception{
    	test=extent.createTest("Verify product search");
    	HomePage home=new HomePage(driver);
    	
    	logger.info("First Search the protuct");
    	test.info("Check product is searched");
    	
    	home.search("Phone");
    	System.out.println("Product successfully findout");
    	 logger.info("Product searched successfully");
         test.pass("Product searched  successfully");

    }
    
    
    @Test 
    public void TC_03AddToCard() throws Exception {
    	test=extent.createTest("Add to card");
    	 p=new ProductPage(driver);
    	 home=new HomePage(driver);
    	 
    	 logger.info("Add Product into card");
    	 test.info("Check product is add to card");
    	
    	 List<String>products=FileReaderUtils.readProducts("src/test/resources/product.txt");
    	for(String product:products) {
    		home.search(product);
    		p.element();
    		p.size();
    		p.addCard();
    	}
    	 
    	 System.out.println("Product successfully add to card");
    	 logger.info(" add to card  successfully");
         test.pass("add to card successfully");

    }
    
    @Test
     public void TC04_addMultipleProductsFromTextFile() throws Exception {
    	test=extent.createTest("Verify product search from textFile");

         home = new HomePage(driver);
         
         logger.info("First Search product from textfile");
     	test.info("Check product is searched");

        List<String> products = FileReaderUtils.readProducts("src/test/resources/product.txt");

        for(String product: products) {

        home.search(product);

        String title = driver.getTitle();


        System.out.println("TC01 Passed: Product searched successfully"+product);
        logger.info("Product searched successfully");
        test.pass("Product searched  successfully");
    }
}

   
    @Test
    public void TC_05removeProductAddCard() throws Exception {
    	test=extent.createTest("REmmove element from add card");
    	home=new HomePage(driver);
    	p=new ProductPage(driver);
    	logger.info("To remove product from card");
    	test.pass("Check product is remove from card");
    	
    	List<String>products=FileReaderUtils.readProducts("src/test/resources/product.txt");
    	for(String product:products) {
    		home.search(product);
    	p.element();
    	p.size();
    	p.addCard();
    	
    	}
    	p.clickBag();
    	
        p.crosh();
    	p.remove();
    	p.crosh1();
    	p.remove();
    	p.crosh2();
    	p.remove();
    	p.crosh2();
    	p.remove();
    	logger.info("Product removed Successfully");
    	test.pass("product successfully removed");
    	
    }
    
@Test
public void TC08_EmptyCardpage() {
	p=new ProductPage(driver);
	p.clickBag();
	String PageSource=driver.getPageSource();
    Assert.assertTrue(PageSource.contains("There is nothing in your bag"));
	System.out.println("Card is empty");
	logger.info("Card is successfully empty verified");
	test.pass("Card is successfully empty verified");
}
    
    @Test
    public void TC_06invalidProductSearch() {
    	HomePage home=new HomePage(driver);
    	home.search("abcxyz234");
    	home.search2();
    	 String pageSource = driver.getPageSource();

         Assert.assertTrue(pageSource.contains("No results") 
                 || pageSource.contains("0 results"));

         System.out.println("Invalid product search verified");
         logger.info("Invalid product search verified successfully");
         test.pass("Invalid product search verified successfully");

    }
    
    @Test
    public void TC_07CrossPopups() throws Exception {
    	test=extent.createTest("REmmove element from add card");
    	home=new HomePage(driver);
    	p=new ProductPage(driver);
    	logger.info("To remove product from card");
    	test.pass("Check product is remove from card");
    	
    	List<String>products=FileReaderUtils.readProducts("src/test/resources/product.txt");
    	for(String product:products) {
    		home.search(product);
    	p.element();
    	p.size();
    	p.addCard();
    	
    	}
    	p.clickBag();
    	
        p.crosh();
        p.crosspopUp();
    	p.crosh1();
        p.crosspopUp();
    	p.crosh2();
        p.crosspopUp();
    	p.crosh2();
        p.crosspopUp();
    	logger.info("Product removed Successfully");
    	test.pass("product successfully removed");
    }

    
       @Test
    public void TC_09emptyFile() throws Exception {
        HomePage home = new HomePage(driver);

        List<String> emptyFile = FileReaderUtils.readProducts("src/test/resources/empty.txt");

        if(emptyFile.isEmpty()) {
            System.out.println("File is empty");
        } 
        else {
            for(String p : emptyFile) {
                home.search(p);
                home.search2();
                
            }
        }
        logger.info("Empty search Successfully");
        test.pass("Empty search Successfully");

        }
    
    
    @Test
    public void TC_10CardBadge() throws Exception{

    	     p = new ProductPage(driver);
home=new HomePage(driver);
	home.search("phone");
    	    p.element();
    	    for(String handle : driver.getWindowHandles()) {
    	        driver.switchTo().window(handle);
    	    }

            p.size();
    	    p.addCard();
            Thread.sleep(2000); // badge update hone ke liye
            
            home.search("laptop");
    	    p.element();
    	    for(String handle : driver.getWindowHandles()) {
    	        driver.switchTo().window(handle);
    	    }
    	    p.size();
    	    p.addCard();
            Thread.sleep(2000); // badge update hone ke liye
           
            home.search("watch");
    	    p.element();
    	    for(String handle : driver.getWindowHandles()) {
    	        driver.switchTo().window(handle);
    	    }
    	    p.size();
    	    p.addCard();
            Thread.sleep(2000); // badge update hone ke liye
            
            home.search("lipstike");
    	    p.element();
    	    for(String handle : driver.getWindowHandles()) {
    	        driver.switchTo().window(handle);
    	    }
    	    p.size();
    	    p.addCard();
            Thread.sleep(2000); // badge update hone ke liye




    	    int badge = p.getBadgeCount();

    	    p.clickBag();

    	    int cartItems = p.getCartItemsCount();

    	    Assert.assertEquals(badge, cartItems);

    	    System.out.println("Badge count updated correctly");
    	}
    
}
    
//    public void TC_10CardBadge() throws Exception {
//
//        p = new ProductPage(driver);
//        home = new HomePage(driver);
//
//        int expectedCount = 0;
//
//        home.search("phone");
//        p.element();
//        p.size();
//        p.addCard();
//        expectedCount++;
//
//        home.search("laptop");
//        p.element();
//        p.size();
//        p.addCard();
//        expectedCount++;
//
//        home.search("watch");
//        p.element();
//        p.size();
//        p.addCard();
//        expectedCount++;
//
//        int badge = p.getBadgeCount();
//
//        p.clickBag();
//
//        int cartItems = p.getCartItemsCount();
//
//        System.out.println("Expected: " + expectedCount);
//        System.out.println("Badge: " + badge);
//        System.out.println("Cart Items: " + cartItems);
//
//        Assert.assertEquals(badge, expectedCount);
//        Assert.assertEquals(cartItems, expectedCount);
//
//        System.out.println("Badge count and Cart items matched correctly");
//    }
//}