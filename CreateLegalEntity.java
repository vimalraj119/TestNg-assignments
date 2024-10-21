package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateLegalEntity extends ProjectSpecificMethod {

	@Test
	public void createLegal() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement clickToggle = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		js.executeScript("arguments[0].click();", clickToggle);
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();

		WebElement clickLegal = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		js.executeScript("arguments[0].click();", clickLegal);
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"((//div[@class='slds-context-bar__label-action slds-p-left_none'])[14]//lightning-icon)[1]//lightning-primitive-icon"))
				.click();
		WebElement clickNewEntity = driver.findElement(By.xpath("//span[text()='New Legal Entity']"));
		js.executeScript("arguments[0].click();", clickNewEntity);
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by VimalRaj");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		String verLegal = driver
				.findElement(By.xpath("//lightning-formatted-text[text()='Salesforce Automation by VimalRaj']"))
				.getText();
		if (verLegal.equals("Salesforce Automation by VimalRaj")) {
			System.out.println("Legal Entity created successfully");
		} else {
			System.out.println("Legal Entity was not created");
		}

	}

}
