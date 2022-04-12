package guru.qa.utils;
import static java.lang.String.copyValueOf;
import static java.lang.String.format;
import com.github.javafaker.Faker;
public class getFaker {
    Faker faker = new Faker();
    public String getFirstName(){
         return faker.name().firstName();
    }
    public String getLastName(){
        return faker.name().lastName();
    }
    public String getEmail(){
        return faker.internet().emailAddress();
    }
    public String getNumber(){
        return faker.phoneNumber().subscriberNumber(10);
    }
    public String getAddress(){
        return faker.address().fullAddress();
    }

}
