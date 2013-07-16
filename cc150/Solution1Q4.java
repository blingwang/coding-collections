public class Solution1Q4{
    // length is true length of the string array
    public void replaceSpaces(char[] str, int length){
        int spaceCount = 0, newLength, i = 0;
        for(i = 0; i < length; i++){
            if(str[i] == ' ' ){
                spaceCount++;
            }
        }

        newLength = length + spaceCount * 2;

        int curWrtPos = newLength;
        str[curWrtPos--] = '\0';

        for(i = length - 1; i >= 0; i--){
            if(str[i] == ' '){
                str[curWrtPos--] = '0';
                str[curWrtPos--] = '2';
                str[curWrtPos--] = '%';
            }else{
                str[curWrtPos--] = str[i];
            }
        }
    }
}
