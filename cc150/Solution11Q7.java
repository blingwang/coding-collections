import java.util.*;
class Solution11Q7 {
    public ArrayList<HtWt> getIncreasingSequence(ArrayList<HtWt> items) {
        Collections.sort(items);
        return longestIncreasingSubsequence(items);
    }

    private void longestIncreasingSubsequence(ArrayList<HtWt> array, 
                                ArrayList<HtWt>[] solutions, int currentIndex) {
        if (currentIndex >= array.size() || currentIndex < 0) return;
        HtWt curElem = array.get(currentIndex);

        // find longest sequence we can append curElem to
        ArrayList<HtWt> longest = null;
        for (int i = 0; i < currentIndex; i++) {
            if (array.get(i).isBefore(curElem)) {
                longest = seqWithMaxLength(longest, solutions[i]);
            }
        }

        // append curElem
        ArrayList<HtWt> newSolution = new ArrayList<HtWt>();
        if (longest != null) {
            newSolution.addAll(longest);
        }
        newSolution.add(curElem);

        // add to list and recurse
        solutions[currentIndex] = newSolution;
        longestIncreasingSubsequence(array, solutions, currentIndex+1);
    }

    private ArrayList<HtWt> longestIncreasingSubsequence(ArrayList<HtWt> array) {
        ArrayList<HtWt>[] solutions = new ArrayList[array.size()];
        longestIncreasingSubsequence(array, solutions, 0);

        ArrayList<HtWt> longest = null;
        for (int i = 0; i < array.size(); i++) {
            longest = seqWithMaxLength(longest, solutions[i]);
        }

        return longest;
    }

    private ArrayList<HtWt> seqWithMaxLength(ArrayList<HtWt> seq1, 
                                             ArrayList<HtWt> seq2) {
       if (seq1 == null) return seq2;
       if (seq2 == null) return seq1;
       return seq1.size() > seq2.size() ? seq1 : seq2;
    }

    private class HtWt implements Comparable {
        public int ht, wt;

        public int compareTo( Object s) {
            HtWt second = (HtWt)s;
            if (this.ht != second.ht) {
                return ((Integer)this.ht).compareTo(second.ht);
            } else {
                return ((Integer)this.wt).compareTo(second.wt);
            }
        }

        public boolean isBefore(HtWt other) {
            if (this.ht < other.ht && this.wt < other.wt) {
                return true;
            }

            return false;
        }
    }
}
