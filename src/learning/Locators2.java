package learning;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		/*
		 * traverse sibling locators (not possible in CSS)
		 * //parent/child/following-sibling::siblingTagName
		 */
		driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();

		/*
		 * traverse child to parent locators (not possible in CSS)
		 * //parent/child/parent::parentTagName
		 */
		driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText();

	}

}
