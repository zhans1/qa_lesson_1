package junit;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;

@Tag("remote")
public class FirstUnitTest extends TestBaseWithBrowser {

    Faker faker = new Faker(new Locale("de"));

    String firstname = faker.name().firstName();
    String lastname = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String number = faker.number().digits(10);
    String address = faker.address().secondaryAddress();

    @Test
    void fillFormTest() {
<<<<<<< HEAD

        step("Open form" () -)
        open("/automation-practice-form");
        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(email);
        $(byText("Male")).click();
        $("#userNumber").setValue(number);
=======
>>>>>>> 14220904a0743293810609462af96026f850f3de


        step("Open main page", () -> {
            open("/automation-practice-form");
            executeJavaScript("$('#adplus-anchor').remove()");
            executeJavaScript("$('footer').remove()");
        });

        step("Set user information", () -> {
            $("#firstName").setValue(firstname);
            $("#lastName").setValue(lastname);
            $("#userEmail").setValue(email);
            $(byText("Male")).click();
            $("#userNumber").setValue(number);
        });

        step("Set date of birth", () -> {
            $("#dateOfBirthInput").click();
            $("select.react-datepicker__year-select").selectOptionByValue("1996");
            $("select.react-datepicker__month-select").selectOptionByValue("3");
            $("div.react-datepicker__day--016").click();
        });

        step("Set more information", () -> {
            $("#subjectsInput").setValue("Math").pressEnter();
            $("#subjectsInput").setValue("Chemistry").pressEnter();
            $("[for=hobbies-checkbox-2]").click();

            $("#uploadPicture").uploadFile(new File ("src/test/resources/img/image.png"));

            $("#currentAddress").setValue(address);

            //$("#stateCity-wrapper").findElement(byText("Select State")).click();
            $("#state").click();
            $(byText("Haryana")).click();
            $("#city").click();
            $(byText("Karnal")).click();
            $("#submit").click();
        });

        step("Check information", () -> {
            $(".table-responsive").shouldHave(
                    text(firstname),
                    text(lastname),
                    text(email),
                    text(number),
                    text(address));
            $("#closeLargeModal").click();
        });
    }
}