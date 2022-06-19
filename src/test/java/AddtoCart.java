import com.codeborne.selenide.*;
import com.codeborne.selenide.commands.ToString;
import com.google.errorprone.annotations.Var;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AddtoCart extends Hooks {
    @Test
    public void test9() {
          if($x("//span[contains(text(),'(empty)')]").exists()==true){
              List<SelenideElement> listProducts = $$x("//div[@class='product-container']");
              listProducts.get(0).hover();
              listProducts.get(0).$x(".//a[@title='Add to cart']").click();
              $x("//span[@title='Close window']").scrollIntoView(true).click();
              $x("//a[@title='View my shopping cart']").hover();
              $x("//span[contains(text(),'Check out')]").click();
              $x("//h1[contains(text(),'Shopping-cart summary')]").shouldBe(Condition.visible);
              //+1 товар
              $x("//a[@title='Add']").click();
              // проверка количества
            if($x("//input[@size='2']").exists()==true) {
                List<SelenideElement> proceed = $$x("//span[contains(text(),'Proceed to checkout')]");
                proceed.get(1).click();
                // Регистрация и продолжение оформления
                $x("//a[@title='Log in to your customer account']").click();
                List<SelenideElement> input = $$x("//input[@type='text']");
                int length = 4;
                String email = "mail"+ RandomStringUtils.randomNumeric(length) + "@gmail.com";
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

                }
                else {
                    System.out.println("успешная регистрация без дозаполнения");
                }
                $x("//a[@title='View my shopping cart']").hover();
                $x("//span[contains(text(),'Check out')]").click();
                $x("//h1[contains(text(),'Shopping-cart summary')]").shouldBe(Condition.visible);
                List<SelenideElement> proceed2 = $$x("//span[contains(text(),'Proceed to checkout')]");
                proceed2.get(1).click();
                $x("//h1[contains(text(),'Addresses')]").shouldBe(Condition.visible);
                //Оформление доставки
                if($x("//span[@class='checked']").exists()==true){
                    List<SelenideElement> proceed3 = $$x("//span[contains(text(),'Proceed to checkout')]");
                    proceed3.get(1).click();
                    $x("//input[@type='radio']").shouldBe(Condition.exist);
                    $x("//input[@type='checkbox']").click();
                    List<SelenideElement> proceed4 = $$x("//span[contains(text(),'Proceed to checkout')]");
                    proceed4.get(1).click();
                    //Выбор оплаты
                    $x("//a[@title='Pay by bank wire']").click();
                    if ($x("//h3[contains(text(),'Bank-wire payment.')]").exists()==true){
                        $x("//span[contains(text(),'I confirm my order')]").click();
                        $x("//strong[contains(text(),'Your order on My Store is complete.')]").should(Condition.visible).scrollIntoView(true);
                        System.out.println("Покупка завершена");
                    }
                }
            }
            else {
                System.out.println("Меньше 2 товаров, покупку не продолжать");
            }
          }

        }
    }