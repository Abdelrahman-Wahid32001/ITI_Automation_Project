package listeners;

import utils.helper.FilesUtils;
import utils.report.LogsUtils;
import utils.helper.ScreenShotsUtils;
import org.testng.*;

import java.io.File;

import static utils.report.AllureUtils.attachLogsToAllure;
import static utils.dataReader.PropertiesUtils.loadProperties;

public class TestNGListeners implements ITestListener, IExecutionListener, IInvokedMethodListener {
    File allure_results = new File("test-outputs/allure-results");
    File LOGS_PATH = new File("test-outputs/Logs");
    File SCREENSHOTS_PATH = new File("test-outputs/ScreenShots");

    @Override
    public void onExecutionStart() {
        LogsUtils.info(" Test Execution Start :");
        loadProperties();
        FilesUtils.deleteFiles(allure_results);

        boolean screenshotsCleaned = FilesUtils.cleanFiles(SCREENSHOTS_PATH);
        if (!screenshotsCleaned) {
            LogsUtils.warn("Screenshots folder could not be cleaned.");
        }

        boolean logsCleaned = FilesUtils.cleanFiles(LOGS_PATH);
        if (!logsCleaned) {
            LogsUtils.warn("Logs folder is probably in use and couldn't be cleaned.");
        }

    }

    @Override
    public void onExecutionFinish() {
        LogsUtils.info("Test Execution Finished");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LogsUtils.info("Test passed :", result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        LogsUtils.info("Test Skipped :", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LogsUtils.info("Test Failed :", result.getName());
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod()) {
            switch (testResult.getStatus()) {
                case ITestResult.SUCCESS -> ScreenShotsUtils.takeScreenShot("Passed" + testResult.getName());
                case ITestResult.SKIP -> ScreenShotsUtils.takeScreenShot("Skipped" + testResult.getName());
                case ITestResult.FAILURE -> ScreenShotsUtils.takeScreenShot("Failed" + testResult.getName());
            }
            attachLogsToAllure();

        }
    }


}
