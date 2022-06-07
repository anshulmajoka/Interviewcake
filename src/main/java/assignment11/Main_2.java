package assignment11;

public class Main_2 {
    public static void main(String[] args) {

//        int x[] = {1, 3};
//        int x[] = {1, 2, 1, 2, 1, 2, 1, 2, 1};
//        int x[] = {1, 3, 2};
//        int x[] = {1, 3, 3, 2, 1};
//

        /**
         * The Fibonacci sequence of numbers is 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
         * The first and second numbers are 1 and after that ni = ni-2 + ni-1, e.g., 34 = 13 + 21.
         * A number in the sequence is called a Fibonacci number.
         * Write a method with signature int closestFibonacci(int n) which returns the largest Fibonacci number that is less than or equal to its argument.
         * For example, closestFibonacci(12) returns 8 because 8 is the largest Fibonacci number less than 12
         * and closestFibonacci(33) returns 21 because 21 is the largest Fibonacci number that is <= 33.
         * closestFibonacci(34) should return 34.
         * If the argument is less than 1 return 0. Your solution must not use recursion because unless you cache the Fibonacci numbers as you find them, the recursive solution recomputes the same Fibonacci number many times.
         */



        CommonString c = new CommonString();

        System.out.println(c.maxCommonString("a,b,c,d,e,f,g,h,i,j,k", "e,f,g"));

    }
}
