class Solution18Q2 {
    private int rand(int lower, int higher) {
        return lower + (int)(Math.random() * (higher - lower + 1));
    }

    public int[] reservoirSampling1(int[] original, int m) {
        int[] subset = new int[m];
        
        // fill in subset array with first part of original array
        for (int i = 0; i < m; i++) {
            subset[i] = original[i];
        }

        // shuffle rest of original array (insert into previous shuffled)
        for (int i = m; i < original.length; i++) {
            int k = rand(0, i); 
            if (k < m) { // swap if in m range, always keep original array
                subset[k] = original[i];
            }
        }

        return subset;
    }
}
