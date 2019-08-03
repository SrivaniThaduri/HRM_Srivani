package com.CommonMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass 
{
	public static WebDriver driver;
	public static ExtentReports reports;
	public static ExtentTest logger;
	public static ITestResult result;
	public static void LoginMethod(String browser)
	{
	if(browser=="Chrome")
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Naveen Reddy\\eclipse-workspace\\HRM\\BrowserDrivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.testingmasters.com/hrm/symfony/web/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("user03");
		driver.findElement(By.id("txtPassword")).sendKeys("pass1234");
		driver.findElement(By.id("btnLogin")).click();
	}
	if(browser=="FireFox")
	{
		System.setProperty("webdriver.firefox.driver", "/HRM/BrowserDrivers/geckodriver.exe");
		 driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.testingmasters.com/hrm/symfony/web/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("user03");
		driver.findElement(By.id("txtPassword")).sendKeys("pass1234");
		driver.findElement(By.id("btnLogin")).click();
	}
	if(browser=="InternetExplorer")
	{
		System.setProperty("webdriver.InternetExplorer.driver", "/HRM/BrowserDrivers/IEDriverServer.exe");
		 driver=new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://www.testingmasters.com/hrm/symfony/web/index.php/auth/login");
		driver.findElement(By.id("txtUsername")).sendKeys("user03");
		driver.findElement(By.id("txtPassword")).sendKeys("pass1234");
		driver.findElement(By.id("btnLogin")).click();
		}
	}
	public static String takesnapshots() throws IOException
	{
		String snapshotname="C:\\Users\\Naveen Reddy\\eclipse-workspace\\HRM\\ScreensImages\\HRM_"+getSystemDate()+".png";
		TakesScreenshot ts=(TakesScreenshot)driver;
		File fsource=ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(fsource, new File(snapshotname));
		return snapshotname;
	}
	public static String ReadDatafromExcel(String Sheetname, int rownum, int colno) throws IOException
	{
		File file=new File("C:\\Users\\Naveen Reddy\\eclipse-workspace\\HRM\\TestData\\WebTestdata.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook xssfw=new XSSFWorkbook(fis);
		XSSFSheet xssfs=xssfw.getSheet("Sheet1");
		String CellValue=xssfs.getRow(rownum).getCell(colno).getStringCellValue();
		return CellValue;
		
		
	}
	public static String getSystemDate()
	{
		DateFormat df=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date=new Date();
		String formateddate=df.format(date);
		return formateddate ;
		
	}
	@BeforeSuite
	public static void createReportName()
	{
		ExtentHtmlReporter reporter= new ExtentHtmlReporter("C:\\Users\\Naveen Reddy\\eclipse-workspace\\HRM\\Reports\\"+getSystemDate()+".html");
		reports= new ExtentReports();
		reports.attachReporter(reporter);
	}
	@AfterMethod
	public void attachScreenShottoReport() throws IOException
	{
		Reporter.log("Report Process Started");
		if(result.getStatus()==ITestResult.SUCCESS) 
		{
			logger.pass("Sucess", MediaEntityBuilder.createScreenCaptureFromPath(takesnapshots()).build());
			Reporter.log("Add Sucess Snap shot");
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			logger.fail("Failure", MediaEntityBuilder.createScreenCaptureFromPath(takesnapshots()).build());
			Reporter.log("Add failure Snap shot");

		}
		else
		{
			System.out.println("U r Wrong");
		}
		reports.flush();
		Reporter.log("Report Genereated Please Check", true);
	}

}

