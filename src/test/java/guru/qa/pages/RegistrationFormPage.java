package guru.qa.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.components.CalendarComponent;
import org.checkerframework.checker.units.qual.C;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    //locators
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            userNumberInput = $("#userNumber"),
            uploadPicturePath = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            tableResultCheck = $(".table-responsive");

    //actions
    public RegistrationFormPage openPage(){
        open("automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }
    public RegistrationFormPage setFirstName(String value){
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setLastName(String value){
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setEmail(String value){
        emailInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setGender(String value){
        $("#genterWrapper").$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setNumber(String value){
        userNumberInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setDateOfBirth(String day, String month, String year){
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day,month,year);
        return this;
    }
    public RegistrationFormPage setHobies(String hobie_1,String hobie_2,String categoryOfHobie){
        $("#subjectsInput").setValue(hobie_1).pressEnter();
        $("#subjectsInput").setValue(hobie_2).pressEnter();
        $("#hobbiesWrapper").$(byText(categoryOfHobie)).click();
        return this;
    }
    public  RegistrationFormPage setUploadPicture(String value){
        uploadPicturePath.uploadFromClasspath(value);
        return this;
    }
    public RegistrationFormPage setCurrentAddress(String value){
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationFormPage setState(String value){
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }
    public RegistrationFormPage setCity(String value){
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage pressSubmit(){
        $("#submit").click();
        return this;
    }
    public RegistrationFormPage checkResultTable(String key,String value){
        tableResultCheck.$(byText(key)).parent().shouldHave(text(value));
        return this;
    }
}
