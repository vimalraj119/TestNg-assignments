package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EditOpportunity extends ProjectSpecificMethod {

	@Test
	public void editOpp() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement clickToggle = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		js.executeScript("arguments[0].click();", clickToggle);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		WebElement clickSales = driver.findElement(By.xpath("//p[text()='Sales']"));
		js.executeScript("arguments[0].click();", clickSales);

		WebElement clickOpportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		js.executeScript("arguments[0].click();", clickOpportunity);
		WebElement searchByName = driver.findElement(By.xpath("//input[@name='Opportunity-search-input']"));
		searchByName.sendKeys("Salesforce Automation by VimalRaj", Keys.ENTER);
		Thread.sleep(3000);
		WebElement clickdDropDown = driver
				.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']"));
		js.executeScript("arguments[0].click();", clickdDropDown);
		driver.findElement(By.xpath("//li[@class='uiMenuItem']/a")).click();
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//span[text()='9']")).click();
		WebElement clickStage = driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input')])[3]"));
		js.executeScript("arguments[0].click();", clickStage);
		WebElement clickPerception = driver.findElement(By.xpath("//span[text()='Perception Analysis']"));
		js.executeScript("arguments[0].click();", clickPerception);
		WebElement clickDelivery = driver.findElement(By.xpath("(//lightning-icon[@icon-name='utility:down'])[9]"));
		js.executeScript("arguments[0].click();", clickDelivery);
		driver.findElement(By.xpath("//span[text()='In progress']")).click();
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("SalesForce");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String verPerception = driver.findElement(By.xpath("//span[text()='Perception Analysis']")).getText();
		if (verPerception.equals("Perception Analysis")) {
			System.out.println("Selected Perception Analysis");
		} else {
			System.out.println("Perception Analysis was not selected");
		}
	}

}
