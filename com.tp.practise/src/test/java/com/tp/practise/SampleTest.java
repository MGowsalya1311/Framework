package com.tp.practise;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tp.practise.generic.BaseClass.BaseClass;

@Listeners(com.tp.practise.generic.ListenerUtility.ListenerImplementation.class)

public class SampleTest extends BaseClass{
	@Test
	private void sample1Test() {
		System.out.println("sample 1 ");
	}
	
	@Test
	private void sample2Test() {
		System.out.println("sample 2 ");
	}
	
	@Test(retryAnalyzer = com.tp.practise.generic.ListenerUtility.ListenerImplementation.class)
	private void sample3Test() {
		Assert.fail("sample 3 failed");
		System.out.println("sample 3 ");
		
		
	}
	
	

}
