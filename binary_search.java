public class BinarySearch {

    /**
     * Performs binary search on a sorted array.
     *
     * @param arr The sorted array to search in.
     * @param target The value to search for.
     * @return The index of the target value if found, otherwise -1.
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            // Find the middle index
            int mid = left + (right - left) / 2;

            // If the target is found at the middle
            if (arr[mid] == target) {
                return mid;
            }

            // If the target is smaller than the middle element, search in the left half
            if (arr[mid] < target) {
                left = mid + 1;
            }
            // If the target is larger than the middle element, search in the right half
            else {
                right = mid - 1;
            }
        }

        // Target not found in the array
        return -1;
    }

    public static void main(String[] args) {
        int[] sortedArray = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int targetValue = 23;

        int index = binarySearch(sortedArray, targetValue);

        if (index != -1) {
            System.out.println("Target value " + targetValue + " found at index: " + index);
        } else {
            System.out.println("Target value " + targetValue + " not found in the array.");
        }

        targetValue = 40;
        index = binarySearch(sortedArray, targetValue);

        if (index != -1) {
            System.out.println("Target value " + targetValue + " found at index: " + index);
        } else {
            System.out.println("Target value " + targetValue + " not found in the array.");
        }
    }
}
