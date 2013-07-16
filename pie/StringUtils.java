import java.util.*;
class StringUtils{
    public static Character firstNonRepeated(String str){
        HashMap<Character, Integer> charHash = new HashMap<Character, Integer>();
        int i, length;
        Character c;

        length = str.length();
        // scan str, building hash table
        for (i = 0; i < length; i++){
            c = str.charAt(i);
            if (charHash.containsKey(c)){
                // increment count corresponding to c
                charHash.put(c, charHash.get(c) + 1);
            } else {
                charHash.put(c, 1);
            }
        }

        // search hash table in order of str
        for (i = 0; i < length; i++) {
            c = str.charAt(i);
            if (charHash.get(c) == 1)
                return c;
        }

        return null;
    }

    // revised firstNonRepeated
    public static String firstNonRepeatedUnicode(String str){
        HashMap<Integer, Object> charHash = new HashMap<Integer, Object>();
        Object seenOnce = new Object(), seenMultiple = new Object();
        Object seen;
        int i;
        final int length = str.length();

        // scan str, building hash table
        for(i = 0; i < length; ){
            final int cp = str.codePointAt(i);
            i += Character.charCount(cp); // increment based on code point
            seen = charHash.get(cp);
            if (seen == null) { // not present
                charHash.put(cp, seenOnce);
            } else {
                if (seen == seenOnce) {
                    charHash.put(cp, seenMultiple);
                }
            }
        }
        // search hash table in order of str
        for (i = 0; i < length; ) {
            final int cp = str.codePointAt(i);
            i += Character.charCount(cp);
            if (charHash.get(cp) == seenOnce) {
                return new String(Character.toChars(cp));
            }
        }

        return null;
    }

    public static String removeChars( String str, String remove ){
        char[] s = str.toCharArray();
        char[] r= remove.toCharArray();
        int src, dst = 0;

        // flags automatically initialized to false, size of 128 assumes ASCII
        boolean[] flags = new boolean[128];

        // set flags for characters to be removed
        for( src = 0; src < r.length; ++src ){
            flags[r[src]] = true;
        }

        // Now loops through all the characters
        // copying only if they aren't flagged
        for( src = 0; src < s.length; ++src ) {
            if( !flags[s[src]]){
                s[dst++] = s[src];
            }
        }
        
        return new String(s, 0, dst);
    }

    public static int strToInt( String str ){
        int i = 0, num = 0;
        boolean isNeg = false;
        int len = str.length();

        if( str.charAt(0) == '-' ){
            isNeg = true;
            i = 1;
        }

        while ( i < len ) {
            num *= 10;
            num += ( str.charAt(i) - '0' );
        }

        if(isNeg)
            num = -num;
        return num;
    }

    public static final int MAX_DIGITS = 10;
    public static String intToStr( int num ){
        int i = 0;
        boolean isNeg = false;

        // buffer big enough for largest int and - sign
        char[] temp = new char[ MAX_DIGITS + 1 ];
        //check to see if the number is negative
        if( num < 0 ) {
            num = - num;
            isNeg = true;
        }

        // fill buffer with digit characters in reverse order
        do {
            temp[i++] = (char)((num % 10) + '0' );
            num /= 10;
        }while( num != 0 );

        StringBuilder b = new StringBuilder();
        if ( isNeg )
            b.append( '-' );

        while (i > 0){
            b.append( temp[--i]);
        }

        return b.toString();
    }

}
