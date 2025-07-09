package com_Luma_TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com_Luma_PageObjects.Luma_Registration_Page;

public class Tc_01_Luma_Registration extends Luma_BaseClass{
	
	public Luma_Registration_Page lr;
	@Test
	public void lumaRegistrationPage() throws InterruptedException {
		lr = new Luma_Registration_Page(driver);
		lr.CreateAnAccountLink();
		log.info("Luma Create an Account Clicking Action is Done!");
		
		lr.SetFirstName(rb.getString("FirstName"));
	//	System.out.println("The first Name is Entered");
		log.info("First name entered Successfully");
		
		Thread.sleep(2000);
		lr.SetLastName(rb.getString("LastName"));
	//	System.out.println("The Last Name is Entered");
		log.info("Last Name Entered successfully");
		
		lr.SetEmail(rb.getString("Email"));
	//	System.out.println("The Email is Entered");
		log.info("Email Address Entered successfully");
		Thread.sleep(2000);
		lr.SetPassword(rb.getString("password"));
	//	System.out.println("The Password is Entered");
		log.info("Password Entered successfully");
		
		lr.SetCPassword(rb.getString("ConfirmPassword"));
	//	System.out.println("The confirmPassword is Entered");
		log.info("Confirm Password Entered successfully");
		
		Thread.sleep(2000);
		lr.clickCreateAnAccount();
		log.info("Registration Done Successfully");
		
		String Exp_title = "My Account";
		String Act_title = driver.getTitle();
		
		if(Act_title.equals(Exp_title)) {
			Assert.assertTrue(true);
			System.out.println("Pass");
		}else {
			System.out.println("Fail");
			Assert.assertTrue(false);
			
			
		}
	}

}
