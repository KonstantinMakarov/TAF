package com.kanstantsin.taf.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomTestListener implements ITestListener {

    private static final Logger LOG = LoggerFactory.getLogger(CustomTestListener.class);

    public void onTestStart(ITestResult result) {
        LOG.info("--------> Test started running:"  + result.getMethod().getTestClass().getName() +
                                                    ", at:" + result.getTestContext().getStartDate() + " <--------");
    }

    public void onTestSuccess(ITestResult result) {
        LOG.info("--------> Test PASSED successfully <--------");
    }

    public void onTestFailure(ITestResult result) {
        LOG.info("--------> Test FAILED successfully <--------");
    }

    public void onTestSkipped(ITestResult result) {
        LOG.info("--------> Test SKIPPED successfully <--------");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // don't need to implement this case
    }

    public void onStart(ITestContext context) {
        LOG.info("-------------------------> Global START at:" + context.getStartDate() + " <-------------------------");
    }

    public void onFinish(ITestContext context) {
        LOG.info("-------------------------> Global FINISH at:" + context.getEndDate() + " <-------------------------");
    }
}
