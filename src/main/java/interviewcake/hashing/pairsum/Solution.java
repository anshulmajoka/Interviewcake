package interviewcake.hashing.pairsum;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Solution {

    public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {

        // determine if two movies add up to the flight length
        Set<Integer> data = new HashSet<>();

        for (Integer i : movieLengths) {

            int secondMovieLength = flightLength - i;
            if (data.contains(secondMovieLength)) {
                return true;
            } else {
                data.add(i);
            }
        }

        return false;
    }


    // tests

    @Test
    public void shortFlightTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{2, 4}, 1);
        assertFalse(result);
    }

    @Test
    public void longFlightTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{2, 4}, 6);
        assertTrue(result);
    }

    @Test
    public void onlyOneMovieHalfFlightLenghtTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{3, 8}, 6);
        assertFalse(result);
    }

    @Test
    public void twoMoviesHalfFlightLengthTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{3, 8, 3}, 6);
        assertTrue(result);
    }

    @Test
    public void lotsOfPossiblePairsTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{1, 2, 3, 4, 5, 6}, 7);
        assertTrue(result);
    }

    @Test
    public void notUsingFirstMovieTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{4, 3, 2}, 5);
        assertTrue(result);
    }

    @Test
    public void multipleMoviesShorterThanFlightTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{5, 6, 7, 8}, 9);
        assertFalse(result);
    }

    @Test
    public void oneMovieTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{6}, 6);
        assertFalse(result);
    }

    @Test
    public void noMoviesTest() {
        final boolean result = canTwoMoviesFillFlight(new int[]{}, 6);
        assertFalse(result);
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