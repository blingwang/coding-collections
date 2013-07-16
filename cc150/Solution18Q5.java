import java.util.*;
class Solution18Q5 {
    private HashMap<String, ArrayList<Integer>> indexTable;

    public Solution18Q5(String[] words) {
        buildIndexTable(words);
    }

    public int shortestWordDistance(String[] words, String word1, String word2) {
        int minDistance = Integer.MAX_VALUE;
        int lastWord1 = -1;
        int lastWord2 = -1;

        for (int i = 0; i < words.length; i++) {
            String current = words[i];

            if (current.equals(word1)) {
                lastWord1 = i;
                // comment following 3 lines if word order matters
                int distance = lastWord1 - lastWord2;
                if (lastWord2 >= 0 && minDistance > distance) {
                    minDistance = distance;
                }
            } else if (current.equals(word2)) {
                lastWord2 = i;
                int distance = lastWord2 - lastWord1;
                if (lastWord1 >= 0 && minDistance > distance) {
                    minDistance = distance;
                }
            }
        }

        return minDistance;
    }

    private void buildIndexTable(String[] words) {
        indexTable = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < words.length; i++) {
            if (!indexTable.containsKey(words[i])) {
                ArrayList<Integer> indexList = new ArrayList<Integer>();
                indexTable.put(words[i], indexList);
            }
            ArrayList<Integer> indexList = indexTable.get(words[i]);
            indexList.add(i);
        }
    }

    public int findWordDistanceFast(String[] words, String word1, String word2){
        if (!indexTable.containsKey(word1) || !indexTable.containsKey(word2)) {
            return Integer.MAX_VALUE;
        }

        ArrayList<Integer> indexList1 = indexTable.get(word1);
        ArrayList<Integer> indexList2 = indexTable.get(word2);
        int minDistance = mergeAndComputeDistance(indexList1, indexList2);
        return minDistance;
    }

    private enum Previous {NONE, LIST1, LIST2}
    private static int mergeAndComputeDistance(ArrayList<Integer> list1, 
                                        ArrayList<Integer> list2) {
        if (list1 == null || list2 == null) {
            return Integer.MAX_VALUE;
        }

        int minDistance = Integer.MAX_VALUE;
        int distance;
        Previous pre = Previous.NONE;
        int length = list1.size() + list2.size();
        int i = 0;
        int j = 0;

        for(int k = 0; k < length; k++) {
            if (i == list1.size()) { // list1 ends, take from list2
                if (pre == Previous.LIST1) {
                    distance = list2.get(j) - list1.get(i-1);
                    if (minDistance > distance) {
                        minDistance = distance;
                    }
                }
                return minDistance; // no need to check rest of list2
            } else if (j == list2.size()) { // list2 ends, take from list1
                if (pre == Previous.LIST2) {
                    distance = list1.get(i) - list2.get(j-1);
                    if (minDistance > distance) {
                        minDistance = distance;
                    }
                }
                return minDistance; // no need to check rest of list1
            } else if (list1.get(i) > list2.get(j)) { // take element from list2
                if (pre == Previous.LIST1) {
                    distance = list2.get(j) - list1.get(i-1);
                    if (minDistance > distance) {
                        minDistance = distance;
                    }
                }
                pre = Previous.LIST2;
                j++;
            } else { // take element from list1
                if (pre == Previous.LIST2) {
                    distance = list1.get(i) - list2.get(j-1);
                    if (minDistance > distance) {
                        minDistance = distance;
                    }
                }
                pre = Previous.LIST1;
                i++;
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.asList(1,2,9,15,25));
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(4,10,19));
        
        System.out.println(mergeAndComputeDistance(list1, list2));
    }
        
}
