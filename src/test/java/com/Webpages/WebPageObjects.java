package com.Webpages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.CommonMethods.BaseClass;

public class WebPageObjects {
	@FindBy(id="menu_leave_viewLeaveModule")public static WebElement leavemodule;
	@FindBy(id="menu_leave_applyLeave")public static WebElement applyleave;
	@FindBy(id="applyleave_txtLeaveType")public static WebElement leavetype;
	@FindBy(xpath="//option[@value='1']")public static WebElement selectanualtype;
	@FindBy(id="applyleave_txtFromDate")public static WebElement fromDate;
	@FindBy(id="applyleave_txtToDate")public static WebElement toDate;
	@FindBy(id="applyleave_txtComment")public static WebElement commenttext;
	@FindBy(id="applyBtn")public static WebElement apply;

	public static void ReadPageData() throws IOException
	{
		leavemodule.click();
		applyleave.click();
		leavetype.click();
		selectanualtype.click();
		fromDate.clear();
		String FromDate=BaseClass.ReadDatafromExcel("Sheet1",6,1);
		System.out.println("printing cell value" +FromDate);
		fromDate.sendKeys(FromDate);
		toDate.clear();
		toDate.sendKeys(FromDate);
	    String comment=BaseClass.ReadDatafromExcel("Sheet1",5,1);
		commenttext.sendKeys(comment);
		apply.click();
	}
	

}
