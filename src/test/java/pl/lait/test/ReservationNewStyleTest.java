package pl.lait.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pl.lait.pageObj.MainPage;
import pl.lait.pageObj.ReservationPage;

public class ReservationNewStyleTest {

	WebDriver driver;

	@Before
	public void openPage() {
		System.out.println(" -- wewnątrz Before");
		driver = Init.getDriver();
	}

	@Test
	public void LoginTest() {
		System.out.println(" -- wewnątrz logintest");
		MainPage mp = new MainPage(driver); // konstruktor
		ReservationPage rp = new ReservationPage(driver);
		mp.goToLoginPage();
		mp.loginAs("lugasz", "123456");
		rp.continueClick();
	}
	
	@After
	public void tearDown() {
		Init.end();
	}

}
