package junit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstUnitTestWithPages {
    String firstname = "Egor";
    String lastname = "Makarov";
    String email = "example@gmail.com";
    String number = "1234567890";
    String address = "Current Address 1";

    @BeforeAll
    static void beforeAll(){
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {

        new RegistrationPage().openPage()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setEmail(email)
                .setNumber(number)
                .setAddress(address);

        $(byText("Male")).click();

        $("#dateOfBirthInput").click();
        $("select.react-datepicker__year-select").selectOptionByValue("1996");
        $("select.react-datepicker__month-select").selectOptionByValue("3");
        $("div.react-datepicker__day--016").click();

        $("#subjectsInput").setValue("Math").pressEnter();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("[for=hobbies-checkbox-2]").click();

        $("#uploadPicture").uploadFile(new File ("src/test/resources/image.png"));

        //$("#stateCity-wrapper").findElement(byText("Select State")).click();
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(
                text(firstname),
                text(lastname),
                text(email),
                text(number),
                text(address));
        $("#closeLargeModal").click();
    }
}