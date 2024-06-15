package testCases;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import baseSetUp.BaseClass;
import io.appium.java_client.AppiumBy;

public class DemoTest extends BaseClass{
	
	@Test
	public void testOne() throws MalformedURLException {
		driver=setUp();
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Search']")).click();
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Default']")).click();
		driver.findElement(By.xpath("//XCUIElementTypeSearchField")).sendKeys("Vivek");
		driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Cancel']")).click();
	}
	
	@Test
	public void testTwoiOSclassChain() throws MalformedURLException {
		driver=setUp();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == 'Alert Views'`]")).click();
		driver.findElement(AppiumBy.accessibilityId("Text Entry")).click();
		driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell[5]")).sendKeys("Hello World");
		driver.findElement(AppiumBy.accessibilityId("OK")).click();
		
	}
	@Test
	public void testLongPress() throws MalformedURLException {
		driver=setUp();
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == 'Steppers'`]")).click();
		WebElement ele=driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Increment'`][3]"));
		Map<String,Object> params=new HashMap<>();
		params.put("element", ((RemoteWebElement)ele).getId());
		params.put("duration", 7);
		driver.executeScript("mobile:touchAndHold", params);
		
		}
	@Test
 	public void testScroll() throws MalformedURLException, InterruptedException {
		driver=setUp();
		WebElement ele=driver.findElement(AppiumBy.accessibilityId("Web View"));
		Map<String,Object> params=new HashMap<>();
		params.put("direction", "down");
		params.put("element", ((RemoteWebElement)ele).getId());
		driver.executeScript("mobile:scroll", params);
		ele.click();
		
	}
	@Test
	public void testDropDown() throws MalformedURLException {
		driver=setUp();
		driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
		driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("90");
		driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("245");
		driver.findElement(AppiumBy.accessibilityId("Blue color component value")).sendKeys("140");
	}
  }
