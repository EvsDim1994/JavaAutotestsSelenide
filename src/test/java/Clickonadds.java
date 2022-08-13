import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Clickonadds extends Hooks {
    @Test
    public void test7(){
        String url = "https://www.prestashop.com/en";
        $x("//img[@src='http://automationpractice.com/modules/themeconfigurator/img/banner-img1.jpg']").shouldBe(Condition.visible).click();
        String cururl1 = getWebDriver().getCurrentUrl();
        Assertions.assertEquals(url, cururl1);
        Selenide.back();
        String width1 = $x("//img[@src='http://automationpractice.com/modules/themeconfigurator/img/banner-img1.jpg']").getAttribute("width");
        String height1 = $x("//img[@src='http://automationpractice.com/modules/themeconfigurator/img/banner-img1.jpg']").getAttribute("height");
        System.out.println("Размер первой картинки " + width1 + "x" + height1);

        $x("//img[@src='http://automationpractice.com/modules/themeconfigurator/img/banner-img2.jpg']").shouldBe(Condition.visible).click();
        String cururl2 = getWebDriver().getCurrentUrl();
        Assertions.assertEquals(url, cururl2);
        Selenide.back();
        String width2 = $x("//img[@src='http://automationpractice.com/modules/themeconfigurator/img/banner-img1.jpg']").getAttribute("width");
        String height2 = $x("//img[@src='http://automationpractice.com/modules/themeconfigurator/img/banner-img1.jpg']").getAttribute("height");
        System.out.println("Размер первой картинки " + width2 + "x" + height2);

        $x("//img[@src='http://automationpractice.com/modules/themeconfigurator/img/banner-img3.jpg']").shouldBe(Condition.visible).click();
        String cururl3 = getWebDriver().getCurrentUrl();
        Assertions.assertEquals(url, cururl3);
        Selenide.back();
        String width3 = $x("//img[@src='http://automationpractice.com/modules/themeconfigurator/img/banner-img1.jpg']").getAttribute("width");
        String height3 = $x("//img[@src='http://automationpractice.com/modules/themeconfigurator/img/banner-img1.jpg']").getAttribute("height");
        System.out.println("Размер первой картинки " + width3 + "x" + height3);

        $x("//img[@src='http://automationpractice.com/modules/themeconfigurator/img/banner-img4.jpg']").shouldBe(Condition.visible).click();
        String cururl4 = getWebDriver().getCurrentUrl();
        Assertions.assertEquals(url, cururl4);
        Selenide.back();
        String width4 = $x("//img[@src='http://automationpractice.com/modules/themeconfigurator/img/banner-img1.jpg']").getAttribute("width");
        String height4 = $x("//img[@src='http://automationpractice.com/modules/themeconfigurator/img/banner-img1.jpg']").getAttribute("height");
        System.out.println("Размер первой картинки " + width4 + "x" + height4);

        $x("//img[@src='http://automationpractice.com/modules/themeconfigurator/img/banner-img5.jpg']").shouldBe(Condition.visible).click();
        String cururl5 = getWebDriver().getCurrentUrl();
        Assertions.assertEquals(url, cururl5);
        Selenide.back();
        String width5 = $x("//img[@src='http://automationpractice.com/modules/themeconfigurator/img/banner-img1.jpg']").getAttribute("width");
        String height5 = $x("//img[@src='http://automationpractice.com/modules/themeconfigurator/img/banner-img1.jpg']").getAttribute("height");
        System.out.println("Размер первой картинки " + width5 + "x" + height5);

    }


}
