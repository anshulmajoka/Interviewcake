package interviewcake.hashing.palindromeInStringPermutaion;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class My_Solution {

    public static boolean hasPalindromePermutation(String theString) {

        // check if any permutation of the input is a palindrome

        if (theString == null) {
            return false;
        }

        HashMap<Character, Integer> data = new HashMap<>();
        for (Character c : theString.toCharArray()) {

            if (data.containsKey(c)) {
                data.put(c, data.get(c) + 1);
            } else {
                data.put(c, 1);
            }
        }

        int oneCounter = 0;

        for (Map.Entry<Character, Integer> entry : data.entrySet()) {

            Integer value = entry.getValue();


            if (value % 2 == 1 && theString.length() % 2 == 1) {
                oneCounter++;
                if (oneCounter > 1) {
                    return false;
                }
                continue;
            }
            if (value % 2 != 0) {
                return false;
            }

        }


        return true;
    }


    // tests

    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabcbcd");
        assertTrue(result);
    }

    @Test
    public void permutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabccbdd");
        assertTrue(result);
    }

    @Test
    public void noPermutationWithOddNumberOfChars() {
        final boolean result = hasPalindromePermutation("aabcd");
        assertFalse(result);
    }

    @Test
    public void noPermutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabbcd");
        assertFalse(result);
    }

    @Test
    public void permutationWithOddNumberOfCharsMiddleCharNotUniqueTest() {
        final boolean result = hasPalindromePermutation("aabbb");
        //abbba
        assertTrue(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = hasPalindromePermutation("");
        assertTrue(result);
    }

    @Test
    public void oneCharacterStringTest() {
        final boolean result = hasPalindromePermutation("a");
        assertTrue(result);
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