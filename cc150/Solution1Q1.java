public class Solution1Q1{
    // assume ASCII char set [a-z]
    // use an int as a bit vector to store char a-z
    public boolean isUniqueChars(String str){
        if(str.length() > 26) return false;

        int checker = 0;
        for(int i = 0; i < str.length(); i++){
            int charIndex = str.charAt(i) - 'a';
            if((checker & (1 << charIndex)) > 0 ){
                return false;
            }

            checker |= (1 << charIndex);
        }
        
        return true;
    }

    // assume ASCII char set
    public boolean isUniqueChars2(String str){
        if (str.length() > 256) return false;
	
	boolean[] isFound = new boolean[256];
	for (int i = 0; i < str.length(); i++){
		if (isFound[str.charAt(i)]) return false;
		isFound[str.charAt(i)] = true;
	}
	
	return true;
    }
}
