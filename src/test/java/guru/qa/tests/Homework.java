package guru.qa.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import guru.qa.pages.RegistrationFormPage;
import guru.qa.utils.RandomUtils;
import guru.qa.utils.getFaker;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.closeWindow;
import static java.lang.String.format;

public class Homework {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    getFaker f = new getFaker();

    String  firstName = f.getFirstName(),
            lastName = f.getLastName(),
            fullName = format("%s %s",firstName, lastName),
            email = f.getEmail(),
            number = f.getNumber(),
            currentAddress = f.getAddress();

    RandomUtils randomUtils = new RandomUtils();
    int rDay = randomUtils.getRandomInt(1,28);
    int rYear = randomUtils.getRandomInt(1950,2022);

    @BeforeAll
    static void setUP() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com/";
        Configuration.holdBrowserOpen = true;
    }

    @AfterAll
    static void closeAll() throws InterruptedException {
        Thread.sleep(5000);
        closeWindow();
        closeWebDriver();
    }

    @Test
    void fillFieldsTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender("Male")
                .setNumber(number)
                .setDateOfBirth("17", "December","2002")
                .setHobies("Math", "Computer Science", "Reading")
                .setUploadPicture("img/Jdun.jpg")
                .setCurrentAddress(currentAddress)
                .setState("NCR")
                .setCity("Gurgaon")
                .pressSubmit();

        registrationFormPage.checkResultTable("Student Name", fullName)
                .checkResultTable("Student Email", email)
                .checkResultTable("Gender", "Male")
                .checkResultTable("Mobile", number)
                .checkResultTable("Date of Birth", "17 December,2002")
                .checkResultTable("Subjects", "Maths, Computer Science")
                .checkResultTable("Hobbies", "Reading")
                .checkResultTable("Picture", "Jdun.jpg")
                .checkResultTable("Address", currentAddress)
                .checkResultTable("State and City", "NCR Gurgaon");
    }
}
