package com.flipkart.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.base.TestBase;

public class SearchPage extends TestBase{
	
	By searchloc = By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[2]/form/div/div/input");
	
	
	public boolean validateSearchProduct(String ProductName ) {
		wait(2000);
		driver.findElement(searchloc).sendKeys(ProductName);
		wait(2000);
		wait = new WebDriverWait(driver ,Duration.ofSeconds(10));
		driver.findElement(searchloc).sendKeys(Keys.ENTER);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("*//span[text()='Laptop']"))) ;

		String actResult = driver.findElement(By.xpath("*//span[text()='Laptop']")).getText();
		
		return actResult.equalsIgnoreCase("laptop");
		
	
		
	}
	
	

}
