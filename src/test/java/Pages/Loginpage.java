package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.Baseclass;

public class Loginpage
{
    WebDriver driver= Baseclass.driver;
    ExtentTest test =Baseclass.test;
    
    //================= web elemenets============//
	@FindBy(className = "login")
	WebElement loginlink;

    
    @FindBy(name="user_login")
    WebElement UserName;
    
    @FindBy(className="rememberMe")
    WebElement Rememberme;
    
    
    @FindBy(id="password")
    WebElement Password;
    
    @FindBy(name="btn_login")
    WebElement Loginbtn;
    
    
    
   public Loginpage()
   {
	   PageFactory.initElements(driver, this);
   }
    
    
  //================= Functions============//
    
	public void loginfunction(String name, String pwd)
	{
		//WebElement loginlink= driver.findElement(By.linkText("Log in"));
			
		//wait.until(ExpectedCondition.)
		/*WebElement UserName= driver.findElement(By.name("user_login"));
		
		
		WebElement Password= driver.findElement(By.id("password"));
		
		
		WebElement Rememberme= driver.findElement(By.className("rememberMe"));
		
		
		WebElement Loginbtn= driver.findElement(By.name("btn_login"));
		*/
		
		loginlink.click();
		test.log(LogStatus.PASS, "Click on Login Link", "Loginclick successfully");
		UserName.sendKeys(name);
		test.log(LogStatus.PASS, "Enter Username", "User nameEntered successfully");
		Password.sendKeys(pwd);
		test.log(LogStatus.PASS, "Enter password", "Password Entered successfully");
		Rememberme.click();
		Loginbtn.click();
		test.log(LogStatus.PASS, "Click on Login Button", "Login successfully");
	}
}
