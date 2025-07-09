package com_Luma_TestCases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

public class Luma_BaseClass {
	public Logger log;
	public static WebDriver driver;
	public ResourceBundle rb;
	@BeforeSuite
	@Parameters({"browser","URL"})
	public void OpenApplication(String br, String url) {
		if(br.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(br.equals("Edge")) {
			driver = new EdgeDriver();
		}
		else if(br.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		rb = ResourceBundle.getBundle("Data");
		log = Logger.getLogger("HydF_Team_38");
		PropertyConfigurator.configure("log4j.properties");
		
	}
	
	public String CaptureScreenShots(String tname) {
		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		TakesScreenshot sc = (TakesScreenshot)driver;
		
		File Source = sc.getScreenshotAs(OutputType.FILE);
	//	File trg = new File("");
		String Target = System.getProperty("user.dir") + "\\Screenshots_Luma\\"+ tname + "_"+timestamp+".png";
		try {
		FileUtils.copyFile(Source, new File(Target));
		}
		catch(Exception e) {
			e.getMessage();
		}
		return Target;
	}
	
/*	
	@AfterSuite
	public void CloseApplication() {
		driver.close();
	}
*/
}
