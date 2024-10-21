package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateOpportunity extends ProjectSpecificMethod {

	@Test
	public void createOpp() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement clickToggle = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		js.executeScript("arguments[0].click();", clickToggle);
		WebElement click = driver.findElement(By.xpath("(//button[@class='slds-button'])[2]"));
		js.executeScript("arguments[0].click();", click);
		Thread.sleep(3000);
		WebElement clickSales = driver.findElement(By.xpath("//p[text()='Sales']"));
		js.executeScript("arguments[0].click();", clickSales);
		
		WebElement clickOpportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		js.executeScript("arguments[0].click();", clickOpportunity);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by VimalRaj");
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys("75000");
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Today']")).click();
		WebElement stage = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input')])[2]"));
		js.executeScript("arguments[0].click();", stage);
		driver.findElement(By.xpath("//span[@class='slds-media__body']//span[text()='Needs Analysis']")).click();
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
		String verOpportunity = driver
				.findElement(By.xpath("//lightning-formatted-text[text()='Salesforce Automation by VimalRaj']"))
				.getText();
		if (verOpportunity.equals("Salesforce Automation by VimalRaj")) {
			System.out.println("Opportunity created successfully");
		} else {
			System.out.println("Opportunity was not created");
		}

	}

}
