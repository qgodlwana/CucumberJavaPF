package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
	protected WebDriver driver;
	
	private By btn_logout = By.xpath("//button[@id='logout']");
	
	public homePage(WebDriver driver)
	{
		this.driver =driver;
	}
	public void checkLogOutIsDisplayed()
	{
		driver.findElement(btn_logout).isDisplayed();
	}

}
