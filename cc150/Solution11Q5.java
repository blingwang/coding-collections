class Solution11Q5 {
    public int search(String[] strings, String str, int first, int last) {
        int mid = findNonEmptyMid(strings, first, last);
        if (mid < 0) return -1;

        if (str.equals(strings[mid])) {
            return mid;
        }

        if (str.compareTo(strings[mid]) < 0) {
            return search(strings, str, first, mid - 1);
        }

        if (str.compareTo(strings[mid]) > 0) {
            return search(strings, str, mid + 1, last);
        }

        return -1;
    }
    
    private static int findNonEmptyMid(String[] strings, int first, int last) {
        if (first > last) return -1;

        int mid = first + (last - first) / 2;
        // If mid is empty, find closest non-empty string
        if (strings[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            
            while (true) {
                if (left < first && right > last) {
                    mid = -1;
                    break;
                }

                if (left >= first && !strings[left].isEmpty()) {
                    mid = left;
                    break;
                }

                if (right <= last && !strings[right].isEmpty()) {
                    mid = right;
                    break;
                }

                right++;
                left--;
            }
        }

        return mid;
    }

    public int search(String[] strings, String str) {
       if (strings == null || str == null || str == "") {
          return -1;
       }
       
       return search(strings, str, 0, strings.length - 1);
    }
} 
