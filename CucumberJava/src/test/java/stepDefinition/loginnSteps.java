package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.homePage;
import pages.loginPage;

public class loginnSteps {
	WebDriver driver=null;
	loginPage login; 
	//homePage home;
	@Given("browser is open")
	public void browser_is_open() {
		System.out.println("Inside Step - browser is open");
		String projectPath = System.getProperty("user.dir");	
		System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));	
		driver.manage().window().maximize();
	}
	@And("user is on login page")
	public void user_is_on_login_page() {
		System.out.println("Inside Step - user is on login page");
		driver.navigate().to("https://example.testproject.io/web/");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException {
		System.out.println("Inside Step - user enters username and password");
		
		login = new loginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		
		//driver.findElement(By.xpath("//input[@id='name']")).sendKeys(username);
		//driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		Thread.sleep(2000);
	}

	@And("clicks on login button")
	public void clicks_on_login_button() throws InterruptedException {
		System.out.println("Inside Step - user click login button");
		
		login.clickLoginButton();
		
		//driver.findElement(By.xpath("//button[@id='login']")).click();
		Thread.sleep(2000);
		
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		System.out.println("Inside Step - user is navigated to the home page");
		homePage home = new homePage(driver);
		home.checkLogOutIsDisplayed();
		
		//driver.findElement(By.xpath("//button[@id='logout']")).isDisplayed();
		Thread.sleep(2000);
		driver.close();
		driver.quit();		
	}
}
