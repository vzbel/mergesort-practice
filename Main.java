import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[59812];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(402);
        }
        System.out.println(Arrays.toString(mergeSort(arr)));
    }

    public static int[] mergeSort(int[] array) {
        // We will stop dividing the array into subarrays when it has a size of one.
        // (Or if it is empty)
        if (array.length <= 1) {
            return array;
        }

        // Divide the array into two sub arrays.
        // Calculate the middle of the array.
        int middle = array.length / 2;

        // The leftArray will contain values [0, middle - 1]
        int[] leftArray = new int[middle];

        // The rightArray will contain values [middle, array.length - 1]
        // Length = The amount of space remaining that is not being used by leftArray.
        int[] rightArray = new int[array.length - middle];

        // Clone all values from the original array into the subarrays.
        // j counts the current index in rightArray.
        // i counts the current index in leftArray and the original array.
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            // First, fill the left array.
            if (i < middle) {
                leftArray[i] = array[i];
            } else { // Then, fill the right array.
                rightArray[j] = array[i];
                j++;
            }
        }

        // Repeat the process to break down and merge the left subtree.
        mergeSort(leftArray);
        // Repeat the process to break down and merge the right subtree.
        mergeSort(rightArray);
        // Merge each array pair.
        return merge(array, leftArray, rightArray);
    }

    // Merge two arrays
    public static int[] merge(int[] array, int[] leftArray, int[] rightArray) {
        // Keep counters for each array's current position.
        int i = 0; // array
        int l = 0; // leftArray
        int r = 0; // rightArray

        // Merge until left or right array is fully copied into the original array.
        // Each time, compare values to see which moves first.
        // Then, increment counters to proceed.
        while ((l < leftArray.length) && (r < rightArray.length)) {
            // Check if the left value is lesser, in which case it must go first.
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else { // Otherwise the right value is lesser or equal to l.
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }

        // Once the previous loop has terminated, one array can still contain values.
        // We must transfer them as well.
        while (l < leftArray.length) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightArray.length) {
            array[i] = rightArray[r];
            i++;
            r++;
        }

        // Return the merged array
        return array;
    }
}
