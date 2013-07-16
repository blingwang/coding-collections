class BinarySearch{
    public static int binarySearch(int[] array, int target) throws BSException {
        return binarySearch(array, target, 0, array.length - 1);
    }

    public static int binarySearch(int[] array, int target, int lower, int upper) throws BSException {
        int center, range,

        range = upper - lower;
        if(range < 0) {
            throw new BSException("Limits reversed");
        }else if(range == 0 && array[lower] != target){
            throw new BSException("Element not in array");
        }
        if(array[lower] > array[upper]){
            throw new BSException("Array not sorted");
        }
        center = (range/2) + lower;
        if(target == array[center]){
            return center;
        }else if (target < array[center]){
            return binarySearch(array, target, lower, center - 1);
        }else{
            return binarySearch(array, target, center + 1, upper);
        }
    }

    public static int iterBinarySearch(int[] array, int target) throws BSException {
        int lower = 0, upper = array.length - 1;
        int center, range;

        if(lower > upper){
            throw new BSException("Limits reversed");
        }

        while(true){
            range = upper - lower;
            if(range == 0 && array[lower] != target){
                throw new BSException("Element not in array");
            }
            if(array[lower] > array[upper]){
                throw new BSException("Array not sorted");
            }

            center = (range/2) + lower;
            if(target == array[center]){
                return center;
            }else if (target < array[center]){
                upper = center - 1;
            }else{
                lower = center + 1;
            }
        }
    }
}
