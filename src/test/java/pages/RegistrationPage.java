package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;
import pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private final String titleText = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            numberInput = $("#userNumber"),
            dateInput = $("#dateOfBirthInput"),
            addressInput = $("#currentAddress");

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text(titleText));
        executeJavaScript("$('#adplus-anchor').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage setSubject(String value) {
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#subjectsInput").setValue("Chemistry").pressEnter();

        return this;
    }

    public RegistrationPage setDateBirth(String day, String month, String year) {
        dateInput.click();
        CalendarComponents.setDate(day, month, year);
        return this;
    }

    public RegistrationPage verifyModalAppears() {
        RegistrationResultModal.verifyModalAppears();

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        RegistrationResultModal.verifyResult(key, value);

        return this;
    }

}
