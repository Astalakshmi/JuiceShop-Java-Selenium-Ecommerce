package juiceShop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class RegisterPage {
	
	@Test
	public void register() throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://juice-shop.herokuapp.com/#/register");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	driver.manage().window().maximize();
	
	WebElement dismiss_btn=driver.findElement(By.xpath("//*[@id='mat-dialog-0']/app-welcome-banner/div/div[2]/button[2]"));
	dismiss_btn.click();
	WebElement mewantit_btn=driver.findElement(By.xpath("/html/body/div[1]/div"));
	mewantit_btn.click();

	//User Registration
	WebElement email=driver.findElement(By.id("emailControl"));
	email.sendKeys("astapalanivel@gmail.com");
	WebElement pwd=driver.findElement(By.id("passwordControl"));
	pwd.sendKeys("Asta_1234");
	WebElement repeat_pwd=driver.findElement(By.id("repeatPasswordControl"));
	repeat_pwd.sendKeys("Asta_1234");
	WebElement show_pwd_advice=driver.findElement(By.xpath("//span[@class='mat-slide-toggle-thumb']"));
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

	WebElement security_question_textbox=driver.findElement(By.xpath("//div[@class='mat-form-field-flex ng-tns-c21-10']"));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", security_question_textbox);
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", security_question_textbox);

	WebElement security_question=driver.findElement(By.xpath("//*[@id='mat-option-0']/span"));
	security_question.click();
	WebElement security_answer=driver.findElement(By.id("securityAnswerControl"));
	security_answer.sendKeys("Amulraj");
	
	Thread.sleep(5000);
	WebElement registerButton = new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='registerButton']")));
	boolean reg =registerButton.isDisplayed();
	if(reg==true) {
	registerButton.click();
	}
	//Login Form

	WebElement email_login=driver.findElement(By.id("email"));
	email_login.sendKeys("astapalanivel@gmail.com");
	WebElement pwd_login=driver.findElement(By.id("password"));
	pwd_login.sendKeys("Asta_1234");
	WebElement submit_login=driver.findElement(By.id("loginButton"));
	submit_login.click();	
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		RegisterPage obj= new RegisterPage();
		obj.register();
	
	}

}
