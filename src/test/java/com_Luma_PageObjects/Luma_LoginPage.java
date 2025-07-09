package com_Luma_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Luma_LoginPage {
	public static WebDriver driver;
	public Luma_LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="(//*[@id='pass'])[1]")
	WebElement txtpass;
	
	@FindBy(xpath="(//*[text()='Sign In'])[1]")
	WebElement signinbtn;
	
	public void setEmail(String Email) {
		txtEmail.sendKeys(Email);
	}
	
	public void setpassword(String pass) {
		txtpass.sendKeys(pass);
	}
	
	public void clicksigninbtn() {
		signinbtn.click();
	}
	
	public void clearEmail() {
		txtEmail.clear();
	}
	
	public void clearpassword() {
		txtpass.clear();
	}

}
