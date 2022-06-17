package com.nexsoft.phptravels_ujian04;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRegisterFunctionality {
	protected WebDriver driver;
	private JavascriptExecutor jsExe;

	public void timing(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String screenshot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String waktu = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String namaFile = "D:\\EclipseWorkSpace\\Day20_PHPTravels_UjianM04\\screenshot\\" + waktu + ".png";
		File screenshot = new File(namaFile);
		try {
			FileUtils.copyFile(srcFile, screenshot);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return namaFile;
	}

	@BeforeTest
	public void init() {
		System.setProperty("url", "https://petstore.octoperf.com/");
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		jsExe = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get(System.getProperty("url"));
	}

	@BeforeMethod
	public void cekSession() {
		driver.get(System.getProperty("url"));

		// cek session user telah login atau belum
		HomePage home = PageFactory.initElements(driver, HomePage.class);
//		home.clickSignIn().loginValidUser("intanjuniar101@gmail.com", "10101010");
//		driver.get(System.getProperty("url"));
//		home.logout();
	}

//	Tanpa selected form
	@Test(priority = 1)
	public void testRegister_tipedata_Sesuai() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickRegister().registerUser("hehe", "098765", "098765", "taan", "andari", "tantan91@gmail.com",
				"08127238221", "Jl. cempaka hijau no.32", "Jl. Karawaci 13", "Tangerang", "Banten", "15112 ",
				"Indonesia", "english", "FISH");
//		Delay to screenshot
		timing(300);
//		Take screenshot
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);
	}

	@Test(priority = 2) // Data yang sama, dengan password dan repeat tidak sama
	public void testRegister_Pass_and_repeatPassword_notSame_with_SameAccInformationSame() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickRegister().registerUser("hehe", "098765", "123456", "taan", "andari", "tantan91@gmail.com",
				"08127238221", "Jl. cempaka hijau no.32", "Jl. Karawaci 13", "Tangerang", "Banten", "15112 ",
				"Indonesia", "english", "FISH");
//		Delay to screenshot
		timing(300);
//		Take screenshot
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);
	}

	@Test(priority = 3) // Data yang sama, dengan tipe data firstName dan lasName notString
	public void testRegister_firstName_and_lastName_notStringh_with_SameAccInformationSame() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickRegister().registerUser("hehe", "098765", "098765", "1234", "5678", "tantan91@gmail.com",
				"08127238221", "Jl. cempaka hijau no.32", "Jl. Karawaci 13", "Tangerang", "Banten", "15112 ",
				"Indonesia", "english", "FISH");
//		Delay to screenshot
		timing(300);
//		Take screenshot
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);
	}

	@Test(priority = 4) // Data yang sama, dengan tipe data phone dan zimCode tidak sesuai
	public void testRegister_phone_and_zipCode_notNumber_with_SameAccInformationSame() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickRegister().registerUser("hehe", "098765", "098765", "taan", "andari", "tantan91@gmail.com",
				"asdfghjkl", "Jl. cempaka hijau no.32", "Jl. Karawaci 13", "Tangerang", "Banten", "abcde ", "Indonesia",
				"english", "FISH");
//		Delay to screenshot
		timing(300);
//		Take screenshot
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);
	}

	@Test(priority = 5) // Data yang sama, dengan city dan state yang tidak sesuai
	public void testRegister_city_and_state_notvalid_with_SameAccInformationSame() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickRegister().registerUser("sakjdgaks", "834683", "834683", "hahsh", "inaaa", "tiyaan91@gmail.com",
				"089035798325", "Jl. cempaka hijau no.32", "Jl. Karawaci 13", "Jakarta Selatan", "Jawa Barat", "53122 ",
				"Indonesia", "english", "FISH");
//		Delay to screenshot
		timing(300);
//		Take screenshot
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);
	}

	@Test(priority = 6) // Password dan repeat tidak sama
	public void testRegister_Pass_and_repeatPassword_notSame() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickRegister().registerUser("hahah", "2364326", "89734289364", "nali", "katak", "narakalina@gmail.com",
				"08623876832564", "Jl. penugassa barat no.30", "Jl. ghadfah 10", "Tangerang", "Banten", "15112 ",
				"Indonesia", "english", "FISH");
//		Delay to screenshot
		timing(300);
//		Take screenshot
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);
	}

	@Test(priority = 7) // Tipe data firstName dan lasName notString
	public void testRegister_firstName_and_lastName_notString() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickRegister().registerUser("kakana", "22222", "22222", "74363436", "001", "kakakak@gmail.com",
				"0816281328", "Jl. pelangi jhdgashd no.112", "Jl. ajshgajsdg 113", "Tangerang", "Banten", "15112 ",
				"Indonesia", "english", "FISH");
//		Delay to screenshot
		timing(300);
//		Take screenshot
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);
	}

	@Test(priority = 8) // Tipe data phone dan zipCode tidak sesuai
	public void testRegister_phone_and_zipCode_notNumber() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickRegister().registerUser("katara", "00839748", "00839748", "nana", "katar", "kataraa111@gmail.com",
				"9343029503", "Jl. hijau no.112", "Jl. Nama Melayu 113", "Tangerang", "Banten", "15112 ", "Indonesia",
				"english", "FISH");
//		Delay to screenshot
		timing(300);
//		Take screenshot
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);
	}

	@Test(priority = 9) // Data city dan state tidak sesuai
	public void testRegister_city_and_state_notvalid() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickRegister().registerUser("katara", "11111", "11111", "74363436", "001", "kataraa111@gmail.com",
				"0816281328", "Jl. pelangi hijau no.112", "Jl. Melayu 113", "Banyumanik", "Banten", "15112 ",
				"Indonesia", "english", "FISH");
//		Delay to screenshot
		timing(300);
//		Take screenshot
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);
	}

	@Test(priority = 10) // Tidak menginputkan data
	public void testRegister_Data_Null() {

		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.clickRegister().registerUser("", "", "", "", "", "", "", "", "", "", "", " ", "", "english", "FISH");
//		Delay to screenshot
		timing(300);
//		Take screenshot
		jsExe.executeScript("window.scrollBy(0, 100)", "");
		String file = "<img src='file://" + screenshot() + "'height=\"500\" width=\"1200\"/>";
		Reporter.log(file);
	}

}
