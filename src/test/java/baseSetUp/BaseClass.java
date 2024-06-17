package baseSetUp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class BaseClass {
	
	 public IOSDriver driver;
	
	public IOSDriver setUp() throws MalformedURLException {
		XCUITestOptions options=new XCUITestOptions();
		options.setDeviceName("iPhone 15 pro");
		options.setUdid("19892155-DA94-4064-8C94-EA26678375AE");
		options.setApp("/Users/hispl/eclipse-workspace/iOSAutomation/resources/UIKitCatalog.app");
		options.setAutomationName("XCUITest");
		options.setPlatformName("IOS");
		options.setPlatformVersion("17.5");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		URL url =new URL("http://127.0.0.1:4723/");
		driver=new IOSDriver(url,options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		return driver;
		
	}

}
