public class Solution1Q1{
    // assume ASCII char set [a-z]
    // use an int as a bit vector to store char a-z
    public boolean isUniqueChars(String str){
        if(str.length() > 26) return false;

        int checker = 0;
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i) - 'a';
            if((checker & (1 << val)) > 0 ){
                return false;
            }

            checker |= (1 << val);
        }
        
        return true;
    }

    // assume ASCII char set
    public boolean isUniqueChars2(String str){
        if(str.length() > 256) return false;

        boolean[] charSet = new boolean[256];
        for(int i = 0; i < str.length(); i++){
            int val = str.charAt(i);
            if(charSet[val]){ // already found this char in string
                return false;
            }

            charSet[val] = true;
        }

        return true;
    }
}
