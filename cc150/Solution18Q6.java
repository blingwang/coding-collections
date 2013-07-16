class Solution18Q6 {
    private void swap(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[left];
        int i = left + 1;
        int j = right;

        while (true) {
            while (array[i] <= pivot) {// this may lead to O(n^2) for all dup keys
                if (i == right) break;
                i++;
            }

            while (array[i] > pivot) {
                if (j == left) break;
                j--;
            }

            if (i >= j) break;

            swap(array, i, j);
        }

        swap(array, left, j);
        return j;
    }

    public int rank(int[] array, int rank) {
        // TODO shuffle array
        rank--; // kth element is at index k-1

        int left = 0; 
        int right = array.length - 1;

        while (left < right) {
            int pivotIndex = partition(array, left, right);

            if (pivotIndex == rank) {
                return array[rank];
            } else if (pivotIndex > rank) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
        return array[rank];
    }
}
