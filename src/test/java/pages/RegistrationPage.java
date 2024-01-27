package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
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

    @Step("Open main page")
    public RegistrationPage openPage(){
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text(titleText));
        executeJavaScript("$('#adplus-anchor').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    @Step("Set firstname")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    @Step("Set lastname")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    @Step("Set email")
    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }
    @Step("Set number")
    public RegistrationPage setNumber(String value) {
        numberInput.setValue(value);

        return this;
    }
    @Step("Set address")
    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }
    @Step("Set Gender")
    public RegistrationPage setGender(String value) {
        $(byText(value)).click();

        return this;
    }
    @Step("Set subjects")
    public RegistrationPage setSubject() {
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("[for=hobbies-checkbox-2]").click();

        return this;
    }
    @Step("Set Date of Birth")
    public RegistrationPage setDateBirth(String day, String month, String year) {
        dateInput.click();
        CalendarComponents.setDate(day, month, year);
        return this;
    }
    @Step("Verify appears")
    public RegistrationPage verifyModalAppears() {
        RegistrationResultModal.verifyModalAppears();

        return this;
    }
    @Step("verify results")
    public RegistrationPage verifyResult(String key, String value) {
        RegistrationResultModal.verifyResult(key, value);

        return this;
    }

}
