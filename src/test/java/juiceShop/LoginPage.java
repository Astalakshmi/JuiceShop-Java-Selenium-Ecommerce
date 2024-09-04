package juiceShop;

import java.time.Duration;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import utilities.LoggerLoad;


public class LoginPage {

	@Test
	public void login() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://juice-shop.herokuapp.com/#/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.manage().window().maximize();
		
		WebElement dismiss_btn=driver.findElement(By.xpath("//*[@id='mat-dialog-0']/app-welcome-banner/div/div[2]/button[2]"));
		dismiss_btn.click();
		WebElement mewantit_btn=driver.findElement(By.xpath("/html/body/div[1]/div"));
		mewantit_btn.click();
	
		//Login Form
		
		WebElement account_navbar=driver.findElement(By.xpath("//span[normalize-space()='Account']"));
		account_navbar.click();
		WebElement navbarLoginButton=driver.findElement(By.id("navbarLoginButton"));
		navbarLoginButton.click();
		
		WebElement email_login=driver.findElement(By.id("email"));
		email_login.sendKeys("astapalanivel@gmail.com");
		WebElement pwd_login=driver.findElement(By.id("password"));
		pwd_login.sendKeys("Asta_1234");
		WebElement submit_login=driver.findElement(By.id("loginButton"));
		submit_login.click();	

	   // Product-Add to cart	

		
		String[][] itemXpaths = {
			    {"//mat-grid-tile[5]//div[1]//mat-card[1]//div[2]//button[1]"}, // Carrot juice on the first page
			    {"//mat-grid-tile[5]/div[1]/mat-card[1]/div[2]/button[1]"},      // Juice Shop Hoodie on the next page
			    {"//mat-grid-tile[7]/div[1]/mat-card[1]/div[2]/button[1]",        // Orange juice on another page
			     "//mat-grid-tile[10]/div[1]/mat-card[1]/div[2]/button[1]"}       // Raspberry juice on the same page
			};

			// XPath for the next page navigator button
			String nextPageXPath = "//button[@aria-label='Next page']//span[@class='mat-button-wrapper']//*[name()='svg']";

