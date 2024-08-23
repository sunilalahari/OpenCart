
package com.qa.opencart.extent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic implements IRetryAnalyzer{
	private int count=0;
	private static int maxCount=3;
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(!result.isSuccess()) {
			if(count<maxCount) {
				count++;
				System.out.println("Executinng again..."+result.getMethod().toString());
				result.setStatus(ITestResult.FAILURE);
				return true;
			}
			else {
				result.setStatus(ITestResult.FAILURE);
			}
			
		}
		else {
			result.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}

}
