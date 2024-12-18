public class pb2 {

    public static int CountShifts(int[] arr) {
        int n = arr.length;
        int totalShifts = 0; // track the total number of shifts

        // Iterate over the array
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Current element inserted
            int j = i - 1;

            // Count of shifts
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Shift right
                j--;
                totalShifts++; // Increment shift counter
            }

            // Insert key correct position
            arr[j + 1] = key;
        }

        return totalShifts;
    }

    //print the array
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Input array
        int[] arr = {2, 1, 3, 1, 2};

        System.out.println("Original Array:");
        printArray(arr);

        // insertion sort and count shifts
        int totalShifts = CountShifts(arr);

        System.out.println("Sorted Array:");
        printArray(arr);

        System.out.println("Total Shifts: " + totalShifts);
    }
}
