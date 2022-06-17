package com.nexsoft.phptravels_ujian04;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
protected WebDriver driver;

	@FindBy(xpath = "//img[@src='../images/logo-topbar.gif']")
	private WebElement btn_dashboard;

	@FindBy(xpath = "//div[@id='WelcomeContent']" )
	private WebElement firstName;
	
	@FindBy(xpath = "//a[normalize-space()='Sign Out']")
	private WebElement signOut;
	
	public Dashboard(WebDriver driver) {
		this.driver = driver;
	}
	
//	public CRUDBuilderPage clik_dashboard() {
//		String klik = btn_dashboard.click();
//		return klik;
//	}

	public String getFisrtName() {
		return firstName.getText();
	}
	public String getSignIn() {
		return btn_dashboard.getText();
	}
	
	public void logout() {
		signOut.click();
	}
}
