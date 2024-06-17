package testCases;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class SwappingiOS {
	IOSDriver driver;
	@Test
	public void swappingTest() throws MalformedURLException {
		XCUITestOptions options=new XCUITestOptions();
		options.setDeviceName("iPhone 15 pro");
		options.setUdid("19892155-DA94-4064-8C94-EA26678375AE");
		options.setAutomationName("XCUITest");
		options.setPlatformName("IOS");
		options.setPlatformVersion("17.5");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		URL url =new URL("http://127.0.0.1:4723/");
		driver=new IOSDriver(url,options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		Map<String,String> params=new HashMap<>();
		params.put("bundleId","com.apple.mobileslideshow");
		driver.executeScript("mobile:launchApp", params);
		List<WebElement> ele=driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
		System.out.println(ele.size());
		driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell[1]")).click();
		
		
		
		
		for(int i=0;i<ele.size();i++) {
			String timeStamp=driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeNavigationBar")).getAttribute("name");
			System.out.println(timeStamp);
			Map<String,Object> params1=new HashMap<>();
			params1.put("direction", "left");
			driver.executeScript("mobile:swipe", params1);
			
		}
	}

}
