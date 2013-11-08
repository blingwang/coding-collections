class PermutationSequence {
    // print N! permutations of the characters of the string s in order
    public void permStr(String s) {
        permStr("", s);
    }

    private void permStr(String prefix, String s) {
        int N = s.length();
        if (N == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < N; i++) {
                permStr(prefix + s.charAt(i), s.substring(0, i) + s.substring(i+1, N));
            }
        }
    }
    
    public String getPermutation(int n, int k) {
        assert(n >= 1 && n <= 9);
        final String digits = "123456789";
        String s = digits.substring(0, n);
        k--; // convert to 0-based
        
        String permutation = "";
        int permsPerDigitChoice = factorial(n);
        for (int i = n; i > 0; i--) {
            permsPerDigitChoice /= i;
            int digitChoiceIndex = k / permsPerDigitChoice;
            permutation += s.charAt(digitChoiceIndex);
            
            s = s.substring(0, digitChoiceIndex) + s.substring(digitChoiceIndex+1);
            k %= permsPerDigitChoice;
        }
        
        return permutation;
    }
    
    private int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
