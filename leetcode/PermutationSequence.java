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
        assert(n >0 && n <=9);
        final String digits= "123456789";
        String s = digits.substring(0, n);

        int NFact = 1;
        for (int i = 1; i <= n; i++) {
            NFact *= i;
        }
        assert(k > 0 && k <= NFact);

        // kth permutation will be at k-1 index in permutations array
        k--;

        int permsPerDigitChoice = NFact; 
        String prefix = "";
        // set digit at each position of permutation sequence
        for (int i = n; i > 0; i--) {
            permsPerDigitChoice /= i;
            int digitChoiceIndex = k / permsPerDigitChoice;
            prefix += s.charAt(digitChoiceIndex);
            s = s.substring(0,digitChoiceIndex) + s.substring(digitChoiceIndex+1);
            k %= permsPerDigitChoice;
        }

        return prefix;
    }   
}
