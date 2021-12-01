package Utilities.DDT;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ApiListeners implements ITestListener {
    public void onStart(ITestContext execution) {
        System.out.println("---------------------- Starting Execution ------------------");
    }

    public void onFinish(ITestContext execution) {
        System.out.println("---------------------- Ending Execution ------------------");
    }

    public void onTestStart(ITestResult test) {
        System.out.println("---------------------- Test: " + test.getName() + " Started ------------------");
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("---------------------- Test: " + test.getName() + " Passed ------------------");

    }

    public void onTestFailure(ITestResult test) {
        System.out.println("---------------------- Test " + test.getName() + " Failed ------------------");
    }
}
