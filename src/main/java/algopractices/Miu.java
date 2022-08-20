package algopractices;

public class Miu {

    public static void main(String args[]) {
//        int [] t = {1,2,3,1,0};
//        int [] t = {18};
        int [] t = {1,2,3,0,1,3};
        System.out.println(hasSingleMaximum(t));
    }


    static int hasSingleMaximum(int[] a) {
        int i;
        int max = a[0];
        for (i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }

        int maxCount = 0;
        for (i = 0; i < a.length; i++) {
            if (a[i] == max) {
                maxCount++;
            }
        }
        if(maxCount == 1){
            return 1;
        }
        return 0;

    }

    /*
    1 Write a function named hasSingleMaximum that takes an array argument and
     returns 1 if the maximum value in its array argument occurs exactly once in the array, otherwise it returns 0.

    If you are writing in Java or C#, the function signature is
    int hasSingleMaximum(int[ ] a)

    If you are writing in C or C++, the function signature is
    int hasSingleMaximum(int a[ ], int len) where len is the length of a
     */
}
