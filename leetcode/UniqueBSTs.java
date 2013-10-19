public class UniqueBSTs {
    public int numTrees(int n) {
        int[] numBSTs = new int[n+1];
        numBSTs[0] = 1; // base case
        
        // select root, arrange n-1 nodes on left and right
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {// i-1 nodes left
                numBSTs[i] += numBSTs[j] * numBSTs[i-1-j];
            }
        }
        
        return numBSTs[n];
    }
}
