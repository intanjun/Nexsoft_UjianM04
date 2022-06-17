package com.nexsoft.phptravels_ujian04;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	protected WebDriver driver;

//	Versi Page Object Model(POM)
//	private By email = By.xpath("//input[@placeholder='Email']");
//	private By password = By.xpath("//input[@placeholder='Password']");
//	private By btnSignIn = By.xpath("//button[@type='submit']");	

//	Versi Page factory
	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement password;

	@FindBy(xpath = "//input[@name='signon']")
	private WebElement btnLogIn;

	@FindBy(xpath = "//a[@class='btn btn-outline-primary btn-block form-group effect ladda-sm ladda-button waves-effect']")
	private WebElement btnSignUp;
	
	@FindBy(xpath = "//p[normalize-space()='E-mail Address and Password do not match.']")
	private WebElement errorPassword;

	@FindBy(xpath = "//p[normalize-space()='User does not exist']")
	private WebElement errorUsername;

//	@FindBy(xpath = "//div[@class='callout callout-error']")
	@FindBy(xpath = "//p[normalize-space()='The Username field is required.']")
	private WebElement errorNull;
	
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
//	Versi POM
//	public Dashboard loginValidUser(String username, String user_password) {
//		driver.findElement(email).clear();
//		driver.findElement(email).sendKeys(username);
//		driver.findElement(password).clear();
//		driver.findElement(password).sendKeys(user_password);
//		driver.findElement(btnSignIn).click();
//		
//		return new Dashboard(driver);
//	} 

//	Versi Page Factory
	public Dashboard loginValidUser(String userID, String user_password) {
		username.sendKeys(userID);
		password.clear();
		password.sendKeys(user_password);
		btnLogIn.click();

		return PageFactory.initElements(driver, Dashboard.class);
	}
	
	/*
	public String getErrorPassword() {
		return errorPassword.getText();
	}

	public String getErrorUsername() {
		return errorUsername.getText();
	}

	public String getErrorNull() {
		return errorNull.getText();
	}
	*/
}
