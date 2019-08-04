package com.TestCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.CommonMethods.BaseClass;
import com.Webpages.MyLeavepage;
import com.Webpages.WebPageObjects;

public class TestCases extends BaseClass {
 public static WebPageObjects wp;
	public static void TC01() throws IOException 
	{
		wp=PageFactory.initElements(driver, WebPageObjects.class);
		wp.ReadPageData();

	}
	public static void TC02() throws IOException, InterruptedException
	{
		MyLeavepage leavepage=PageFactory.initElements(driver, MyLeavepage.class);
		leavepage.MyleaveSearch();
	}

}
