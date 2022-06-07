package assignment11;

public class FibonacciMemoized {

    int count = 0;
    int fib(int n) {
        int[] a = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            a[i] = -1;
        }
        int arr[] = new int[2];
        System.out.print(arr);
        return getMemoizedFib(n, a);
    }

    private int getMemoizedFib(int n, int[] a) {
        if (a[n] < 0) {
            if (n == 0) {
                a[n] = 0;
            } else if (n == 1) {
                a[n] = 1;
            } else {
                count = count + 1;
                System.out.println(count);
                a[n] = getMemoizedFib(n - 1, a) + getMemoizedFib(n - 2, a);
            }
        }
        return a[n];
    }


}
