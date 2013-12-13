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
    
    public boolean wordBreakSlow2(String s, Set<String> dict) {
        if (dict.contains(s)) return true;
        
        for (int i = 1; i < s.length(); i++) {
            if (wordBreak(s.substring(0, i), dict) && 
                wordBreak(s.substring(i), dict)) {
                return true;
            }
        }
        
        return false;
    }
    
    // memorization
    public boolean wordBreakWithCache(String s, Set<String> dict) {
        Map<String, Boolean> cache = new HashMap<String, Boolean>();
        return wordBreak(s, dict, cache);
    }
    public boolean wordBreak(String s, Set<String> dict, 
                             Map<String, Boolean> cache) {
        if (cache.containsKey(s)) return cache.get(s);
        if (dict.contains(s)) return true;
        
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            if (dict.contains(prefix)) {
                String suffix = s.substring(i);
                if (wordBreak(suffix, dict, cache)) return true;
            }
        }
        
        cache.put(s, false);
        return false;
    }
}
