import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hooks {

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/79884/JavaAutotestsSelenide2/chromedriver.exe");
    }

    @BeforeEach
    public void tearDown() {
        Configuration.reportsFolder = "ScreenShots";
        Configuration.timeout = 20000;
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        WebDriverRunner.setWebDriver(webDriver);
        Selenide.open("http://automationpractice.com/index.php");
    }

  @AfterEach
    public void doAfter() {
        WebDriverRunner.getWebDriver().quit();
    }
}
