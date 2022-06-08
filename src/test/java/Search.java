import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Search extends Hooks {
    @Test
    public void test4() {
          $x("//input[@name='search_query']").sendKeys("dress");
          $x("//button[@name='submit_search']").click();
          String resultsearch =  $x("//span[@class='heading-counter']").shouldBe(Condition.visible).getText();
          if (resultsearch.contains("7 results have been found")){
              System.out.println(resultsearch);
          }
          else {
              System.out.println("Найдено другое количество товара");
          }
          $x("//span[contains(text(),'dress')]").shouldBe(Condition.visible);
          $x("//div[@id='uniform-selectProductSort']").click();
          $x("//option[@value='price:desc']").click();
          String text = "Price: Highest first";
          $x("//option[@selected='selected']").shouldHave(Condition.text(text));

    }
}
