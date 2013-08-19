public class Solution1Q5{
    /*solution 1*/
    public String compressStr(String str) {
        if (str.length() <= 2) {
            return str;
        }
        
        StringBuffer compressed = new StringBuffer();
        char pre = str.charAt(0);
        int count = 1;
        
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == pre) {
                count++;
            } else {
                compressed.append(pre);
                compressed.append(count);
                pre = str.charAt(i);
                count = 1;             
            }
        }
        
        compressed.append(pre);
        compressed.append(count);
        
        return (str.length() <= compressed.length()) ? str : compressed.toString();
    }
    
    /*solution 2*/
    public String compress(String str){
        // check if compression would create a longer string
        int size = countCompression(str);
        if(size >= str.length()){
            return str;
        }

        StringBuffer mystr = new StringBuffer();
        char last = str.charAt(0);
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == last){ // found repeated char
                count++;
            }else{ // insert char count, and update last char
                mystr.append(last);
                mystr.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }

        // insert last set of repeated characters
        mystr.append(last);
        mystr.append(count);
        return mystr.toString();
    }

    private int countCompression(String str){
        char last = str.charAt(0);
        int size = 0;
        int count = 1;

        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == last){
                count++;
            }else{
                last = str.charAt(i);
                size = 1 + String.valueOf(count).length();
                count = 0;
            }
        }

        size += 1 + String.valueOf(count).length();
        return size;
    }
    
    /*solution 3*/
    public String compressAlternate(String str){
        int size = countCompression(str);
        if(size >= str.length()){
            return str;
        }

        char[] array = new char[size];
        int index = 0;
        char last = str.charAt(0);
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == last){
                count++;
            }else{
                index = setChar(str, array, last, index, count);
                last = str.charAt(i);
                count = 1;
            }
        }
        
        index = setChar(str, array, last, index, count);
        return String.valueOf(array);
    }

    int setChar(String str, char[] array, char c, int index, int count){
        array[index++] = c;
        char[] cnt = String.valueOf(count).toCharArray();

        for(char x : cnt){
            array[index++] = x;
        }
        return index;
    }
}



