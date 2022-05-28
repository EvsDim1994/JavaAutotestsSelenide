
import com.codeborne.selenide.*;
import com.codeborne.selenide.commands.Find;
import com.codeborne.selenide.commands.FindByXpath;
import com.codeborne.selenide.files.FileFilter;
import com.codeborne.selenide.selector.ByText;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.lang.model.element.PackageElement;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class autotests {






    @Test
    public void Testsearchwomanclose(){

        try {
            $x("//*[@href ='http://automationpractice.com/index.php?id_category=3&controller=category']").click();
            String pngFileName = screenshot("my_file_name1");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            $x("//*[@src='http://automationpractice.com/img/c/4-medium_default.jpg']").scrollIntoView(false).click();
            String pngFileName = screenshot("my_file_name2");
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }


        try {

           SelenideElement el = $x("//a[contains(@class, 'product_img_link') and @href='http://automationpractice.com/index.php?id_product=1&controller=product']");
            String pngFileName = screenshot("my_file_name3");
           el.hover();
           Thread.sleep(3000);
           $x("//a[contains(@class, 'button ajax_add_to_cart_button btn btn-default') and @href='http://automationpractice.com/index.php?controller=cart&add=1&id_product=1&token=e817bb0705dd58da8db074c69f729fd8']").click();
           Thread.sleep(10000);
         //  String pngFileName = screenshot("my_file_name3");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $x("//div[id='layer_cart']").shouldBe(Condition.visible);
        if ($x("//i[contains(@class, 'icon-ok')]").exists() == true){
            System.out.println("Товар добавлен");
        }
        else {
            System.out.println("Товар не добавлен");
        }




        // $x("//div[2][contains(@class, 'button-container')][1]").findElement(By.xpath("//div[2][contains(@class, 'button-container')][1]")).click();
       // try {
         //   Thread.sleep(10000);
        //} catch (InterruptedException e) {
          //  e.printStackTrace();
       // }
        //@Test
    //public void test1() {
      //  $x("//*[@href='/televizory-i-cifrovoe-tv-1/televizory-65?from=under_search']").click();
       // $x("//h1[text()='Телевизоры']").shouldBe(Condition.visible);
       // $x("//h1").shouldBe(Condition.matchText("Телевизоры"));
        //$x("//h1").shouldBe(Condition.matchText("Телевизоры"));
        //$x("//h1").shouldBe(Condition.matchText("Телевизоры"));
        //$x("//h1").shouldBe(Condition.matchText("Телевизоры"));
    }






}
