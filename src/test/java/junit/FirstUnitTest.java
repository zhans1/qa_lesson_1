package junit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstUnitTest {
    String firstname = "Egor";
    String lastname = "Makarov";
    String email = "example@gmail.com";
    String number = "1234567890";
    String address = "Current Address 1";

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstname);
        $("#lastName").setValue(lastname);
        $("#userEmail").setValue(email);
        $(byText("gender")).click();
        $("#userNumber").setValue(number);

        $("#dateOfBirthInput").click();
        $("select.react-datepicker__year-select").selectOptionByValue("1996");
        $("select.react-datepicker__month-select").selectOptionByValue("June");
        $("div.react-datepicker__day react-datepicker__day--016").click();

        $("#subjectsContainer").setValue("Math").pressEnter();
        $("#subjectsContainer").setValue("Chemistry").pressEnter();
        $("#hobbies-checkbox-2").click();

        $("#uploadPicture").uploadFile(new File ("src/test/resources/image.png"));

        $("#currentAddress").setValue(address);

        executeJavaScript("$('#adplus-anchor').remove()");
        executeJavaScript("$('footer').remove()");

        //$("#stateCity-wrapper").findElement(byText("Select State")).click();
        $("#state").setValue("Haryana");
        $("#city").setValue("Karnal");

        $("#submit").click();

        sleep(2000);
    }
}
