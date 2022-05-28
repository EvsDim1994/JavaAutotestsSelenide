import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Hooks {
    @BeforeAll
    public void doBeforeAll() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver.exe");
    }

    @BeforeEach
    public void doBefore() {
        // Scanner str = new Scanner(System.in);
        // System.out.println("Введите название папки:" + str);
        // String fold;
        // fold = str.toString();
        Configuration.reportsFolder = "ScreenShots";

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        WebDriverRunner.setWebDriver(webDriver);
        Selenide.open("http://automationpractice.com/index.php");
        //Selenide.screenshot("ScreenShots");
    }

    @AfterEach
    public void doAfter() {

        WebDriverRunner.getWebDriver().quit();
    }
}
