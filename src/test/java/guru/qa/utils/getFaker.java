package guru.qa.utils;
import com.github.javafaker.Faker;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;


public class getFaker {
    RandomValue random = new RandomValue();
    Faker faker = new Faker();
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);

    public String getFirstname = faker.name().firstName();
    public String getLastname = faker.name().lastName();
    public String getEmail = faker.internet().emailAddress();
    public String getPhoneNumber = faker.number().digits(10);
    public String getAddress = faker.address().fullAddress();

    //Date of Birth
    public String getBirthDate = formatter.format(faker.date().birthday(18, 65));
    public String[] dayMonthYear = getBirthDate.split(" ");
    public String getDayOfBirth = dayMonthYear[0];
    public String getMonthOfBirth = dayMonthYear[1];
    public String getYearOfBirth = dayMonthYear[2];

    String[] genders = {"Male", "Female", "Other"};
    String[] subjects = {"English", "Maths", "Hindi","Computer Science"};
    String[] hobbies = {"Sports", "Reading", "Music"};


    public String setRandomGenderType() {
        return random.getRandomValue(genders);
    }

    public String setRandomSubject() {
        return random.getRandomValue(subjects);
    }

    public String setRandomHobbies() {
        return random.getRandomValue(hobbies);
    }
}
