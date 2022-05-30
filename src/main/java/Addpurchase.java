import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

/*Добавление женского топик2*/

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Addpurchase {
    @BeforeAll
    public void doBeforeAll() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver.exe");
    }

    @BeforeEach
    public void doBefore() {
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

    @Test
    public void test1(){
        List<SelenideElement> list = $$x("//div[@id='block_top_menu']/ul/li/a");
        // Клик по первому элементу списка
        list.get(0).click();
        $x("//span[text()='Women']").shouldBe(Condition.visible);
        $x("//div[@id='subcategories']//a[@title='Tops']").click();
        $x("//h2[contains(text(),'Tops')]").shouldBe(Condition.visible);
        List<SelenideElement> listProducts = $$x("//div[@class='product-container']");
        listProducts.get(0).hover();
        // Ищем внутренний элемент кнопку добавить в корнзину на первом элементе списка.
        listProducts.get(0).$x(".//a[@title='Add to cart']").click();
        $x("//div[@id='layer_cart']").shouldBe(Condition.visible);

    }
}

