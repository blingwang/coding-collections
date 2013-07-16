class Solution9Q3 {
    public static int magicFast(int[] array, int start, int end) {
        if (end < start || start < 0 || end >= array.length) {
            return - 1;
        }

        int mid = start + (end - start) / 2;
        if (array[mid] == mid) {
            return mid;
        } else if (array[mid] > mid) {
            return magicFast(array, start, mid - 1);
        } else {
            return magicFast(array, mid + 1, end);
        }
    }

    public static int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    public static int magicFastDup(int[] array, int start, int end) {
        if (end < start || start < 0 || end >= array.length) {
            return -1;
        }

        int midIndex = start + (end - start) / 2;
        int midValue = array[midIndex];
        if(midValue == midIndex) {
            return midIndex;
        }

        // search left
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicFast(array, start, leftIndex);
        if (left > 0) {
            return left;
        }

        // searach right
        int rightIndex = Math.max(midIndex + 1, midValue);
        int right = magicFast(array, rightIndex, end);

        return right;
    }

    public static int magicFastDup(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }
}
