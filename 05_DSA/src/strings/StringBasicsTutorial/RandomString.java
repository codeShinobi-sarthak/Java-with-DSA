package strings.StringBasicsTutorial;

//! note : this is only used fro string Buffer example

import java.util.Random;

public class RandomString {
    public String generate(int size) {
        StringBuffer sb = new StringBuffer();

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            char ch = (char) (97 + (int) (random.nextFloat() * 26));
            sb.append(ch);
        }

        return sb.toString();
    }
}
