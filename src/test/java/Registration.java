import com.codeborne.selenide.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class Registration extends Hooks {
    @Test
    @Tag("Registration")
    public void test6() {
        $x("//a[@title='Log in to your customer account']").click();
        List<SelenideElement> input = $$x("//input[@type='text']");
        int length = 4;
        String email = "mail"+RandomStringUtils.randomNumeric(length) + "@gmail.com";
        input.get(1).sendKeys(email);
        try(FileWriter writer = new FileWriter("Login.txt", true)) {
            writer.write(email);
        } catch (IOException e) {
            e.printStackTrace();
        }
        $x("//button[@id = 'SubmitCreate']").click();
        $x("//h1[contains(text(),'Create an account') ]").shouldBe(Condition.visible);
        //ввод данных
        $x("//input[@id='id_gender1']").click();
        $x("//input[@id='customer_firstname']").sendKeys("Виктор");
        $x("//input[@id='customer_lastname']").sendKeys("Пупкин");
        String inemail = $x("//input[@id='email']").getAttribute("value");
        // пароль
        int length2 = 5;

        String password = RandomStringUtils.randomNumeric(length2);
        try(FileWriter writer2 = new FileWriter("Password.txt", true)) {
            writer2.write(password);
        } catch (IOException e) {
            e.printStackTrace();
        }
        $x("//input[@id='passwd']").sendKeys(password);
        //дата рождения
        $x("//select[@id = 'days']").click();
        List<SelenideElement> date = $$x("//option[@value= '1']");
        date.get(0).click();
        //месяц рождения
        $x("//select[@id = 'months']").click();
        List<SelenideElement> month = $$x("//option[@value= '1']");
        date.get(1).click();
        //год
        $x("//select[@id = 'years']").click();
        $x("//option[@value= '2017']").click();

        $x("//span[contains(text(),'Register')]").click();


        if ($x("//p[contains(text(),'There are 5 errors')]").exists()==true){
            $x("//input[@name='address1' ]").sendKeys("улица Пушкина, 18");
            $x("//input[@name='city' ]").sendKeys("Волгоград");
            $x("//input[@name='postcode' ]").sendKeys("00000");
            $x("//select[@name='id_country' ]").click();
            $x("//option[contains(text(),'United States') ]").click();
            int length3 = 7;
            String nomber = RandomStringUtils.randomNumeric(length3);
            $x("//input[@name='phone_mobile' ]").sendKeys("+7988" + nomber );
            $x("//span[contains(text(),'Register')]").click();
            $x("//input[@id='passwd']").sendKeys(password);
            $x("//select[@id='id_state']").click();
            $x("//option[contains(text(),'Alaska')]").click();
            $x("//span[contains(text(),'Register')]").click();
            $x("//h1[contains(text(),'My account')]").shouldBe(Condition.visible);
            System.out.println($x("//p[@class='info-account']").getText());
            System.out.println("успешная регистрация c дозаполнением");

        }
        else {
            System.out.println("успешная регистрация без дозаполнения");
        }



        }

        @Test
        @Tag("Registration")
        public void test7() {
             $x("//a[contains(text(),'Sign in')]").click();
             $x("//h1[contains(text(),'Authentication')]").shouldBe(Condition.visible);

            try (BufferedReader reader = Files.newBufferedReader(Paths.get("Login.txt"))) {
                String login = reader.readLine();
                $x("//input[@id='email']").sendKeys(login);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try (BufferedReader reader = Files.newBufferedReader(Paths.get("Password.txt"))) {
                String pass = reader.readLine();
                $x("//input[@id='passwd']").sendKeys(pass);
            } catch (IOException e) {
                e.printStackTrace();
            }
            $x("//button[@id='SubmitLogin']").click();
            $x("//h1[contains(text(),'My account')]").shouldBe(Condition.visible);

    }
}