			// Iterate through the pages
			for (int i = 0; i < itemXpaths.length; i++) {
			    for (String xpath : itemXpaths[i]) {
			        // Find the button using XPath and click it
			        WebElement itemButton = driver.findElement(By.xpath(xpath));
			        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", itemButton);
			        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", itemButton);
			    }

			    // Navigate to the next page if there's a next page
			    if (i < itemXpaths.length - 1) {
			        WebElement nextPageButton = driver.findElement(By.xpath(nextPageXPath));
			        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextPageButton);
			        nextPageButton.click();
			    }
			}
		
		WebElement basket=driver.findElement(By.xpath("//span[normalize-space()='Your Basket']"));
		basket.click();
		
		String[] plus_xpath= {
				"//mat-row[1]/mat-cell[3]/button[2]",
				"//mat-row[2]/mat-cell[3]/button[2]",
				"//mat-row[3]/mat-cell[3]/button[2]",
				"//mat-row[4]/mat-cell[3]/button[2]"
		};
		
		for (String xpath : plus_xpath) {
		    WebElement plus = driver.findElement(By.xpath(xpath));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", plus);
		    plus.click();
		}
		Thread.sleep(5000);
		WebElement checkout = driver.findElement(By.id("checkoutButton"));
		checkout.click();
		
		//Select Address
		
		WebElement address_btn= driver.findElement(By.xpath("//button[@aria-label='Add a new address']"));
		address_btn.click();
		
		 // Create a Faker instance
		
		Locale locale = new Locale("en", "US");
        Faker faker = new Faker(locale);
        String country=faker.country().name();
        String name=faker.name().fullName();
      //  String phone=faker.phoneNumber().cellPhone();
        String zipcode=faker.address().zipCodeByState("CA");
        String address=faker.address().streetAddress();
        String city=faker.address().cityName();
        String state=faker.address().state();
        
       
		//ADDRESS FORM
		WebElement country_text = driver.findElement(By.id("mat-input-3"));
		country_text.sendKeys(country);
		
		WebElement name_text = driver.findElement(By.id("mat-input-4"));
		name_text.sendKeys(name);
		
		// Phone
		WebElement phone_text = driver.findElement(By.id("mat-input-5"));	
       
     //   String PhoneNumber = phone.replaceAll("[-,.]", ""); // Remove hyphens

        phone_text.sendKeys("8928521471");

		
		//zipcode
		WebElement zipcode_text = driver.findElement(By.id("mat-input-6"));
		zipcode_text.sendKeys(zipcode); 

		WebElement address_text = driver.findElement(By.id("address"));
		address_text.sendKeys(address);
		
		WebElement city_text = driver.findElement(By.id("mat-input-8"));
		city_text.sendKeys(city);
		
		WebElement state_text = driver.findElement(By.id("mat-input-9"));
		state_text.sendKeys(state);
		
		WebElement submit = driver.findElement(By.xpath("//*[@id='submitButton']"));
		submit.click();
		
		//SELECT AN ADDRESS
		
		WebElement select_address= driver.findElement(By.id("mat-radio-42"));
		select_address.click();
		WebElement continue_address= driver.findElement(By.xpath("//*[@id='card']/app-address/mat-card/button"));
		continue_address.click();

		
		//Delivery speed
			//Thread.sleep(5000);
		WebElement select_delivery_speed= driver.findElement(By.xpath("//app-delivery-method/mat-card/div[3]/mat-table/mat-row[3]/mat-cell[1]"));
		select_delivery_speed.click();
		WebElement delivery_speed= driver.findElement(By.xpath("//app-delivery-method/mat-card/div[4]/button[2]"));
		delivery_speed.click();	
		
		//Payment Options
		
		WebElement select_addnewcard= driver.findElement(By.xpath("//*[@id='mat-expansion-panel-header-0']"));
		select_addnewcard.click();
		
		WebElement card_name= driver.findElement(By.id("mat-input-10"));
		card_name.sendKeys("Astalakshmi");
		WebElement card_number= driver.findElement(By.id("mat-input-11"));
		card_number.sendKeys("1231132451056415");
	
		WebElement exp_month= driver.findElement(By.id("mat-input-12"));
		Select month = new Select(exp_month);
		month.selectByVisibleText("7");
		WebElement exp_year= driver.findElement(By.id("mat-input-13"));
		Select year = new Select(exp_year);
		year.selectByVisibleText("2080");
		WebElement submitButton= driver.findElement(By.id("submitButton"));
		submitButton.click();
		
		  //Add Coupon
		WebElement coupon= driver.findElement(By.xpath("//*[@id='mat-expansion-panel-header-1']"));
	//	coupon.click();
		  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", coupon);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", coupon);
		WebElement coupon_textbox= driver.findElement(By.xpath("//*[@id='coupon']"));
		coupon_textbox.sendKeys("1236549871");
		
		Actions actions = new Actions(driver);
		    //REDEEM
		WebElement redeem= driver.findElement(By.xpath("//*[@id='applyCouponButton']"));
		redeem.click();
		    //errortext of redeem
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement redeem_error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='error ng-star-inserted']")));
	//	System.out.println("Error Message: "+redeem_error.getText());
		
		LoggerLoad.error("Error Message :"+redeem_error.getText()); //logging
		
		actions.sendKeys(Keys.PAGE_UP).perform();
		
		Thread.sleep(5000); // Adjust if needed
		
		
		//Select payment Card option
		WebElement select_payment = wait.until(ExpectedConditions.elementToBeClickable(By.className("mat-radio-outer-circle")));
		select_payment.click();
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		// PaymentPage continue btn
		Thread.sleep(2000);
		WebElement payment_continue= driver.findElement(By.xpath("//app-payment/mat-card/div/div[2]/button[2]"));	
		payment_continue.click();
		

		//order summary checkout
		WebElement order_summary= driver.findElement(By.xpath("//*[@id='checkoutButton']"));
		order_summary.click();
	
		//ACCOUNT  VIEW ORDER HISTORY
		WebElement account_nav= driver.findElement(By.xpath("//*[@id='navbarAccount']"));
		account_nav.click();
		WebElement order_payment= driver.findElement(By.xpath("//*[@id='mat-menu-panel-0']/div/button[2]"));
		order_payment.click();
		WebElement order_history= driver.findElement(By.xpath("//*[@id='mat-menu-panel-3']/div/button[1]"));
		order_history.click(); 
		System.out.println("*****************VIEW ORDER HISTORY**************");
		WebElement print_order_history= driver.findElement(By.xpath("//app-order-history/mat-card/div/div/div[1]/div/div/div[1]/div[1]"));
	//	System.out.println("Print OrderID :"+print_order_history.getText());
		
		LoggerLoad.info(" Print OrderID :"+print_order_history.getText()); //logging
		
		System.out.println("*****************Track Order ID**************");
		//Track Order ID
		WebElement track_icon= driver.findElement(By.xpath("//app-order-history/mat-card/div/div/div[1]/div/div/div[1]/div[5]/button"));
		track_icon.click(); 
		WebElement track_order= driver.findElement(By.xpath("//app-track-result/mat-card/div[3]"));
	//	System.out.println("Print_Track_Ordered Products :"+track_order.getText());
		LoggerLoad.info("Print_Track_Ordered Products :"+track_order.getText()); //logging
		
		//logout
		WebElement account_nav1= driver.findElement(By.xpath("//*[@id='navbarAccount']"));
		account_nav1.click();
		WebElement logout_btn= driver.findElement(By.xpath("//*[@id='navbarLogoutButton']"));
		logout_btn.click();
		
		//Driver Quit
		driver.quit();

	}	

		
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		LoginPage obj= new LoginPage();
		obj.login();
		

	}

}
