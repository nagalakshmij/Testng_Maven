package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Loginpage;

public class LoginTest extends Baseclass
{


	@Test
	public void Loginfailuretest()
	{
		//test=report.startTest("Loginfailuretest");
		Loginpage obj= new Loginpage();
		obj.loginfunction("naglakshmij@gmail.com","Honeywell@123ds");



		WebElement Errormessage= driver.findElement(By.id("msg_box"));
		String actualmessage= Errormessage.getText();
		String expectedmsg="The email or password you have entered is invalid.";

		Assert.assertEquals(actualmessage,expectedmsg);
		/*if(actualmessage.equals(expectedmsg))
		{
			System.out.println("Testcase passed");
		}
		else
		{
			System.out.println("Testcase failed");

		}*/
		//report.endTest(test);

	}

	@Test(enabled= true)
	public void LoginSuccesstest()
	{

		Loginpage obj= new Loginpage();
		obj.loginfunction("naglakshmij@gmail.com","Honeywell@123");



		/*WebElement Errormessage= driver.findElement(By.id("msg_box"));
	    String actualmessage= Errormessage.getText();
		String expectedmsg="The email or password you have entered is invalid.";

		Assert.assertEquals(actualmessage,expectedmsg);
		/*if(actualmessage.equals(expectedmsg))
		{
			System.out.println("Testcase passed");
		}
		else
		{
			System.out.println("Testcase failed");

		}*/

	}

	@Test
	@Parameters({"Param1","Param2"})
	public void ParameterizedTest(String username, String Password)
	{
		Loginpage obj= new Loginpage();
		obj.loginfunction(username,Password);

	}

	@Test(enabled=false)
	public void ExternalDatatest()
	{
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();

		Loginpage login = new Loginpage();
		login.loginfunction(UserNameVal,PasswordVal);		
	}

}

