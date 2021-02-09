package utitilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {
	public static ExtentReports reports;
	private static ExtentHtmlReporter htmlReporter;
	private static Properties report = new Properties();

	
	
	
	public static String baseDirectory;


	public static void createReport(String folder) {
		String file;
		try {
			InputStream input = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\java\\utitilities\\extent.properties");
			report.load(input);
		} catch (Exception e) {
			System.out.println("Failed to read property");
		}

		baseDirectory = System.getProperty("user.dir") + "\\" + report.getProperty("report") + "\\" + folder + "\\";
		File newfile = new File(baseDirectory);
		newfile.mkdir();
		//String images=folder+"images";
		//File image=new File(images);
		//image.mkdir();
		file =baseDirectory+ report.getProperty("name");
	
		
		htmlReporter = new ExtentHtmlReporter(file);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Gmail Automation");
		htmlReporter.config().setReportName("Test Automation");
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
	}

	public static ExtentTest createTest(String testName) {
	return reports.createTest(testName);
	}

	public static void closeReport() {
		if (reports != null) {
			reports.flush();
		}
	}

}
