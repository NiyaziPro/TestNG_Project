package techproed.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart  ==> Tum teslerden once bir kez cagirilir! " + context.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish ==> Tum teslerden sonra bir kez cagirilir! " + context.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart  ==> Tum test method'larindan once bir kez cagirilir! " + result.getName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess  ==> sadece PASS olan teslerden sonra  bir kez cagirilir! " + result.getName());

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure  ==> sadece FAIL olan teslerden sonra bir kez  cagirilir! " + result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped  ==> testlerin arasinda calismayan,atlanan testler varsa  bir kez  cagirilir! " + result.getName());

    }



}
