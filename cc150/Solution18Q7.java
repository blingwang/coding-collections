import java.util.*;
class Solution18Q7 {
    private class LengthComparator implements Comparator<String> {
        public int compare(String a, String b) {
            int lengthA = a.length();
            int lengthB = b.length();
            if (lengthA < lengthB) {
                return -1;
            } else if (lengthA > lengthB) {
                return 1;
            } else {
                return 0;
            }
        }
    }

    public String printLongestWord(String arr[]) {
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        for (String str : arr) {
            map.put(str, true);
        }

        Arrays.sort(arr, new LengthComparator());
        for (String s : arr) {
            if (canBuildWord(s, true, map)) {
                System.out.println(s);
                return s;
            }
        }
        return null;
    }

    private boolean canBuildWord(String str, boolean isOriginalWord,
                                 HashMap<String, Boolean> map) {
        if (map.containsKey(str) && !isOriginalWord) {
            return map.get(str);
        }

        for (int i = 1; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i);

            if (map.containsKey(left) && map.get(left) == true &&
                canBuildWord(right, false, map)) {
                // we can also cache true str
                return true;
            }
        }
        
        map.put(str, false);
        return false;
    }
}
