package pl.lait.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Init {

	static WebDriver driver = null;

	public static WebDriver getDriver() {
		
		if (driver == null) {   // jesli driver JEST null 
			System.out.println(" -- wewnątrz getDriver null");
			System.setProperty("webdriver.chrome.driver", "C:/Users/lukif/OneDrive/Dokumenty/SeleniumLibs/chromedriver.exe" );
			 //driver = new ChromeDriver();
			
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			
			URL remoteAddress = null;
			try {
				remoteAddress = new URL("http://localhost:4444/wd/hub");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver = new RemoteWebDriver(remoteAddress, capabilities);
			
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); // test czeka 40 sekund 
			// driver.manage().      // eksperymentować z komendami po manage().
			
			Dimension rozmiarOkna = driver.manage().window().getSize();
			int wys = rozmiarOkna.height;
			int szer = rozmiarOkna.width;
			System.out.println("rozmiar okna "
					+ "to: " + wys + " x " + szer);
			
			driver.get("http://newtours.demoaut.com/");
			return driver;
		}
			else {
			System.out.println("wewnatrz getDriver else");
			return driver;
					}
	}
	
			public static void end() {
				driver.quit();
				driver = null;
			}
	
}
