package juiceShop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Juice_shop {

	public static WebDriver driver;
	String URL ="https://juice-shop.herokuapp.com/#/register";
	
	@FindBy (xpath="//*[@id='mat-dialog-0']/app-welcome-banner/div/div[2]/button[2]")WebElement dismiss_btn;
	@FindBy (xpath ="/html/body/div[1]/div")WebElement mewantit_btn;
	
	//User Registration
	@FindBy (id="emailControl")WebElement email;
	@FindBy (id="passwordControl")WebElement pwd;
	@FindBy (id="repeatPasswordControl")WebElement repeat_pwd;
	@FindBy (xpath="//span[@class='mat-slide-toggle-thumb']")WebElement show_pwd_advice;
	@FindBy (xpath="//div[@class='mat-form-field-flex ng-tns-c21-10']")WebElement security_question_textbox;
	@FindBy (xpath="//*[@id='mat-option-0']/span")WebElement security_question;
	@FindBy (id="securityAnswerControl")WebElement security_answer;
	@FindBy (xpath="//*[@id='registerButton']")WebElement registerButton;
	
	
	
	public void register() throws InterruptedException {
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(URL);
		
		PageFactory.initElements(driver,this);
		
		dismiss_btn.click();
		mewantit_btn.click();
		email.sendKeys("astapalanivel@gmail.com");
		pwd.sendKeys("Asta_1234");
		repeat_pwd.sendKeys("Asta_123");
		show_pwd_advice.click();
		if(show_pwd_advice.isSelected()) {
			WebElement content=driver.findElement(By.className("mat-card-content"));
			String color=content.getCssValue("color");
			System.out.println("color of the content :"+color+ "is all correct");
			}
		else {
			WebElement content=driver.findElement(By.className("mat-card-content"));
			String color=content.getCssValue("color");
			System.out.println("color of the content :"+color+ "is all correct");
		}
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", security_question_textbox);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", security_question_textbox);
		security_question.click();
		security_answer.sendKeys("Amulraj");
		Thread.sleep(5000);
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(registerButton));
		boolean reg =registerButton.isDisplayed();
		if(reg==true) {
		registerButton.click();
		}

		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		Juice_shop js_obj=new Juice_shop();
		js_obj.register();
	}
	
//	WebElement email_login=driver.findElement(By.id("email"));
//	email_login.sendKeys("asta123654@gmail.com");
//	WebElement pwd_login=driver.findElement(By.id("password"));
//	pwd_login.sendKeys("Asta_123");
//	WebElement submit_login=driver.findElement(By.id("loginButton"));
//	submit_login.click();	

}
