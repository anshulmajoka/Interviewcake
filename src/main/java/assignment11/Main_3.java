package assignment11;

public class Main_3 {
    public static void main(String[] args) {

//        int x[] = {1, 3};
//        int x[] = {1, 2, 1, 2, 1, 2, 1, 2, 1};
//        int x[] = {1, 3, 2};
//        int x[] = {1, 3, 3, 2, 1};
          int x[] = {1, 3,9,27};
          int x1[] = {1, 3,200,500};
          int x2[] = {1};
          int x3[] = {1, 3,9,26};
          int x4[] = {1, 3,7,26};
          int x5[] = {1, 3,8,26};
        System.out.println(isRapidlyIncreasing(x));
        System.out.println(isRapidlyIncreasing(x1));
        System.out.println(isRapidlyIncreasing(x2));
        System.out.println(isRapidlyIncreasing(x3));
        System.out.println(isRapidlyIncreasing(x4));
        System.out.println(isRapidlyIncreasing(x5));
    }


    /**
     3. An array is rapidly increasing
     if each element (except the first one) is greater than twice the sum of all its preceding elements.

     Write a method named isRapidlyIncreasing that returns 1 if its array argument is rapidly increasing. Otherwise it returns 0.

     If you are programming in Java or C#, the function signature is
     int isRapidlyIncreasing(int[ ] a)

     If you are programming in C or C++, the function signature is
     int isRapidlyIncreasing(int a[ ], int len) where len is the number of elements in the array a.

     You may assume that the input array parameter is not null and that it contains at least one element

     */

    static int isRapidlyIncreasing(int[] a) {

        if(a.length ==1){
            return 1;
        }
        int sum = a[0];
        for(int i=1; i<a.length; i++){
            if(a[i]> sum * 2){
                sum = sum + a[i];
                continue ;
            } else {
                return 0;
            }
        }

        return 1;
    }

}
