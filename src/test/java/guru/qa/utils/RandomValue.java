package guru.qa.utils;

import java.util.Random;

public class RandomValue {
    public String getRandomValue(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return String.valueOf(array[rnd]);
    }
}
