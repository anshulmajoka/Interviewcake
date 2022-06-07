package assignment11;

public class FibonacciSequence {

    int count = 0;

    int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        count = count + 1;
        System.out.println(count);
        return fib(n - 1) + fib(n - 2);
    }
}
