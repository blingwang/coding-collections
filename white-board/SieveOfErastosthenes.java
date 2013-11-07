class SieveOfErastosthenes {
    private static int [] generatePrimes(int max) {
        assert(max >= 2);
        boolean[] isComposite = new boolean[max + 1];
        
        for (int i = 2; i * i <= max; i++) {//sieve primes:2~sqrt(n)
            if (!isComposite [i]) {
                for (int j = i; i * j <= max; j++) {//candidates=i*j:i^2~max
                    isComposite [i*j] = true;
                }
            }
        }
        
        int numPrimes = 0;
        for (int i = 2; i <= max; i++) {
            if (!isComposite [i]) numPrimes++;
        }
        
        int [] primes = new int [numPrimes];
        int index = 0;
        for (int i = 2; i <= max; i++) {
            if (!isComposite [i]) primes [index++] = i;
        }
        
        return primes;
    }
}
