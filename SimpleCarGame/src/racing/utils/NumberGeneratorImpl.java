package racing.utils;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {
    @Override
    public int generateRandom(){
        Random random = new Random();
        return random.nextInt(10);
    }

}
