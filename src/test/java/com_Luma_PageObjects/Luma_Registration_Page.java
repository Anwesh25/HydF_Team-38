package com_Luma_PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Luma_Registration_Page {
	
	public static WebDriver driver;
	//3 parts
	//1) constructor
	public Luma_Registration_Page(WebDriver dr) {
		this.driver=dr;	//ambiguties issues
		PageFactory.initElements(dr, this);
	}
	
	//identification of the Elements
	@FindBy(xpath="(//a[text()='Create an Account'])[1]")
	WebElement linkCreateAnAccount;
	
	@FindBy(xpath="//*[@id='firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//*[@id='lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//*[@id='email_address']")
	WebElement txtEmail;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='password-confirmation']")
	WebElement txtCPassword;
	
	@FindBy(xpath="//button[@type='submit'][@class='action submit primary']")
	WebElement btncreateAnAccount;
	
	
	//create an Actions
	public void CreateAnAccountLink() {
		linkCreateAnAccount.click();
	}
	
	public void SetFirstName(String Fname) {
		txtFirstName.sendKeys(Fname);
	}
	
	public void SetLastName(String Lname) {
		txtLastName.sendKeys(Lname);
	}

	public void SetEmail(String Email) {
		txtEmail.sendKeys(Email);
	}
	
	public void SetPassword(String pass) {
		txtPassword.sendKeys(pass);
	}
	
	public void SetCPassword(String Cpass) {
		txtCPassword.sendKeys(Cpass);
	}
	
	public void clickCreateAnAccount() {
		btncreateAnAccount.click();
	}
}
