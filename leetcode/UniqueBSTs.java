public class UniqueBSTs {
    public int numTrees(int n) {
        assert(n >= 0);
        int[] numBSTs = new int[n+1];
        numBSTs[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                numBSTs[i] += numBSTs[j-1] * numBSTs[i-j];
            }
        }
        return numBSTs[n];
    }
}
