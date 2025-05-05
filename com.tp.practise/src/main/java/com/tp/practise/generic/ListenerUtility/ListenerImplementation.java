package com.tp.practise.generic.ListenerUtility;

import java.util.Date;

import org.testng.IRetryAnalyzer;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerImplementation implements ITestListener,ISuiteListener,IRetryAnalyzer{

	
	int count=0, retryLimit=2;
	
	public void onStart(ISuite suite) {
		System.out.println("onStart: "+suite.getName());	
	}

	public void onFinish(ISuite suite) {
		System.out.println("onFinish: "+suite.getName());	

	}

	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart: "+result.getMethod().getMethodName());	

	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess: "+result.getMethod().getMethodName());	

	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		System.out.println(testName+"\t"+time);
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped: "+result.getMethod().getMethodName());	

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage: "+result.getMethod().getMethodName());	

	}

	public void onStart(ITestContext context) {
		System.out.println("onStart: "+context.getName());	

	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish: "+context.getName());	

	}

	//retry listener methods
	public boolean retry(ITestResult result) {
		System.out.println("retry: "+result.getMethod().getMethodName());	
			if(count<retryLimit) {
				count++;
				return true;
			}
		return false;
		
	}

}
