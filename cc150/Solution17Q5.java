class Solution17Q5 {
    private static final int MAX_COLORS = 4;
    private class Result {
        public int hits = 0;
        public int puseudoHits = 0;

        public String toString() {
            return "(" + hits + ", " + puseudoHits + ")";
        }
    }
    
    private int code(char c) {
       switch (c) {
           case 'B' : 
              return 0;
           case 'G' :
              return 1;
           case 'R' :
              return 2;
           case 'Y':
              return 3;
           default : 
             return -1;
       }
    } 

    public Result estimate(String guess, String solution) {
        if (guess.length() != solution.length()) return null;

        Result res = new Result();
        int[] unmatchedSol = new int[MAX_COLORS];
        int[] unmatchedGuess = new int[MAX_COLORS];

        // compute hits and build unmachted table
        for (int i = 0; i < guess.length(); i++) {
            if (guess.charAt(i) == solution.charAt(i)) {
                res.hits++;
            } else {
                int codeSol = code(solution.charAt(i));
                unmatchedSol[codeSol]++;
                int codeGuess = code(guess.charAt(i));
                unmatchedGuess[codeGuess]++;
            }
        }

        // compute pseudo-hits
        for (int i = 0; i < guess.length(); i++) {
            res.puseudoHits += Math.min(unmatchedSol[i], unmatchedGuess[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        final String solution = "RGBY";
        String guess = "GGRR";
        Solution17Q5 game = new Solution17Q5();
        Result res = game.estimate(guess, solution);
        System.out.println(res);
    }
}
