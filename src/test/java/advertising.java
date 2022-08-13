import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import java.util.List;


import static com.codeborne.selenide.Selenide.*;
// Переключение рекламы
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class advertising extends Hooks {
    @Test
    public void test8() {

         List<SelenideElement> el1 = $$x("//a[@title='sample-1']");
         el1.get(0).shouldBe(Condition.visible);
         $x("//a[contains(text(), 'Next')]").click();
         $x("//a[@title='sample-2']").shouldBe(Condition.visible);
        try {
            Thread.sleep(2000);
            $x("//a[contains(text(), 'Next')]").click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<SelenideElement> el3 = $$x("//a[@title='sample-3']");
        el3.get(1).shouldBe(Condition.visible);
        try {
            Thread.sleep(2000);
            $x("//a[contains(text(), 'Next')]").click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }
}


