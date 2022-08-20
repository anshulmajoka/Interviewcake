package algopractices;

import java.util.HashMap;
import java.util.Map;

public class Miu3 {

    static void main(String[] args) {
//        int [] t = {1,2,3,1,0};
//        int [] t = {18};
//        int[] t = {1,4,1,4,5,6};
        int[] t = {0,1,2,3,4,5,6,7,8};
        System.out.println(isPaired(t, 6));
    }

    static int isPaired(int[] a, int n) {

        if(a.length == 0 || a.length == 1){
            return 0;
        }

        for (int i = 0; i < a.length; i++) {
            int num1 = a[i];
            for (int j = 0; j < a.length; j++) {
                int num2 = a[j];
                if (num1 + num2 == n && i + j == n && i != j) {
                    return 1;
                }
            }

        }
        return 0;
    }
/*

. An array is rapidly increasing if each element (except the first one) is greater than twice the sum of all its preceding elements.

Write a method named isRapidlyIncreasing that returns 1 if its array argument is rapidly increasing. Otherwise it returns 0.

If you are programming in Java or C#, the function signature is
int isRapidlyIncreasing(int[ ] a)

If you are programming in C or C++, the function signature is
int isRapidlyIncreasing(int a[ ], int len) where len is the number of elements in the array a.

You may assume that the input array parameter is not null and that it contains at least one element
 */
}
