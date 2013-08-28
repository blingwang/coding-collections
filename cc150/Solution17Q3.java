class Solution17Q3 {
    public int countFactZeros(int num) {
        if (num < 0) { // negative
            return -1;
        }

        int count = 0;
        for (int i = 5; num / i > 0; i *= 5) {
            count += num / i;
        }

        return count;
    }
    
    private int factorsOf5(int i) {
        assert (i > 0);
        int count = 0;
        while (i % 5 == 0) {// 0?
            count++;
            i /= 5;
        }

        return count;
    }
}
