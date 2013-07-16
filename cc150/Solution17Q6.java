class Solution17Q6 {
    public static void findUnsortedSequence(int[] array) {
        // find left subsequence
        int end_left = findEndOfLeftSubsequence(array);
        if (end_left == array.length - 1) { // all sorted, no middle
            return;
        }

        // find right subsequence
        int start_right = findStartOfRightSubsequence(array);

        // find min and max of middle: [end_left, start_right]
        // including end_left and start_right to make sure 
        // array[end_left] < array[start_right]
        int min_index = end_left;
        int max_index = end_left;
        for (int i = end_left; i <= start_right; i++) {
            if (array[i] < array[min_index]) min_index = i;
            if (array[i] > array[max_index]) max_index = i;
        }

        // slide left until equal or less than array[min_index]
        int left_index = shrinkLeft(array, min_index, end_left);

        // slide right until euqal or greater than array[max_index]
        int right_index = shrinkRight(array, max_index, start_right);

        System.out.println(left_index + " " + right_index);
    }

    private static int findEndOfLeftSubsequence(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return i;
            }
        }
        return array.length - 1;
    }

    private static int findStartOfRightSubsequence(int[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] < array[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    private static int shrinkLeft(int[] array, int min_index, int start) {
        int comp = array[min_index];
        for (int i = start; i >= 0; i--) {
            if (array[i] <= comp) return i + 1;
        }
        return 0;
    }

    private static int shrinkRight(int[] array, int max_index, int start) {
        int comp = array[max_index];
        for (int i = start; i < array.length; i++) {
            if (array[i] >= comp) return i - 1;
        }

        return array.length - 1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        findUnsortedSequence(array);
        int[] array2 = {1, 2, 3, 17, 4, 5, 10, 12, 13};
        findUnsortedSequence(array2);
    }
}

