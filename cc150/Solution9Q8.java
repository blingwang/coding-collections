class Solution9Q8 {
    private static enum Coin {
        Quarter(25), Dime(10), Nickel(5), Penny(1);
        
        private final int coinValue;
        
        Coin(int value) {
            coinValue = value;
        }
        
        public Coin getNext() {
            int next = ordinal()+1;
            if (next >= values().length) return null;
            return values()[ordinal()+1];
        }
        
        public int coinValue() {
            return coinValue;
        }
    }
    
    public int makeChange(int n) {
        return makeChange(n, Coin.Quarter);
    }
    
    private int makeChange(int n, Coin coin) {
        Coin next = coin.getNext();
        if (next == null) return 1;
        
        int ways = 0;
        int value = coin.coinValue();
        for (int i = 0; i * value <= n; i++) {
            ways += makeChange(n -i * value, next);
        }
        
        return ways;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.makeChange(2));
    }
    
    private int makeChange(int n, int denom) {
        int next_denom = 0;
        switch (denom) {
            case 25: 
                next_denom = 10;
                break;
            case 10:
                next_denom = 5;
                break;
            case 5:
                next_denom = 1;
                break;
            case 1:
                return 1;
        }

        int ways = 0;
        for (int i = 0; i * denom <= n; i++) {
            ways += makeChange(n - i * denom, next_denom);
        }

        return ways;
    }

    public int makeChange(int n) {
        return makeChange(n, 25);
    }
}
