import java.util.Arrays; // Only allowed import

public class RecursiveExercises {

    /**
     * Part 1: Recursively finds the maximum value in a subarray from arr[left] to arr[right].
     */
    public static int findMax(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = (left + right) / 2;
        int maxLeft = findMax(arr, left, mid);
        int maxRight = findMax(arr, mid + 1, right);
        return (maxLeft > maxRight) ? maxLeft : maxRight;
    }

    /**
     * Part 2: Recursively reverses the array in-place from index left to right.
     */
    public static void reverseArray(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        // Swap elements
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        // Recurse inward
        reverseArray(arr, left + 1, right - 1);
    }

    /**
     * Part 3: Recursively counts occurrences of target in arr starting from index.
     */
    public static int countOccurrences(int[] arr, int target, int index) {
        if (index >= arr.length) {
            return 0;
        }
        if (arr[index] == target) {
            return 1 + countOccurrences(arr, target, index + 1);
        } else {
            return countOccurrences(arr, target, index + 1);
        }
    }

    /**
     * Part 4: Recursively performs binary search on a sorted array.
     */
    public static int binarySearch(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // target not found
        }
        int mid = (left + right) / 2;

        if (arr[mid] == target) {
            return mid;
        } else if (target < arr[mid]) {
            return binarySearch(arr, target, left, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, right);
        }
    }

    /**
     * Main method to demonstrate all parts of the assignment with test cases.
     */
    public static void main(String[] args) {
        // Part 1: Find Max
        int[] array1 = {4, 7, 2, 9, 1, 10};
        int max = findMax(array1, 0, array1.length - 1);
        System.out.println("Max value: " + max); // Expected: 10

        // Part 2: Reverse Array
        int[] array2 = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + Arrays.toString(array2));
        reverseArray(array2, 0, array2.length - 1);
        System.out.println("Reversed array: " + Arrays.toString(array2)); // Expected: [5, 4, 3, 2, 1]

        // Part 3: Count Occurrences
        int[] array3 = {1, 2, 3, 2, 4, 2, 5};
        int count = countOccurrences(array3, 2, 0);
        System.out.println("Occurrences of 2: " + count); // Expected: 3

        // Part 4: Binary Search
        int[] array4 = {1, 3, 5, 7, 9, 11, 13};
        int index = binarySearch(array4, 7, 0, array4.length - 1);
        System.out.println("Index of 7: " + index); // Expected: 3
        int notFound = binarySearch(array4, 8, 0, array4.length - 1);
        System.out.println("Index of 8: " + notFound); // Expected: -1
    }
}
