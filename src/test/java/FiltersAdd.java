import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FiltersAdd extends Hooks {
    @Test
    public void test3() {
        List<SelenideElement> list1 = $$x("//div[@id='block_top_menu']/ul/li/a");
        // Клик по первому элементу списка
        list1.get(0).click();
        $x("//span[text()='Women']").shouldBe(Condition.visible);
        $x("//div[@id='subcategories']//a[@title='Dresses']").click();
        $x("//h2[contains(text(),'Dresses')]").shouldBe(Condition.visible);
        $x("//div[@id='subcategories']//a[@title='Summer Dresses']").click();
        //поиск по параметрам
        $x("//input[@value='1_1']").click();
        $x("//span[contains(text(), 'Size S')]").shouldBe(Condition.visible);
        $x("//input[@id='layered_id_attribute_group_16']").scrollIntoView(true).click();
        $x("//span[contains(text(), 'Color Yellow')]").shouldBe(Condition.visible);

        $x("//input[@value='1_5']").scrollIntoView(true).click();
        $x("//span[contains(text(), 'Compositions Polyester')]").shouldBe(Condition.visible);

        List<SelenideElement> el3 = $$x("//div[@class='product-container']");
        //el3.get(1).scrollIntoView(true).hover();
        List<SelenideElement> el4 = $$x("(//span[contains(text(),'-20%')])[2]");
        List<SelenideElement> el5 = $$x("//a[@id = 'color_34']");
        $x("(//span[contains(text(),'-20%')])[2]").shouldBe(Condition.exist);
        el3.get(1).$x(".//a[@id = 'color_34']").shouldBe(Condition.visible);
        el3.get(1).scrollIntoView(true).hover();
        String title = el3.get(1).$x(".//a[@class='product-name']").getText();
        el3.get(1).$x(".//a[@title='Add to cart']").click();
        $(".layer_cart_product").shouldBe(Condition.visible);
        $x("//span[@id='layer_cart_product_title']").shouldHave(Condition.text(title));

    }
}
