package appiumnewtest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import appiumnewtest.CreateReport ;

public class MonefyTest extends CreateReport {
	
	public static AppiumDriver driver; //To run Appium driver
	
	
/* To Setup before launching the app in the emulator/device*/	
	@BeforeTest
	public static void setup() throws MalformedURLException {
		
		
		try {
		} catch (Exception e) {
			
			System.out.println(e.getCause());
			System.out.println(e.getMessage());	
			e.printStackTrace();
		}
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "emulator-5554"); //Using Android emulator [Nexus 5 API 26] here
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion", "8.0");
		capabilities.setCapability("noReset", true);
		
		
		capabilities.setCapability("appPackage", "com.android.vending"); //Play Store app package
		// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity", "com.google.android.finsky.activities.MainActivity"); //Play store activity
		// This is Launcher activity of your app (you can get it from apk info app)
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub"); 
		//URL and port where the Appium server is running
		
		driver = new AppiumDriver(url,capabilities); //Start Appium driver
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		
		logger = extent.createTest("Install & Launch the Monefy app from Playstore");
    	
    	
    }
	
	@Test(priority=1)
	public static void InstallAppFromPlayStore() throws InterruptedException {
	 
		/*Open play store, search for the monefy app & install it*/
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView")).click();
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.EditText")).sendKeys("Monefy App");
		driver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[1]/android.widget.LinearLayout[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class = 'android.widget.Button']")).click(); //App is installed
		Thread.sleep(30000);
		driver.findElement(By.xpath("//*[@class = 'android.widget.Button']")).click(); //Open the App
		Thread.sleep(5000);
		
		driver.findElement(By.id("com.monefy.app.lite:id/buttonContinue")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("com.monefy.app.lite:id/buttonContinue")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("com.monefy.app.lite:id/buttonContinue")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("com.monefy.app.lite:id/buttonClose")).click();
				Thread.sleep(2000);
				
	}
	
	@Test(priority=2)
	public static void AddNewAccount() throws InterruptedException {
		
		/*Steps to add new account in the Monefy App*/
				
				driver.findElement(By.id("com.monefy.app.lite:id/overflow")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("com.monefy.app.lite:id/accounts_button")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("com.monefy.app.lite:id/imageButtonAddCategory")).click();
				Thread.sleep(1000);
				driver.findElement(By.id("com.monefy.app.lite:id/editTextCategoryName")).sendKeys("Account Test New"); //Entering the name of the account
				driver.findElement(By.id("com.monefy.app.lite:id/save")).click();
				Thread.sleep(2000);
				driver.navigate().back();
				driver.navigate().back();
				driver.navigate().back();
				
	//Account type selection UI elements have no unique identifiers. Using x-path is not reliable here
				
				
	}
	
	@Test(priority=3)
	public static void AddNewIncome() throws InterruptedException {
		
		/*To Add new income from the app*/
				
				driver.findElement(By.id("com.monefy.app.lite:id/income_button")).click();
				Thread.sleep(2000);
				driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard2")).click();
				driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard5")).click();
				
				driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard0")).click();
				driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard0")).click();
				driver.findElement(By.id("com.monefy.app.lite:id/textViewNote")).sendKeys("Income Test1");
				driver.findElement(By.id("com.monefy.app.lite:id/keyboard_action_button")).click();
				Thread.sleep(2000);
				driver.navigate().back();
				driver.navigate().back();
				
	//Income category selection UI elements have no unique identifiers. Using x-path is not reliable here
				
	}
	
	@Test(priority=4)
	public static void AddNewExpense() throws InterruptedException {
		
		/*Adding new expense in the app*/
				
				driver.findElement(By.id("com.monefy.app.lite:id/expense_button")).click();
				Thread.sleep(2000);
				
				driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard1")).click();
				driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard5")).click();
				
				driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard0")).click();
				driver.findElement(By.id("com.monefy.app.lite:id/buttonKeyboard0")).click();
				driver.findElement(By.id("com.monefy.app.lite:id/textViewNote")).sendKeys("Expense Test1");
				driver.findElement(By.id("com.monefy.app.lite:id/keyboard_action_button")).click();
				driver.navigate().back();
				
	//Expense category selection UI elements have no unique identifiers. Using x-path is not reliable here
		
	}
	
	@AfterTest
   	public void teardown() {
	System.out.println("Appium Test Ended");
   	driver.quit();
   	}
	
}
