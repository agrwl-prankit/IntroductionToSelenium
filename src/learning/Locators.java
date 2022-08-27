package learning;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {
	
	/* to uniquely identify the elements on web page
	 * contains- id, xPath, CSS selector, name, className
	 * tagName, linkText, partial linkText*/

	public static void main(String[] args){
		
		// invoking Chrome driver
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/*
		 * // invoking Firefox driver
		 * System.setProperty("webdriver.gecko.driver", "path of driver");
		 * WebDriver driver = new FirefoxDriver();
		 */
		
		/*
		 * // invoking Microsoft Edge
		 * System.setProperty("webdriver.edge.driver", "path of driver");
		 * WebDriver driver = new EdgeDriver();
		 */
		
		/*
		 * as selenium is very fast, sometimes website takes time to update
		 * to use script after synchronization, we have an option to use implicit wait
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));	// wait for objects to show
		
		// open site on browser
		driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
		
		/*
		 * different ways to find elements
		 * ID, name, class name, CSS selector, xPath, link text, partial link text
		 */
		/* CSS selector and XPath is special type of locator. We can find any type of element and 
		 * we can extract the locator from HTML code using CSS selector
		 * different ways to make CSS selector
		 * tagName.class, tagName#id, tagName[key='value']
		 * different ways to write XPath
		 * usingTagName (customized syntax)- //tagName[@key='value']
		 */
		
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		driver.findElement(By.linkText("Forgot your password?")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Prankit");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("prankit@gma.com");
		
		/*
		 * if multiple elements are present for particular XPath or CSS selector
		 * or no unique address is available for elements
		 * use [index] or nth-child at the end of selector.
		 * example- //tagName[@key='value'][index]
		 * 			tagName[key='value']:nth-child(index)
		 */
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("prankit@gmail.com");
		
		/* 
		 * find element using tags only (parentToChild strategy)
		 * CSS - parentTag childTag - (use index for multiple same child tag)
		 * xPath - //parentTag/childTag[index] - (use index for multiple same child tag) (Relative xPath)
		 * Relative xPath - not starting from the root (HTML tag) but starting from middle
		 */
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("0123456789");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		// regular expression using CSS- tagName[key*='staticWordsOfDynamicValue']
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		// regular expression using xPath - //tagName[contains(@key,'staticWordsOfDynamicValue')]
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		String successMsg = driver.findElement(By.cssSelector("p")).getText();
		if(successMsg.equals("You are successfully logged in.")) {
			System.out.println("logged in");
			/*
			 * get text of button
			 * no CSS selector for this
			 * using xPath- //button[text()='buttonText']
			 */
			driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		} else {
			System.out.println("trouble to logged in");
		}
		driver.close();
	}
}

/*
 * ElementInterceptedExxception (usually occur in single page application)
 * When page is in refresh state script are trying to perform operation
 * but is unable to do the action as page is not stable. This exception appears.
 * for that use Thread.sleep(timeInMiliSecond);
 */
