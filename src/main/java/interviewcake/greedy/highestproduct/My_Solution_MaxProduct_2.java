package interviewcake.greedy.highestproduct;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

public class My_Solution_MaxProduct_2 {

    public static int highestProductOf3(int[] intArray) {

        if (intArray.length <= 3) {
            throw new IllegalArgumentException();
        }
        //6, -1, 3, 5, 7, 8, 2
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        // calculate the highest product of three numbers

        for (int i = 0; i < intArray.length; i++) {
            int current = intArray[i];
            if (current > max1) {
                max3 = max2;
                max2 = max1;
                max1 = current;
            } else if (current > max2) {
                max3 = max2;
                max2 = current;
            } else if (current > max3) {
                max3 = current;
            }


            if(current < min1){
                min2 = min1;
                min1 = current;
            }else if( current < min2){
                min2 = current;
            }

        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }


    // tests

    @Test
    public void shortArrayTest() {
        final int actual = highestProductOf3(new int[]{1, 2, 3, 4});
        final int expected = 24;
        assertEquals(expected, actual);
    }

    @Test
    public void longerArrayTest() {
        final int actual = highestProductOf3(new int[]{6, 1, 3, 5, 7, 8, 2});
        final int expected = 336;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasOneNegativeTest() {
        final int actual = highestProductOf3(new int[]{-5, 4, 8, 2, 3});
        final int expected = 96;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoNegativesTest() {
        final int actual = highestProductOf3(new int[]{-10, 1, 3, 2, -10});
        final int expected = 300;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayIsAllNegativesTest() {
        final int actual = highestProductOf3(new int[]{-5, -1, -3, -2});
        final int expected = -6;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyArrayTest() {
        highestProductOf3(new int[]{});
    }

    @Test(expected = Exception.class)
    public void exceptionWithOneNumberTest() {
        highestProductOf3(new int[]{1});
    }

    @Test(expected = Exception.class)
    public void exceptionWithTwoNumbersTest() {
        highestProductOf3(new int[]{1, 1});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(My_Solution_MaxProduct_2.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}