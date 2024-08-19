public class Main {
    public static void main(String[] args) {

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

        // The leftArray will contain values [0, middle]
        int[] leftArray = new int[middle + 1];

        // The rightArray will contain values [middle + 1, array.length - 1]
        // Length = The amount of space remaining that is not being used by leftArray.
        int[] rightArray = new int[array.length - leftArray.length];

        // Clone all values from the original array into the subarrays.
        // j counts the current index in rightArray.
        // i counts the current index in leftArray and the original array.
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            // First, fill the left array.
            if (i <= middle) {
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
        merge(array, leftArray, rightArray);
    }

}
