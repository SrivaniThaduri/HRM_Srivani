package com.TestRunner;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;

import com.CommonMethods.BaseClass;
import com.TestCases.TestCases;

public class LaunchApplication extends BaseClass {
	@Test	
		public static void exexutemethod() throws IOException, InterruptedException
		{
		logger=reports.createTest("Login Page");
		BaseClass.LoginMethod("Chrome");
		logger.info("Login with valid Cred");
		logger=reports.createTest("TC_01");
		TestCases.TC01();
		logger.info("Apply Leave");
		logger=reports.createTest("TC_02");
		TestCases.TC02();
		logger.info("MyLeave data");
		}

	

}
