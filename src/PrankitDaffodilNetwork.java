
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class PrankitDaffodilNetwork {

	public static void main(String[] args) throws InterruptedException {
		
		if(getWirelessStrength()>0) authenticate();
		else System.out.println("Please connect to wifi first");

	}
	
	public static void authenticate() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		driver.get("https://172.18.1.1:8090/httpclient.html");
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.linkText("Proceed to 172.18.1.1 (unsafe)")).click();
		driver.findElement(By.id("username")).sendKeys("Prankit.Agarwal");
		driver.findElement(By.cssSelector("input#password")).sendKeys("us@portal");
		driver.findElement(By.cssSelector("div[class='button']")).click();
		Thread.sleep(2000);		// wait to change the response
		try {
			Assert.assertEquals(driver.findElement(By.xpath("//div[@id='statusmessage']")).getText(), "Login failed. You have reached the maximum login limit.");
			System.out.println("Already Logged in");
			driver.close();
		} catch (AssertionError e) {
			System.out.println("exception: "+e.getMessage());
			//String limitMsg = driver.findElement(By.xpath("h1[id='signin-caption']")).getText();
			String limitMsg = driver.findElement(By.tagName("h1")).getText();
			Assert.assertEquals(limitMsg, "You are signed in as Prankit.Agarwal");
			if(limitMsg.contains("You are signed in")) {
				System.out.println("Signed in successfully");
				driver.manage().window().minimize();
			}
		}
	}
	
	public static int getWirelessStrength() {
	    List<String> list = new ArrayList<>();
	    int signalStrength = 0;
	    String cmd = "netsh wlan show interfaces"; 
	    try {
	        Process p = Runtime.getRuntime().exec("cmd /c " + cmd);
	        p.waitFor();
	        try (BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                list.add(line);
	            }
	        }
	        if (p.isAlive()) { p.destroy(); }

	        // Get the Signal Strength.
	        for (int i = 0; i < list.size(); i++) {
	            if (list.get(i).trim().toLowerCase().startsWith("signal")) {
	                String[] ss = list.get(i).split(":");
	                if(ss.length == 2) {
	                    signalStrength = Integer.parseInt(ss[1].replace("%","").trim());
	                }
	                break;
	            }
	        }
	    }
	    catch (IOException | InterruptedException ex) {
	    	System.out.println(""+ex);
	    }
	    return signalStrength;
	}

}
