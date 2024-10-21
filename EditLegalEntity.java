package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EditLegalEntity extends ProjectSpecificMethod {

	@Test
	public void editLegal() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement clickToggle = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		js.executeScript("arguments[0].click();", clickToggle);
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();

		WebElement clickLegal = driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		js.executeScript("arguments[0].click();", clickLegal);
		driver.findElement(By.xpath("//input[@name='LegalEntity-search-input']"))
				.sendKeys("Salesforce Automation by VimalRaj", Keys.ENTER);
		Thread.sleep(3000);
		WebElement clickDropDown = driver
				.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']"));
		js.executeScript("arguments[0].click();", clickDropDown);
		Thread.sleep(3000);
		WebElement clickMenu = driver.findElement(By.xpath("//li[@class='uiMenuItem']//a"));
		js.executeScript("arguments[0].click();", clickMenu);
		WebElement companyname = driver.findElement(By.xpath("//input[@name='CompanyName']"));
		companyname.clear();
		companyname.sendKeys("Testleaf");
		WebElement description = driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]"));
		description.clear();
		description.sendKeys("SalesForce");
		WebElement clickStatus = driver.findElement(By.xpath(
				"//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value']"));
		js.executeScript("arguments[0].click();", clickStatus);
		Thread.sleep(3000);
		WebElement clickActive = driver.findElement(By.xpath(
				"//lightning-base-combobox-item[@class='slds-media slds-listbox__option slds-media_center slds-media_small slds-listbox__option_plain']"));
		js.executeScript("arguments[0].click();", clickActive);
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"(//span[@class='slds-grid slds-grid_align-spread slds-grid--align-spread forceInlineEditCell'])[1]"))
				.click();
		String verActive = driver.findElement(By.xpath("//lightning-formatted-text[text()='Active']")).getText();
		if (verActive.equals("Active")) {
			System.out.println("Status is active");
		} else {
			System.out.println("Status was not active");
		}

	}

}
