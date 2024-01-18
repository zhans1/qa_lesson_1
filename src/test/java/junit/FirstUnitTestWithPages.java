package junit;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FirstUnitTestWithPages extends TestBase {
    String firstname = "Egor";
    String lastname = "Makarov";
    String email = "example@gmail.com";
    String number = "1234567890";
    String address = "Current Address 1";


    @Test
    void fillFormTest() {

        new RegistrationPage().openPage()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setEmail(email)
                .setNumber(number)
                .setAddress(address)
                .setDateBirth("16", "3", "1996")
                .setGender("Male");

        $("#subjectsInput").setValue("Math").pressEnter();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("[for=hobbies-checkbox-2]").click();

        $("#uploadPicture").uploadFile(new File("src/test/resources/img/image.png"));

        //$("#stateCity-wrapper").findElement(byText("Select State")).click();
        $("#state").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Karnal")).click();

        $("#submit").click();

        registrationPage.verifyModalAppears()
                .verifyResult("Student Name", firstname + " " + lastname)
                .verifyResult("Student Email", email)
                .verifyResult("Mobile", number)
                .verifyResult("Address", address);

        $("#closeLargeModal").click();
    }
}