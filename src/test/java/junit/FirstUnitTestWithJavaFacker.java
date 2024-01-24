package junit;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FirstUnitTestWithJavaFacker extends TestBase {

    Faker faker = new Faker(new Locale("de"));

    String firstname = faker.name().firstName();
    String lastname = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String number = faker.number().digits(10);
    String address = faker.address().secondaryAddress();


    @Test
    void fillFormTest() {

        new RegistrationPage().openPage()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setEmail(email)
                .setNumber(number)
                .setSubject()
                .setAddress(address)
                .setDateBirth("16", "3", "1996")
                .setGender("Male");

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
    }
}