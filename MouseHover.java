package ActionsExample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseHover 
{
	private WebDriver driver;
	private static final int delay = 10;
	
	@BeforeTest 
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(delay, TimeUnit.SECONDS);
		driver.get("https://www.telerik.com/support/demos");
	}
	
	@Test
	public void letsMouseHover() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement mainMenuElement = driver.findElement(By.xpath("//button[@class = 'TK-Products-Menu-Item-Button']"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement cookiesAcceptButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
		cookiesAcceptButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(mainMenuElement));
		actions.moveToElement(mainMenuElement).build().perform();
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDown() {
		if(driver!=null)
			driver.quit();
	}
}
