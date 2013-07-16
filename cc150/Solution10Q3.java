import java.util.*;
import java.io.*;
class Solution10Q5 {
    int bitsize = 524288; // range size: 2^19 bits (2^17 bytes)
    int blockNum = 4096; // array size: 2^12
    byte[] bitfield = new byte[bitsize/8]; // store a range with missing numbers
    int[] blocks = new int[blockNum]; // count of numbers in each range

    public void findOpenNumber() throws FileNotFoundException {
        // first pass: count numbers in each range
        Scanner in = new Scanner (new FileReader ("file.txt"));
        while (in.hasNextInt()) {
            int n = in.nextInt();
            blocks[n / bitsize]++;
        }

        // find the range with missing numbers
        int starting = -1;
        for (int i = 0; i < blocks.length; i++) {
            if (blocks[i] < bitsize) {
                starting = i * bitsize;
                break;
            }
        }

        // second pass: find all numbers in the range
        in = new Scanner(new FileReader("file.txt"));
        while (in.hasNextInt()) {
            int n = in.nextInt();
            if (n >= starting && n < starting + bitsize) {
                bitfield[(n-starting) / 8] |= 1 << ((n - starting) % 8);
            }
        }

        // scan the range to find the missing number
        for (int i = 0; i < bitfield.length; i++) {
            for (int j = 0; i < 8; j++) {
                if ((bitfield[i] &  (1 << j)) == 0) {
                    System.out.println(i*8 + j + starting);
                    return;
                }
            }
        }
    }
} 
