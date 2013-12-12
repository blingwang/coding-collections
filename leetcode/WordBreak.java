public class WordBreak {
    public boolean wordBreakSlow(String s, Set<String> dict) {
        if (dict.contains(s)) return true;
        
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = s.substring(i);
                if (wordBreak(suffix, dict)) return true;
            }
        }
        
        return false;
    }
}
