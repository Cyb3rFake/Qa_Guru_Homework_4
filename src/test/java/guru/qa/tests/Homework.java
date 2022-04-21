package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import guru.qa.pages.RegistrationFormPage;
import guru.qa.utils.getFaker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.closeWindow;
import static java.lang.String.format;

public class Homework {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    getFaker faker = new getFaker();

    String  firstName = faker.getFirstname,
            lastName = faker.getLastname,
            email = faker.getEmail,
            currentAddress = faker.getAddress,
            gender = faker.setRandomGenderType(),
            subject = faker.setRandomSubject(),
            hobby = faker.setRandomHobbies(),
            state = "NCR",
            city = "Noida",
            dayOfBirth = faker.getDayOfBirth,
            monthOfBirth = faker.getMonthOfBirth,
            yearOfBirth = faker.getYearOfBirth,
            phoneNumber = faker.getPhoneNumber,
            imagePath = "img/Jdun.jpg",

            fullName = format("%s %s", firstName, lastName),
            dateOfBirth = format("%s %s,%s", dayOfBirth, monthOfBirth, yearOfBirth),
            fileName = imagePath.substring(4),
            stateAndCity = format("%s %s", state, city);

    @BeforeAll
    static void setUP() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @AfterAll
    static void closeAll() throws InterruptedException {
        Thread.sleep(500);
        closeWindow();
        closeWebDriver();
    }

    @Test
    void fillFieldsTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setPhoneNumber(phoneNumber)
                .setDate(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobbies(hobby)
                .setPath(imagePath)
                .setAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .pressSubmit();

        registrationFormPage
                .checkResultTable("Student Name", fullName)
                .checkResultTable("Student Email", email)
                .checkResultTable("Gender", gender)
                .checkResultTable("Mobile", phoneNumber)
                .checkResultTable("Date of Birth", dateOfBirth)
                .checkResultTable("Subjects", subject)
                .checkResultTable("Hobbies", hobby)
                .checkResultTable("Picture", fileName)
                .checkResultTable("Address", currentAddress)
                .checkResultTable("State and City", stateAndCity);
    }
}
