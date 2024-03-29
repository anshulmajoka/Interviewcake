package interviewcake.greedy.applestock;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertEquals;

public class My_Solution_MaxSum {

    public static int getMaxProfit(int[] stockPrices) {

        // calculate the max profit

        if (stockPrices.length <= 1) {
            throw new IllegalArgumentException();
        }

        int buyPrice = stockPrices[0];
        int sellPrice = stockPrices[1];
        int maxProfit = sellPrice - buyPrice;

        for (int i = 2; i < stockPrices.length; i++) {
            int currentPrice = stockPrices[i];
            int newPossibleMaxProfit = Math.max(currentPrice - sellPrice, currentPrice - buyPrice);
            maxProfit = Math.max(maxProfit, newPossibleMaxProfit);
        }
        return maxProfit;
    }


    // tests

    @Test
    public void priceGoesUpThenDownTest() {
        final int actual = getMaxProfit(new int[]{1, 5, 3, 2});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownThenUpTest() {
        final int actual = getMaxProfit(new int[]{7, 2, 8, 9});
        final int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesUpAllDayTest() {
        final int actual = getMaxProfit(new int[]{1, 6, 7, 9});
        final int expected = 8;
        assertEquals(expected, actual);
    }

    @Test
    public void priceGoesDownAllDayTest() {
        final int actual = getMaxProfit(new int[]{9, 7, 4, 1});
        final int expected = -2;
        assertEquals(expected, actual);
    }

    @Test
    public void priceStaysTheSameAllDayTest() {
        final int actual = getMaxProfit(new int[]{1, 1, 1, 1});
        final int expected = 0;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithOnePriceTest() {
        getMaxProfit(new int[]{5});
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyPricesTest() {
        getMaxProfit(new int[]{});
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(My_Solution_MaxSum.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}