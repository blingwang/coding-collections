public class Solution1Q3{
    // assume comparsion is case sensitive and whitespace is significant

    // solution 1 using sorted string
    public String sort(String s){
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()){
            return false;
        }

        return sort(s).equals(sort(t));
    }

    // solution 2
    public boolean isAnagram2(String s, String t){
        if (s.length() != t.length()) {
		return false;
	}
	
	int[] charCount = new int[256];
	
	for (int i = 0; i < s.length(); i++) {
		charCount[s.charAt(i)]++;
	}
	
	for (int i = 0; i < t.length(); i++) {
		charCount[t.charAt(i)]--; // consume chars in s
		if (charCount[t.charAt(i)] < 0) {
			return false;
		}
	}
	return true;
    }
}

