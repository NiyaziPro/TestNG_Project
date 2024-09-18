package techproed.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReport {

    static ExtentReports extentReports;
    static ExtentHtmlReporter extentHtmlReporter;
    static ExtentTest extentTest;

    public static ExtentReports getExtentReports() {
        return extentReports;
    }

    public static ExtentHtmlReporter getExtentHtmlReporter() {
        return extentHtmlReporter;
    }

    public static ExtentTest getExtentTest() {
        return extentTest;
    }


    public static void createExtentReport(String testName, String testerName) {

        //Bu objeyi raporları oluşturmak ve başlatmak için kullanacağız
        extentReports = new ExtentReports();
        String date = DateTimeFormatter.ofPattern("dd.MM.yyyy_HH.mm.ss").format(LocalDateTime.now());
        String path = "target\\extentReport\\htmlReport_" + date + ".html";

        //html raporu oluşturmak için kullanacağız
        extentHtmlReporter = new ExtentHtmlReporter(path);

        // extentReports ile extentHtmlReporter'ı birbirlerine ekledik. Bu raporun html formatında oluşturulmasını sağlar.
        extentReports.attachReporter(extentHtmlReporter);

        //HTML raporunun Title'ını ayarlar, browser sekmesinde görünür
        extentHtmlReporter.config().setDocumentTitle("Test Report");

        //Raporun adını ayarlar, genel bir başlık sunar
        extentHtmlReporter.config().setReportName("My Extent Report");

        //HTML raporunda görmek isteyebileceğimiz bilgileri "key, value" şeklinde yazabiliriz
        extentReports.setSystemInfo("Environment", "QA");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Test Automation Engineer", testerName);

        extentTest = extentReports.createTest(testName, "Test Steps");
    }
}
