import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import java.io.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class readinformation extends Hooks{
    @Test
    public void test5() {
        $x("//input[@name='search_query']").sendKeys("dress");
        $x("//button[@name='submit_search']").click();
        $x("//a[@title='Delivery']").shouldBe(Condition.visible).click();

        try(FileWriter writer = new FileWriter("Delevery.txt", true)) {
            String deleveryinf = $x("//div[@id='center_column']").getText();
            writer.write(deleveryinf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
