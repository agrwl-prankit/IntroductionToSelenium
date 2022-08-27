package learning;

import java.net.SocketException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) throws SocketException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		/*
		 * static dropdown means fixed visible option in dropdown menu
		 * if dropdown have select tag, then there is a special class in selenium to handle select dropdown
		 * to use this, we have to tell the position of web element (dropdown) 
		 */
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		System.out.println("By index: " + dropdown.getFirstSelectedOption().getText());	// to get the selected options
		dropdown.selectByVisibleText("AED");
		System.out.println("By text: " + dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");	// select using value in HTML tag
		System.out.println("By text: " + dropdown.getFirstSelectedOption().getText());
		
		/*
		 * dynamic dropdown
		 */
		
		driver.close();
	}

}
