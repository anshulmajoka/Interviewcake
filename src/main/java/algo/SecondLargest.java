package algo;

public class SecondLargest {
    public int secondLargest(int[] arr) {
        int firstLargest = -1;
        int secondLargest = -1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > firstLargest) {
                firstLargest = arr[j];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != firstLargest) {
                if (arr[i] > secondLargest) {
                    secondLargest = arr[i];
                }
            }
        }

        return secondLargest;
    }
}
