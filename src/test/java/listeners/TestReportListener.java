package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TestReportListener implements ITestListener {
    private static final Path REPORT_PATH = Path.of("test-output", "custom-report.txt");

    @Override
    public void onStart(ITestContext context) {
        try {
            Files.createDirectories(REPORT_PATH.getParent());
            Files.writeString(
                    REPORT_PATH,
                    "Test execution report\n",
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e) {
            throw new RuntimeException("Unable to initialize test report", e);
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        appendResult("PASS", result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        appendResult("FAIL", result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        appendResult("SKIP", result);
    }

    private void appendResult(String status, ITestResult result) {
        String message = String.format(
                "%s - %s.%s%n",
                status,
                result.getTestClass().getRealClass().getSimpleName(),
                result.getMethod().getMethodName()
        );
        Reporter.log(message, true);
        try {
            Files.writeString(
                    REPORT_PATH,
                    message,
                    StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            throw new RuntimeException("Unable to update test report", e);
        }
    }
}
