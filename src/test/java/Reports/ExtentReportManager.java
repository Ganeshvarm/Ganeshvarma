package Reports;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
    
	public ExtentSparkReporter sparkReport;//UI of the report
	public ExtentReports extents;//Basic information
	public ExtentTest test;// test case entries
	
	public void onStart(ITestContext context)
	{
		sparkReport=new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/myextents.html");
		sparkReport.config().setDocumentTitle("Automation Report");
		sparkReport.config().setReportName("Regression Testing");
		sparkReport.config().setTheme(Theme.DARK);
		extents=new ExtentReports();
		extents.setSystemInfo("Computer Name", "Host");
		extents.setSystemInfo("Environement", "QA");
		extents.setSystemInfo("TesterName", "Ganeshvarma");
	}
	
	public void onTestSucess(ITestResult result)
	{
		test=extents.createTest(result.getName());
		test.log(Status.PASS, "Test Passed"+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extents.createTest(result.getName());
		test.log(Status.FAIL, "Test FAILED"+result.getName());
		test.log(Status.FAIL, "Reason of test FAILED"+result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extents.createTest(result.getName());
		test.log(Status.SKIP, "Test Skipped"+result.getName());
	}
	
	public void onFinish(ITestContext context)
	{
		extents.flush();
		
	}
	
	
}
