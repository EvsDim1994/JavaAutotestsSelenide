import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

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
        try {
            Thread.sleep(10000);
            $x("//span[contains(text(), 'Size S')]").shouldBe(Condition.visible);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        $x("//input[@id='layered_id_attribute_group_16']").scrollIntoView(true).click();
        try {
            Thread.sleep(10000);
            $x("//span[contains(text(), 'Color Yellow')]").shouldBe(Condition.visible);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        $x("//input[@value='1_5']").scrollIntoView(true).click();
        try {
            Thread.sleep(15000);
            $x("//span[contains(text(), 'Compositions Polyester')]").shouldBe(Condition.visible);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<SelenideElement> el3 = $$x("//div[@class='product-container']");
        //el3.get(1).scrollIntoView(true).hover();
        List<SelenideElement> el4 = $$x("//span[contains(text(),'-20%')]");
        SelenideElement el5 = $x("//a[@id = 'color_34']");

       if(el4.get(2).exists()==true){
           if (el5.exists()== true) {
               el3.get(1).scrollIntoView(true).hover();
               el3.get(1).$x(".//a[@title='Add to cart']").click();
               System.out.println("Добавлен товар с жёлтым цветом и скидкой 20%");
           }
       } else {
          System.out.println("Товар не добавлен");
       }

    }
}
