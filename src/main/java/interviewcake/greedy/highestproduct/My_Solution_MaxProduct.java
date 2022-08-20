package interviewcake.greedy.highestproduct;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

public class My_Solution_MaxProduct {

    public static int highestProductOf3(int[] intArray) {

        if (intArray.length <= 3) {
            throw new IllegalArgumentException();
        }
        // calculate the highest product of three numbers
        int maxProduct = intArray[0] *   intArray[1] *  intArray[2];

        for(int i=3; i<intArray.length ; i ++){
            int current =  intArray[i];
            int possibleMax1 = intArray[i-3] * intArray[i-2] * current;
            int possibleMax2 = intArray[i-2] * intArray[i-1] * current;
            int possibleMax3 = intArray[i-3] * intArray[i-1] * current;

            int maxProduct4 = Math.max(Math.max(possibleMax1, possibleMax2), possibleMax3);
            maxProduct = Math.max(maxProduct4, maxProduct);
        }

        return maxProduct;
    }


    // tests

    @Test
    public void shortArrayTest() {
        final int actual = highestProductOf3(new int[] {1, 2, 3, 4});
        final int expected = 24;
        assertEquals(expected, actual);
    }

    @Test
    public void longerArrayTest() {
        final int actual = highestProductOf3(new int[] {6, 1, 3, 5, 7, 8, 2});
        final int expected = 336;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasOneNegativeTest() {
        final int actual = highestProductOf3(new int[] {-5, 4, 8, 2, 3});
        final int expected = 96;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoNegativesTest() {
        final int actual = highestProductOf3(new int[] {-10, 1, 3, 2, -10});
        final int expected = 300;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayIsAllNegativesTest() {
        final int actual = highestProductOf3(new int[] {-5, -1, -3, -2});
        final int expected = -6;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyArrayTest() {
        highestProductOf3(new int[] {});
    }

    @Test(expected = Exception.class)
    public void exceptionWithOneNumberTest() {
        highestProductOf3(new int[] {1});
    }

    @Test(expected = Exception.class)
    public void exceptionWithTwoNumbersTest() {
        highestProductOf3(new int[] {1, 1});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(My_Solution_MaxProduct.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}