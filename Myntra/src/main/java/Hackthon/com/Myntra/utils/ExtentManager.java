package Hackthon.com.Myntra.utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		if(extent ==  null) {
			
			ExtentSparkReporter spark = new ExtentSparkReporter("target/ExtentSparkReport.html");
			spark.config().setReportName("Ecommerce automation");
			spark.config().setDocumentTitle("Test Execution Report");
			
			extent = new ExtentReports();
			extent.attachReporter(spark);
		}
		return extent;
	}
}