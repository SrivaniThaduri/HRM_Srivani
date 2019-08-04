package com.Webpages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.CommonMethods.BaseClass;

public class MyLeavepage extends WebPageObjects
{
  @FindBy(id="calFromDate")public static  WebElement fromdateinmyleave;
  @FindBy(id="calToDate")public static  WebElement todateinmyleave;
  @FindBy(id="leaveList_chkSearchFilter_1")public static WebElement pendingApprovalCheckbox;
  @FindBy(id="menu_leave_viewMyLeaveList")public static WebElement MyleaveTab;
  @FindBy(id="btnSearch")public static WebElement search;
  @FindBy(linkText="All")public static WebElement checkboxes;
   public static void MyleaveSearch() throws IOException, InterruptedException
  {
	 // WebPageObjects.leavemodule.click();
	  MyleaveTab.click();
	  fromdateinmyleave.clear();
	  String date=BaseClass.ReadDatafromExcel("Sheet1", 6, 1);
	  fromdateinmyleave.sendKeys(date);
	  todateinmyleave.clear();
	  todateinmyleave.sendKeys(date);
	  checkboxes.click();
	  Thread.sleep(2000);
	  pendingApprovalCheckbox.click();
	  search.click();
	  
	  
  }
  
}
