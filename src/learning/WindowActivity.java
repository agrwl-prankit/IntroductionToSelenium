package learning;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivity {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// to maximize the window
		driver.manage().window().maximize();
		driver.get("https://www.google.com"); // selenium will wait until all the components do not load.
		// navigate to another website on the same tab
		driver.navigate().to("https://www.udemy.com");	// no implicit synchronization wait
		// back to the previous URL
		driver.navigate().back();
		
		
	}

}
