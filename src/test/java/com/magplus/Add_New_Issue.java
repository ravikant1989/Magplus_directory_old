package com.magplus;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Add_New_Issue extends Pajeobject {
	ChromeDriver driver;
	public static ExtentTest test;
  @Test(priority=3)
  public void Publish_Login() throws IOException {
	  try {
			System.out.println("@Test Case 3:");
			test = report.startTest("Test-03 : Publish_portal_Login", "Login into Publish portal magplus");
			driver = Driverutil.getBrowser();
			System.out.println("Login Test case running");
			driver.get(P_url);
			driver.findElement(By.id("auth_key")).sendKeys(P_user);
			driver.findElement(By.id("password")).sendKeys(P_pass);
			driver.findElement(By.className("btn")).click();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
		    jse.executeScript("window.scrollBy(0,500)", "");
		    driver.findElement(By.xpath("//a[contains(text(),'ravikanttest')]")).click();  
		    //driver.findElement(By.linkText("ravikanttest ")).click();
			test.log(LogStatus.INFO, "User logged In Sucessfully: " + url);
			report.endTest(test);
			report.flush();
	  }
	  catch (Exception e) {

			File srcfile1 = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile1, new File(
					path+"P_login.png"));
			test.log(
					LogStatus.FAIL,
					"User unable to logged In : "
							+ test.addScreenCapture(path+"P_login.png")+e.toString());
			report.endTest(test);
			report.flush();


		}
	  
	  }
  
  @Test(priority=4)
  public void Add_Issue() throws IOException {
	  try {
			System.out.println("@Test Case 4:");
			test = report.startTest("Test-04 : Add_issue", "Add New issue to Brand");
			driver = Driverutil.getBrowser();
			System.out.println("Add Issue Test case running");
		    driver.findElement(By.xpath(".//*[@id='top-buttons']/a")).click();
		    driver.findElement(By.id("issue_title")).sendKeys("testing_issue");
		    driver.findElement(By.id("issue_description")).sendKeys("testing_issue");
		    //JavascriptExecutor jse = (JavascriptExecutor) driver;
		    JavascriptExecutor jse = (JavascriptExecutor) driver;
		    jse.executeScript("window.scrollBy(0,500)", "");
		    driver.findElement(By.id("newsstand_image_select_files")).click();
		    Runtime.getRuntime().exec("Autoit\\auto.exe");
		    Thread.sleep(10000);
		    driver.findElement(By.id("issue_distribute_on_android_smartphone")).click();
		    Select se=new Select(driver.findElement(By.id("issue_entitlement_category")));
		    se.selectByVisibleText("Free");
		    jse.executeScript("window.scrollBy(0, 400)","");
		    Thread.sleep(5000);
		    driver.findElement(By.name("commit")).click();
		    driver.findElement(By.linkText("Issues")).click();
		    String str=driver.findElement(By.linkText("testing_issue")).getText();
		    if(str.equals("testing_issue"))
		    {
			test.log(LogStatus.INFO, "User Added issue Sucessfully: " + url);
			report.endTest(test);
			report.flush();
		    		}
		    else
		    {
		    	File srcfile1 = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcfile1, new File(
						path+"issue.png"));
				test.log(
						LogStatus.FAIL,
						"User unable to logged In : "
								+ test.addScreenCapture(path+"issue.png"));
				report.endTest(test);
				report.flush();
		    }
}
	  catch (Exception e) {

			File srcfile1 = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile1, new File(
					path+"search.png"));
			test.log(
					LogStatus.FAIL,
					"User unable to add the issue : "
							+ test.addScreenCapture(path+"search.png")+e.toString());
			report.endTest(test);
			report.flush();


		}
  }
  
  @Test(priority=5,enabled=false)
  public void Publish_Issue() throws IOException
  {
	  try {
			System.out.println("@Testcase 5:");
			test = report.startTest("Test-05 : Publish_issue", "Publish New issue to Brand");
			driver = Driverutil.getBrowser();
			System.out.println("Publish Test case running");
			driver.findElement(By.linkText("testing_issue")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//*[@id='issue']/div/div[3]/div[1]/ul[2]/li/a")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("android_smartphone_1280x720_key")).sendKeys("E:/automation/Magplus_directory/Mib/android_1280x720.mib");
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0, 400)","");
			Thread.sleep(5000);
			driver.findElement(By.name("commit")).click();
			Thread.sleep(15000);
			driver.findElement(By.linkText("Issues")).click();
			driver.findElement(By.linkText("testing_issue")).click();
			Thread.sleep(10000);
			driver.findElement(By.name("commit")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='modal-footer']/button[2]")).click();
			//Thread.sleep(5000);
			test.log(LogStatus.INFO, "User Added issue Sucessfully: " + url);
			report.endTest(test);
			report.flush();
			
	  
  }
	  
	  catch(Exception e)
	  {
		  File srcfile1 = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile1, new File(
					path+"publish.png"));
			test.log(
					LogStatus.FAIL,
					"User unable to publish the issue : "
							+ test.addScreenCapture(path+"publish.png")+e.toString());
			report.endTest(test);
			report.flush();
	  }
}
  @Test(priority=6,enabled=false)
  public void Editing_issue() throws IOException
  {
	  try {
			System.out.println("@Testcase 6:");
			test = report.startTest("Test-06 : Editing_issue", "Editing issue to Brand");
			driver = Driverutil.getBrowser();
			System.out.println("Edit Test case running"); 
			driver.findElement(By.linkText("Issues")).click();
			driver.findElement(By.linkText("testing_issue")).click();
			driver.findElement(By.xpath(".//*[@id='top-buttons']/a[1]/i")).click();
			driver.findElement(By.id("issue_title")).clear();
			driver.findElement(By.id("issue_title")).sendKeys("testing_issue");
			driver.findElement(By.id("issue_description")).clear();
		    driver.findElement(By.id("issue_description")).sendKeys("testing_issue");
		    driver.findElement(By.name("commit")).click();
		    String str=driver.findElement(By.xpath(".//*[@id='issue']/div/div[1]")).getText();
		    if(str.equals("Great! Your changes have been saved!"))
		    {
		    	test.log(LogStatus.INFO, "User edit issue Sucessfully: " + url);
				report.endTest(test);
				report.flush();
		    }
		    else
		    {
		    	test.log(
						LogStatus.FAIL,
						"User unable to edit the issue : ");
		    }
			
  }
	  catch(Exception e)
	  {
		  File srcfile1 = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcfile1, new File(
					path+"edit.png"));
			test.log(
					LogStatus.FAIL,
					"User unable to edit the issue : "
							+ test.addScreenCapture(path+"edit.png")+e.toString());
			report.endTest(test);
			report.flush();
	  }
}
  
  @Test(priority=7,enabled=false)
  public void Delete_issue() throws IOException
  {
	  try
	  {
		  Driverutil.getBrowser();
		  System.out.println("Test case 7");
		  System.out.println("Delete Issue testcase running");
		  test=report.startTest("Testcase 7 :Delete Issue","Delete published Issue from Brand");
		  driver.findElement(By.linkText("Issues")).click();
		  driver.findElement(By.linkText("testing_issue")).click();
		  Thread.sleep(5000);
		  driver.findElement(By.xpath(".//*[@id='top-buttons']/a[2]/i")).click();
		 Alert at=driver.switchTo().alert();
		 at.accept();
		 if(driver.findElement(By.linkText("testing_issue"))==null)
		 {
			 test.log(LogStatus.INFO, "Issue deleted sucessfuly");
		 }
		 else 
		 {
			 test.log(LogStatus.FAIL, "Issue not deleted");
		 }
				  
	  }
	  catch(Exception e)
	  {
		  
			  File srcfile1 = ((TakesScreenshot) driver)
						.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(srcfile1, new File(
						path+"delete.png"));
				test.log(
						LogStatus.FAIL,
						"User unable to edit the issue : "
								+ test.addScreenCapture(path+"delete.png")+e.toString());
				report.endTest(test);
				report.flush(); 
	  }
  }
}
