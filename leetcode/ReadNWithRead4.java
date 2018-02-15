/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int index = 0;
        char[] helperBuf = new char[4]; 
        while (index < n) {
            int numChars = read4(helperBuf);
            for (int i = 0; i < numChars && index < n; i++) {
                buf[index++] = helperBuf[i];
            }
            if (numChars < 4) break;
        }
        
        return index;
    }
}
