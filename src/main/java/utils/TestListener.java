package utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("❌ FAILED: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("✅ PASSED: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("🚀 Starting suite: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("🏁 Finished suite: " + context.getName());
    }
}
