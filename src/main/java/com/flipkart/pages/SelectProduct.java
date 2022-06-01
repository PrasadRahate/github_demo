package com.flipkart.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.base.TestBase;

public class SelectProduct extends TestBase {
	
	By selectProd = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]");
	By addToCart = By.xpath("*//button[@class='_2KpZ6l _2U9uOA _3v1-ww']");
	
	public boolean selectingProduct() {
		String parentWindow = driver.getWindowHandle();
        
		Set<String> allWindowElements = driver.getWindowHandles();
		
		for(String obj : allWindowElements) {
			if(!obj.equals(parentWindow)) {
				driver.switchTo().window(obj);
			}
		}
		
		
		driver.findElement(selectProd).click();
		wait(2000);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(addToCart));
	    String actResult  = driver.findElement(addToCart).getText();
	    
	    return actResult.equalsIgnoreCase("ADD TO CART");
		
	}

}
