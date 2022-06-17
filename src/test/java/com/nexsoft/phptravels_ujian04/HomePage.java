package com.nexsoft.phptravels_ujian04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	protected WebDriver driver;
	
//	Versi Page Object Model(POM)
//	private By signIn = By.xpath("//a[@class='page-scroll']");
//	private By languageSetting = By.xpath("//a[@class='dropdown-toggle']");
	
	
//	Versi Page Factory
	@FindBy(xpath = "//a[normalize-space()='Enter the Store']")
	private WebElement enterStore;
	
	@FindBy(xpath = "//a[normalize-space()='Sign In']")
	private WebElement signIn;
	
	@FindBy(xpath = "//a[normalize-space()='Register Now!']")
	private WebElement register;
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
//	Versi POM
//	public SignInPage clickSignIn() {
//		driver.findElement(signIn).click();
//		return new SignInPage(driver);
//	}
	

	public RegisterPage clickRegister() {
		enterStore.click();
		signIn.click();
		register.click();
		RegisterPage registerPage = PageFactory.initElements(driver,RegisterPage.class);
		return registerPage;
	}
	
	public SignInPage clickSignIn() {
		enterStore.click();
		signIn.click();
		SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
		return signInPage;
	}
	
//	public boolean checkSession() {
//		if (signIn != null) {
//			return true;
//		} else {
//			return false;
//		}
//	}

	
//	
//	public void forgotPassword() {
//		forgotPass.click();
//	}
}
