class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        String longest = "";
        Set<String> builtable = new HashSet<>();
        
        for (String w : words) {
            String prefix = w.substring(0, w.length() - 1);
            if (w.length() == 1 || builtable.contains(prefix)) {
                if (w.length() > longest.length()) longest = w;
                builtable.add(w);
            }
        }
        
        return longest;
    }
}
