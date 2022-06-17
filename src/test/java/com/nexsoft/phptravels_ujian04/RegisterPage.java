package com.nexsoft.phptravels_ujian04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

	WebDriver driver;
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userID;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement newPassword;
	@FindBy(xpath = "//input[@name='repeatedPassword']")
	private WebElement repeatPassword;
	@FindBy(xpath = "//input[@name='account.firstName']")
	private WebElement firstName;
	@FindBy(xpath = "//input[@name='account.lastName']")
	private WebElement lastName;
	@FindBy(xpath = "//input[@name='account.email']")
	private WebElement email;
	@FindBy(xpath = "//input[@name='account.phone']")
	private WebElement phone;
	@FindBy(xpath = "//input[@name='account.address1']")
	private WebElement adress1;
	@FindBy(xpath = "//input[@name='account.address2']")
	private WebElement adress2;
	@FindBy(xpath = "//input[@name='account.city']")
	private WebElement city;
	@FindBy(xpath = "//input[@name='account.state']")
	private WebElement state;
	@FindBy(xpath = "//input[@name='account.zip']")
	private WebElement zipCode;
	@FindBy(xpath = "//input[@name='account.country']")
	private WebElement country;
	
	@FindBy(xpath = "//select[@name='account.languagePreference']")
	private WebElement selectorLanguage;
	@FindBy(xpath = "//select[@name='account.favouriteCategoryId']")
	private WebElement selectorFavourite;
	@FindBy(xpath = "//input[@name='newAccount']")
	private WebElement btnSaveAcc;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public Dashboard registerUser(String user_userID, String user_password, String user_repeatPsw, String user_firstName,String user_lastName, String user_email, 
			String user_phone, String user_address1, String user_address2, String user_city, String user_state, String user_zipCode, String user_country, String selector_Language, String selector_Favourite ) {
//		User Information
		userID.clear();
		userID.sendKeys(user_userID);
		newPassword.clear();
		newPassword.sendKeys(user_password);
		repeatPassword.clear();
		repeatPassword.sendKeys(user_repeatPsw);
//		Account Information
		firstName.clear();
		firstName.sendKeys(user_firstName);
		lastName.clear();
		lastName.sendKeys(user_lastName);
		email.clear();
		email.sendKeys(user_email);
		phone.clear();
		phone.sendKeys(user_phone);
		adress1.clear();
		adress1.sendKeys(user_address1);
		adress2.clear();
		adress2.sendKeys(user_address2);
		city.clear();
		city.sendKeys(user_city);
		state.clear();
		state.sendKeys(user_state);
		zipCode.clear();
		zipCode.sendKeys(user_zipCode);
		country.clear();
		country.sendKeys(user_country);
		Select select = new Select(selectorLanguage);
		select.selectByValue(selector_Language);
		Select select2 = new Select(selectorFavourite);
		select2.selectByValue(selector_Favourite);
		btnSaveAcc.click();

		return PageFactory.initElements(driver, Dashboard.class);
	}
	
	
}
