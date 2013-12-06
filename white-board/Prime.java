import java.util.*;
class Prime {
    /******Sieve of Eratosthenes*****/
    public static int [] generatePrimes(int max) {
        assert(max >= 2);
        boolean[] isComposite = new boolean[max + 1];
        // sieve
        for (int i = 2; i * i <= max; i++) {//sieve primes:2~sqrt(max)
            if (!isComposite [i]) {
                for (int j = i; i * j <= max; j++) {//candidates=i*j:i^2~max
                    isComposite [i*j] = true;
                }
            }
        }
        // count primes
        int numPrimes = 0;
        for (int i = 2; i <= max; i++) {
            if (!isComposite [i]) numPrimes++;
        }
        // get primes
        int [] primes = new int [numPrimes];
        int index = 0;
        for (int i = 2; i <= max; i++) {
            if (!isComposite [i]) primes [index++] = i;
        }
        
        return primes;
    }
    
    // prime checker
    public static boolean isPrime(int n) {
    	if (n < 2) return false;
    	if (n == 2) return true;

    	for (int i = 2; i * i <= n; i++) {
    	    if (n % i == 0) return false;
    	}
    
    	return true;
    }

    // naive method, for more advanced algorithms, see:
    // http://en.wikipedia.org/wiki/Integer_factorization
    public static ArrayList<Integer> findFactors(int n) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
               factors.add(i);
               n = n / i;
               i--;
            }
        }
        return factors;
    }
    
    public static ArrayList<Integer> findFactors2(int n) {
        ArrayList<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
               factors.add(i);
               n = n / i;
            }
        }
        
        if (n > 2) factors.add(n); // only one factor > sqrt(n)
        
        return factors;
    }

    //  based on the fact that beyond 2 and 3, all the prime numbers 
    //  are of the form 6n-1 or 6n+1
    public static int largestPrimeFactor(int n) {
        int largestFactor = 1;

        if (n % 2 == 0) {
            largestFactor = 2;
            while (n % 2 == 0) n /= 2;
        }

        if (n % 3 == 0) {
            largestFactor = 3;
            while (n % 3 == 0) n /= 3;
        }

        for (int i = 6; i - 1 <= n; i += 6) {
            if (n % (i-1) == 0) {
                largestFactor = i - 1;
                while (n % (i-1) == 0) n /= i-1;
            }
            if (n % (i+1) == 0) {
                largestFactor = i + 1;
                while (n % (i+1) == 0) n /= i+1;
            }
        }

        return largestFactor;
    }

    public static void main(String[] args) {
        for (int i : findFactors(100)) {
            System.out.print(i);
        }
        
        System.out.println();
        System.out.println(largestPrimeFactor(712));
    }
}
