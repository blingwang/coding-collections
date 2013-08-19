public class Solution1Q4{
    // length is true length of the string array
    public void replaceSpaces(char[] str, int length){
        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        
        int newLength = length + spaceCount * 2;
        assert str.length >= newLength;
        
        int writeIndex = newLength;
        str[writeIndex--] = '\0';  
        for (int i = length - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[writeIndex--] = '%';
                str[writeIndex--] = '0';
                str[writeIndex--] = '2';
            } else {
                str[writeIndex--] = str[i];
            }
        }
    }
}
