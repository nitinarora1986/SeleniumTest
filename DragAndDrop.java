package ActionsExample;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop 
{
	private WebDriver driver;
	static final int delay = 10;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
	}
	
	@Test
	public void tryDragAndDrop() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, delay);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("demo-frame")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("draggable")));
		WebElement source = driver.findElement(By.id("draggable"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("ui-droppable")));
		WebElement destination = driver.findElement(By.className("ui-droppable"));
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, destination).build().perform();
		String actualText = driver.findElement(By.className("ui-state-highlight")).getText();
		Assert.assertEquals(actualText, "Dropped!");
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDown() {
		if(driver!=null)
			driver.quit();
	}
}
