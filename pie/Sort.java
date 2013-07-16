public class Sort{
    // sort an array using a recursive selection sort
    public static void selectionSortRecursive(int[] data){
        selectionSortRecursive(data, 0);
    }

    public static void selectionSortRecursive(int[] data, int start){
        if(start < data.length -1){
            swap(data, start, findMinimumIndex(data, start));
            selectionSortRecursive(data, start + 1);
        }
    }

    // find the position of the minimum value starting at the given index
    private static int findMinimumIndex(int[] data, int start){
        int minPos = start;

        for(int i = start + 1; i < data.length; ++i){
            if(data[i] < data[minPos]){
                minPos = i;
            }
        }

        return minPos;
    }

    // swap two elements in an array
    private static void swap(int[] data, int index1, int index2){
        if(index1 != index2){
            int tmp = data[index1];
            data[index1] = data[index2];
            data[index2] = tmp;
        }
    }

    // sort an array using a simple insertion sort
    public static void insertionSort(int[] data){
        for(int which = 1; which < data.length; ++which){
            int val = data[which];

            for(int i = 0; i < which; ++i){
                if(data[i] > val){
                    System.arraycopy(data, i, data, i+1, which -i);
                    data[i] = val;
                    break;
                }
            }
        }
    }

    // sort an array using a simple but inefficient merge sort
    public static int[] mergeSortSimple(int[] data){
        if(data.length < 2) return data;

        // split the array into two subarrays of approx equal size
        int mid = data.length / 2;
        int[] left = new int[mid];
        int[] right = new int[data.length - mid];

        System.arraycopy(data, 0, left, 0, left.length);
        System.arraycopy(data, mid, right, 0, right.length);

        // sort each subarray, then merge the result
        mergeSortSimple(left);
        mergeSortSimple(right);

        return merge(data, left, right);
    }

    // merge two smaller arrays into a larger array
    private static int[] merge (int[] dest, int[] left, int[] right){
        int dind = 0;
        int lind = 0;
        int rind = 0;

        // Merge arrays while there are elements in both
        while(lind < left.length && rind < right.length){
            if(left[lind] <= right [rind]){
                dest[dind++] = left[lind++];
            }else{
                dest[dind++] = right[rind++];
            }

        }

        // copy rest of whichever array remains
        while(lind < left.length)
            dest[dind++] = left[lind++];

        while(rind < right.length)
            dest[dind++] = right[rind++];

        return dest;
    }

    // sort an array using a stable selection sort
    public static void selectionSortStable(int[] data){
        for(int start = 0; start < data.length; ++start){
            insert(data, start, findMinimumIndex(data, start));
        }
    }

    // insert the data into the array, shifting the array as necessary
    private static void insert(int[] data, int start, int minIndex){
        if(minIndex > start){
            int tmp = data[minIndex];
            System.arraycopy(data, start, data, start+1, minIndex - start);
            data[start] = tmp;
        }
    }

    public static void selectionSortStableWithList(CursorableLinkedList data){
        CursonrableLinkedList.Cursor sortedBoundary = data.cursor(0);
        while(sortedBoundary.hasNext()){
            sortedBoundary.add(getMinimum(data, sortedBoundary.nextIndex()));
        }
    }

    // remove and return the first minimum-value element from data
    // with position greater than start
    private static Comparable getMinimum(CursorableLinkedList data, int start){
        cursorableLinkedList.Cursor unsorted = data.cursor(start);
        CursorableLinkedList.Cursor minPos = data.cursor(start + 1);
        Comparable minValue = (Comparable)minPos.previous();

        while(unsorted.hasNext()){
            if(((Comparable)unsorted.next()).compareTo(minValue) < 0){
                // advance minPos to new minimum value location
                while(minPos.nextIndex() < unsorted.nextIndex())
                    minValue = (Comparable)minPos.next();
            }
        }
        minPos.remove();
        minPos.close();
        unsorted.close();
        return minValue;
    }
    
    public static void quickSort(int[] data){
        quickSort(data, 0, data.length - 1);
    }

    public static void quickSort(int[] data, int left, int right){
        int pivotValue = data[(left + right) / 2];
        int i = left;
        int j = right;

        while (i <= j){
            // find leftmost value greater than or equal to the pivot
            while(data[i] < pivotValue) i++;

            // find rightmost value less than or equal to the pivot
            while(data[j] > pivotValue) j++;

            // if the values are in the wrong orde, swap them
            if(i <= j){
                swap(data, i, j);
                i++;
                j--;
            }
        }

        // apply the algorithm to the partitions we made, if any
        if(left < j){
            quickSort(data, left, j);
        }

        if(i < right){
            quickSort(data, i, right);
        }
    }

}
