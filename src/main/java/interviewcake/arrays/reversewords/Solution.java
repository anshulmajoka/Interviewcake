package interviewcake.arrays.reversewords;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertArrayEquals;

public class Solution {

    public static void reverseWords(char[] message) {

        // decode the message by reversing the words

        reverseArray(message, 0, message.length - 1);

        //reverse words
        int left = 0;
        for (int i = 0; i < message.length; i++) {
            if (message[i] == ' ') {
                reverseArray(message, left, i - 1);
                left = i + 1;
            } else if (message.length - 1 == i) {
                reverseArray(message, left, i);
            }
        }
    }

    private static void reverseArray(char[] message, int startIndex, int endindex) {
        //reverse complete array
        while (startIndex < endindex) {
            swap(message, startIndex, endindex);
            startIndex++;
            endindex--;
        }
    }

    private static void swap(char[] message, int index1, int index2) {
        char temp = message[index1];
        message[index1] = message[index2];
        message[index2] = temp;
    }

    // tests

    @Test
    public void oneWordTest() {
        final char[] expected = "vault".toCharArray();
        final char[] actual = "vault".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoWordsTest() {
        final char[] expected = "cake thief".toCharArray();
        final char[] actual = "thief cake".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void threeWordsTest() {
        final char[] expected = "get another one".toCharArray();
        final char[] actual = "one another get".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void multipleWordsSameLengthTest() {
        final char[] expected = "the cat ate the rat".toCharArray();
        final char[] actual = "rat the ate cat the".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void multipleWordsDifferentLengthsTest() {
        final char[] expected = "chocolate bundt cake is yummy".toCharArray();
        final char[] actual = "yummy is cake bundt chocolate".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void emptyStringTest() {
        final char[] expected = "".toCharArray();
        final char[] actual = "".toCharArray();
        reverseWords(actual);
        assertArrayEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}