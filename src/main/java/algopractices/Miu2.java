package algopractices;

public class Miu2 {

    public static void main(String[] args) {
        int [] t = {2};

        System.out.println(isMartian(t));
    }

   static int isMartian(int[] a) {

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < a.length-1; i++) {
            if (a[i] == 1) {
                count1++;
            } else if (a[i] == 2) {
                count2++;
            }

            if(a[i] == a[i+1]) {
                return 0;
            }
        }

       if (a[a.length-1] == 1) {
           count1++;
       } else if (a[a.length-1] == 2) {
           count2++;
       }

       if (count1 <= count2){
           return 0;
       }


        return 1;
    }
/*
Miu
2. Define an array to be a Martian array if the number of 1s is greater than the number of 2s and no two adjacent elements are equal.
Write a function named isMartian that returns 1 if its array argument is a Martian array, otherwise it returns 0.

There are two additional requirements.

You should return 0 as soon as it is known that the array is not a Martian array; continuing to analyze the array would be a waste of CPU cycles.

There should be exactly one for loop in your function

If you are programming in Java or C#, the function signature is
int isMartian(int[ ] a)

If you are programming in C or C++, the function signature is
int isMartian(int a[ ], int len) where len is the number of elements in the array a.

 */
}
