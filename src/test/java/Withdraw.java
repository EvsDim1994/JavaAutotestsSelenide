import org.junit.jupiter.api.TestInstance;
import com.codeborne.selenide.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Withdraw extends Hooks {
    @Test
    public void test10(){
          if ($x("//span[contains(text(),'(empty)')]").exists()==true) {
              List<SelenideElement> prcontainer = $$x("//div[@class='product-container']");
              prcontainer.get(1).shouldBe(Condition.visible).hover();
              prcontainer.get(1).$x(".//a[@title='Add to cart']").shouldBe(Condition.visible).click();
              $x("//span[contains(text(),'There is 1 item in your cart.')]").shouldBe(Condition.visible);
              $x("//span[@title='Close window']").click();
              $x("//a[@title='View my shopping cart']").click();
              $x("//a[@title='View my shopping cart']").hover();
              $x("//a[@title='remove this product from my cart']").shouldBe(Condition.visible).click();
              $x("//span[contains(text(),'(empty)')]").shouldBe(Condition.visible);
          }
    }
}
