package algo;

import java.util.Arrays;

public class Reapeat {
    public String repeatingWord(String s) {
        String[] str = s.split(" ");
        String firstWord = "";
        String repeatingWord = "";
        String second = "";
        String s1 = s.replaceAll(" ", "");
        for (int i = 0; i < str.length; i++) {
            firstWord = str[i];
            for (int j = 1; j < str.length; j++) {
                second = str[j];
                if (firstWord.equals(second)) {
                    repeatingWord = firstWord;
                    break;
                }
            }
        }
    return "";

    }
}
