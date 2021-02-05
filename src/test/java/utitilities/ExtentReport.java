package utitilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	private static ExtentReports reports;
	public static ExtentTest test;
	private static ExtentHtmlReporter htmlReporter;
	private static Properties report = new Properties();

	public static void createReport(String folder) {
		try {
			;
			InputStream input = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\java\\utitilities\\extent.properties");
			report.load(input);
		} catch (Exception e) {
			System.out.println("Failed to read property");
		}

		folder = System.getProperty("user.dir") + "\\" + report.getProperty("report") + "\\" + folder + "\\";
		File newfile = new File(folder);
		newfile.mkdir();
		File images=new File(folder+"images");
		images.mkdir();
		folder += report.getProperty("name");
	
		
		htmlReporter = new ExtentHtmlReporter(folder);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("QA Automation");
		htmlReporter.config().setReportName("Way2Automation");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
	}

	public static ExtentTest createTest(String testName) {
		test = reports.createTest(testName);
		return test;
	}

	public static void closeReport() {
		if (reports != null) {
			reports.flush();
		}
	}

}
