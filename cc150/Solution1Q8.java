public class Solution1Q8{
    public boolean isRotation(String s1, String s2){
        String s1s1 = s1 + s1;
        return s1.length() == s2.length() && !s1.isEmpty() && isSubstring(s1s1, s2);
    }
}
