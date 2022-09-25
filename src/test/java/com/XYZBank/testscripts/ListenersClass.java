package com.XYZBank.testscripts;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;


public class ListenersClass implements ITestListener {
	
	
	public void onTestStart(ITestResult result) {
		System.out.println("The name of the testcase started is :"+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("The name of the testcase success is :"+result.getName());
		
		
		
		
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("The name of the testcase failed is :"+result.getName());	
		
	    
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("The name of the testcase Skipped is :"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		//System.out.println(context.getName()+" test case started");	
		
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("The name of the testcase finished is :"+context.getClass());
		
	}

	
	
	

}
