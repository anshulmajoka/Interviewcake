package assignment11;

public class Main {
    public static void main(String[] args) {

//        int x[] = {1, 3};
//        int x[] = {1, 2, 1, 2, 1, 2, 1, 2, 1};
//        int x[] = {1, 3, 2};
//        int x[] = {1, 3, 3, 2, 1};
//          int x[] = {1, 2, -18, -18, 1, 2};
        int x[] = {2};
        System.out.println(isMartian(x));
    }


    /**
     * Define an array to be a Martian array if
     * the number of 1s is greater than the number of 2s
     * and no two adjacent elements are equal.
     * <p>
     * Write a function named isMartian that returns 1 if its array argument is a Martian array, otherwise it returns 0.
     * <p>
     * There are two additional requirements.
     * <p>
     * You should return 0 as soon as it is known that the array is not a Martian array;
     * continuing to analyze the array would be a waste of CPU cycles.
     * <p>
     * There should be exactly one for loop in your function
     * <p>
     * If you are programming in Java or C#, the function signature is
     * int isMartian(int[ ] a)
     * <p>
     * If you are programming in C or C++, the function signature is
     * int isMartian(int a[ ], int len) where len is the number of elements in the array a.
     * <p>
     * Examples
     * <p>
     * a is	then function returns	reason
     * {1, 3}	1	There is one 1 and zero 2s, hence the number of 1s is greater than the number of 2s. Also, no adjacent elements have the same value (1 does not equal 3)
     * {1, 2, 1, 2, 1, 2, 1, 2, 1}	1	There are five 1s and four 2s, hence the number of 1s is greater than the number of 2s. Also, no two adjacent elements have the same value.
     * {1, 3, 2}	0	There is one 1 and one 2, hence the number of 1s is not greater than the number of 2s.
     * {1, 3, 3, 2, 1}	0	There are two 3s adjacent to each other.
     * {1, 2, -18, -18, 1, 2}	0	The two -18s are adjacent to one another. Note that the number of 1s is not greater than than the number of 2s but your method should return 0 before determining that! (See the additional requirements above.)
     * {}	0	There are zero 1s and zero 2s hence the number of 1s is not greater than the number of 2s.
     * {1}	1	There is one 1 and zero 2s hence the number of 1s is greater than the number of 2s. Also since there is only one element, there cannot be adjacent elements with the same value.
     * {2}	0	There are zero 1s and one 2 hence the number of 1s is not greater than the number of 2s.
     * <p>
     * Hint: Make sure that your solution does not exceed the boundaries of the array!
     * <p>
     * Copy and paste your answer here and click the "Submit answer" button
     */

    static int isMartian(int[] a) {

        if (a.length == 0) {
            return 0;
        }

        int countOne = 0;
        int countTwo = 0;
        int first = a[0];

        if (first == 1) {
            countOne++;
        } else if (first == 2) {
            countTwo++;
        }

        for (int i = 0; i < a.length - 1; i++) {
            first = a[i];
            int second = a[i + 1];

            if (first == second) {
                return 0;
            }

            if (second == 1) {
                countOne++;
            } else if (second == 2) {
                countTwo++;
            }
        }
        if (countOne > countTwo) {
            return 1;
        }
        return 0;
    }

}
