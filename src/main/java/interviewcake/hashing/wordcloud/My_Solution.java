package interviewcake.hashing.wordcloud;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class My_Solution {

    public static class WordCloudData {

        private Map<String, Integer> wordsToCounts = new HashMap<>();

        private void populateWordsToCounts(String inputString) {

            // count the frequency of each word

            //Regex performance Issue
            //String []  words = inputString.split(" ");
            char[] chars = inputString.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                if (Character.isAlphabetic(chars[i]) || i == chars.length-1) {
                    sb.append(chars[i]);
                } else {
                    wordsToCounts.compute(sb.toString(), (w,c)-> wordsToCounts.getOrDefault(w,0) + 1 );
                    sb = new StringBuilder();
                }
            }
        }

        private String getWordFromSpecialWord(String s) {


            return null;
        }

        public WordCloudData(String inputString) {
            populateWordsToCounts(inputString);
        }

        public Map<String, Integer> getWordsToCounts() {
            return wordsToCounts;
        }
    }


    // tests

    // There are lots of valid solutions for this one. You
    // might have to edit some of these tests if you made
    // different design decisions in your solution.

    @Test
    public void simpleSentenceTest() {
        final String text = "I like cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() {
            {
                put("I", 1);
                put("like", 1);
                put("cake", 1);
            }
        };
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void longerSentenceTest() {
        final String text = "Chocolate cake for dinner and pound cake for dessert";
        final Map<String, Integer> expected = new HashMap<String, Integer>() {
            {
                put("and", 1);
                put("pound", 1);
                put("for", 2);
                put("dessert", 1);
                put("Chocolate", 1);
                put("dinner", 1);
                put("cake", 2);
            }
        };
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void punctuationTest() {
        final String text = "Strawberry short cake? Yum!";
        final Map<String, Integer> expected = new HashMap<String, Integer>() {
            {
                put("cake", 1);
                put("Strawberry", 1);
                put("short", 1);
                put("Yum", 1);
            }
        };
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void hyphenatedWordsTest() {
        final String text = "Dessert - mille-feuille cake";
        final Map<String, Integer> expected = new HashMap<String, Integer>() {
            {
                put("cake", 1);
                put("Dessert", 1);
                put("mille-feuille", 1);
            }
        };
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void ellipsesBetweenWordsTest() {
        final String text = "Mmm...mmm...decisions...decisions";
        final Map<String, Integer> expected = new HashMap<String, Integer>() {
            {
                put("mmm", 2);
                put("decisions", 2);
            }
        };
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    @Test
    public void apostrophesTest() {
        final String text = "Allie's Bakery: Sasha's Cakes";
        final Map<String, Integer> expected = new HashMap<String, Integer>() {
            {
                put("Bakery", 1);
                put("Cakes", 1);
                put("Allie's", 1);
                put("Sasha's", 1);
            }
        };
        final WordCloudData actual = new WordCloudData(text);
        assertEquals(expected, actual.getWordsToCounts());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(My_Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}