package testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Baseclass
{
	XSSFWorkbook wbook;
	XSSFSheet sheet;
	
	public static ExtentReports report;
	public static ExtentTest test;
	

	@BeforeTest
	public void datasetup() throws IOException
	{

		FileInputStream fis = new FileInputStream("Exceldata.xlsx");
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet("Sheet1");	
		report= new ExtentReports("Extentreports.html");
	}

	@AfterTest
	public void DataTearDown() throws IOException {

		wbook.close();
		report.flush();
		report.close();
	}


	public static WebDriver driver;
	@BeforeMethod
	public void setup(Method methodname)
	{
		test=report.startTest(methodname.getName());

		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");

		driver= new ChromeDriver();
		//WebDriver driver= new FirefoxDriver();
		driver.get("https://www.simplilearn.com");

		WebDriverWait wait =new WebDriverWait(driver,50);


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

	}

	@AfterMethod
	public void teardown()
	{
		
		
		driver.quit();
		report.endTest(test);
	
	}


}
