package learning;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction{
	
	public static void main(String[] args) {	
		/* to invoke browser driver to run selenium code
		 selenium looks for key,value where
		 key=webdriver.browserName.driver , value=path of driver */
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		
		// import driver object for browser
		ChromeDriver driver = new ChromeDriver();
		// to hit url on the browser
		driver.get("https://www.google.com");
		driver.get("https://drive.google.com");
		System.out.println(driver.getTitle());	// to get the title of the page
		System.out.println(driver.getCurrentUrl());	// to get the url of current website
		driver.close();		// to close the current window
		//driver.quit();		// to close all the window
	}

}
