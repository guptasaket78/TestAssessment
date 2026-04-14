package base;

import keywords.RegisterKeyword;
import listeners.TestReportListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.MonsterPage;
import pages.RegisterPage;

@Listeners(TestReportListener.class)
public class BaseUiTest {
    protected WebDriver driver;
    protected RegisterPage registerPage;
    protected MonsterPage monsterPage;
    protected RegisterKeyword registerKeyword;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        registerPage = new RegisterPage(driver);
        monsterPage = new MonsterPage(driver);
        registerKeyword = new RegisterKeyword(registerPage);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
