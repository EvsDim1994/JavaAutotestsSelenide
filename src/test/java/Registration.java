import com.codeborne.selenide.*;
import com.codeborne.selenide.commands.ToString;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Scanner;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Registration extends Hooks {
    private static String em;

    public static void main(String[] args) {
        Scanner email = new Scanner(System.in);
        em = email.nextLine();
    }

    @Test
    public void test6() {
        $x("//a[@title='Log in to your customer account']").click();
        List<SelenideElement> input = $$x("//input[@type='text']");
        String youremail = em;


        input.get(1).sendKeys(em);
    }
}



