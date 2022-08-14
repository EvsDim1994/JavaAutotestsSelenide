import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;



public class Hooks {

    @BeforeEach
    public void tearDown() {
        Configuration.reportsFolder = "ScreenShots";
        Configuration.timeout = 20000;
        Selenide.open("http://automationpractice.com/index.php");
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }

  @AfterEach
    public void doAfter() {
        WebDriverRunner.getWebDriver().quit();
    }
}
