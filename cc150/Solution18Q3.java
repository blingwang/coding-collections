class Solution18Q2 {
    private int rand(int lower, int higher) {
        return lower + (int)(Math.random() * (higher - lower + 1));
    }

    public int[] reservoirSampling1(int[] original, int m) {
        int[] subset = new int[m];
        
        for (int i = 0; i < m; i++) {
            subset[i] = original[i];
        }

        for (int i = m; i < original.length; i++) {// shuffle rest
            int k = rand(0, i); 
            if (k < m) { // insert if in m range
                subset[k] = original[i];
            }
        }

        return subset;
    }
}
