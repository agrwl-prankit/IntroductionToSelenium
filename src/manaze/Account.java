package manaze;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Account {
	
	private static String email = "prakhar.agarwal@unthinkable.co";
	private static String firstName = email.split("@")[0].split("\\.")[0].replaceFirst("p", "P");
			//email.split("@")[0].split("\\.")[0].toUpperCase();
	private static String lastName = email.split("@")[0].split("\\.")[1].replaceFirst("a","A");
	//email.split("@")[0].split("\\.")[1].toUpperCase();
	private static String password = "PRAKhar@2000";
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().window().maximize();
		driver.get("https://web5.manaze.io/");
		
		login(driver);
		printProfile(driver);
		AccountDetail(driver);
		
		driver.close();
	}

	private static void AccountDetail(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='Employment']/parent::div/parent::div/parent::div/parent::div/following-sibling::div[1]/div/div/div/div")).click();
		Thread.sleep(2000);
		String subsidiary, unit, department, sitting, accounting, accountName, accountNumber, ifscCode;
		subsidiary = driver.findElement(By.xpath("//div[text()='SUBSIDIARY']/parent::div/following-sibling::div/div")).getText();
		unit = driver.findElement(By.xpath("//div[text()='UNIT']/parent::div/following-sibling::div/div")).getText();
		department = driver.findElement(By.xpath("//div[text()='DEPARTMENT']/parent::div/following-sibling::div/div")).getText();
		sitting = driver.findElement(By.xpath("//div[text()='SITTING LOCATION']/parent::div/following-sibling::div/div")).getText();
		accounting = driver.findElement(By.xpath("//div[text()='ACCOUNTING LOCATION']/parent::div/following-sibling::div/div")).getText();
//   //div[text()='BANK NAME']/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div/following-sibling::div/div/div[1]/div[2]/div/div/div
		accountName = driver.findElement(By.xpath("//div[text()='BANK NAME']/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div/following-sibling::div/div/div[1]/div[2]/div/div/div")).getText();
		accountNumber = driver.findElement(By.xpath("//div[text()='BANK NAME']/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div/following-sibling::div/div/div[1]/div[3]/div/div/div")).getText();
		ifscCode = driver.findElement(By.xpath("//div[text()='BANK NAME']/parent::div/parent::div/parent::div/parent::div/parent::div/parent::div/following-sibling::div/div/div[1]/div[5]/div/div/div")).getText();
		
		System.out.println("Profile Details:");
		System.out.println("Subsidiary: "+subsidiary+"\n"+"Unit: "+unit+"\n"+"Department: "+department+"\n"+
				"Sitting Location: "+sitting+"\n"+"Accounting Location: "+accounting+"\n"+
				"Account Name: "+accountName+"\n"+"Account Number "+accountNumber+"\n"+"IFSC Code: "+ifscCode);
	}

	private static void printProfile(WebDriver driver) {
		driver.findElement(By.cssSelector("div[title='"+firstName+" "+lastName+" "+"']")).click();
		driver.findElement(By.xpath("//div[text()='Profile']")).click();

		String name, email, code, phone, reportingManagerName, reportingManagerEmail, peopleManagerName, peopleManagerEmail;
		name = driver.findElement(By.xpath("//div[text()='EMPLOYEE NAME  ']/parent::div/following-sibling::div/div")).getText();
		email = driver.findElement(By.xpath("//div[text()='EMAIL']/parent::div/following-sibling::div/div")).getText();
		code = driver.findElement(By.xpath("//div[text()='Employee Code']/parent::div/following-sibling::div/div")).getText();
		phone = driver.findElement(By.xpath("//div[text()='MOBILE NO ']/parent::div/following-sibling::div/div")).getText();
		reportingManagerName = driver.findElement(By.xpath("//div[text()='REPORTING TO']/parent::div/following-sibling::div/div/div[1]")).getText();
		reportingManagerEmail = driver.findElement(By.xpath("//div[text()='REPORTING TO']/parent::div/following-sibling::div/div/div[2]")).getText();
		peopleManagerName = driver.findElement(By.xpath("//div[text()='PEOPLE MANAGER']/parent::div/following-sibling::div/div/div[1]")).getText();
		peopleManagerEmail = driver.findElement(By.xpath("//div[text()='PEOPLE MANAGER']/parent::div/following-sibling::div/div/div[2]")).getText();

		System.out.println("Profile Details:");
		System.out.println("Employee Name: "+name+"\n"+"Employee Code: "+code+"\n"+
				"Employee Email: "+email+"\n"+"Employee Phone: "+phone+"\n"+
				"Reporting Manager Name: "+reportingManagerName+"\n"+"Reporting Manager Email: "+reportingManagerEmail+"\n"+
				"People Manager Name: "+peopleManagerName+"\n"+"People Manager Email: "+peopleManagerEmail);
	}

	private static void login(WebDriver driver) {
		driver.findElement(By.cssSelector("input[placeholder='Email Id'")).sendKeys(email);
		driver.findElement(By.cssSelector("input[type='Password'")).sendKeys(password);
		driver.findElement(By.xpath("//div[text()='Sign In']")).click();
	}

}
