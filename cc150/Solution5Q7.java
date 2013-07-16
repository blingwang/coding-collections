import java.util.*;

class Solution5Q7 {
    private class BitInteger {
        public static final int INTEGER_SIZE = 32;
        int value;

        public BitInteger(int value) {
            this.value = value;
        }

        public int fetch(int i) {
            assert((i >= 0) && (i <= INTEGER_SIZE));
            return value & (1 << i);
        }
    }
    
    public int findMissing(ArrayList<BitInteger> array) {
        // start from the least significant bit, and work our way up
        return findMissing(array, 0);
    }

    public int findMissing(ArrayList<BitInteger> input, int column) {
        if (column >= BitInteger.INTEGER_SIZE) { // we're done
            return 0;
        }

        ArrayList<BitInteger> oneBits = new ArrayList<BitInteger>(input.size()/2);
        ArrayList<BitInteger> zeroBits = new ArrayList<BitInteger>(input.size()/2);

        for (BitInteger t : input) {
            if (t.fetch(column) == 0) {
                zeroBits.add(t);
            } else {
                oneBits.add(t);
            }
        }

        if (zeroBits.size() <= oneBits.size()) {
            int v = findMissing(zeroBits, column + 1);
            return (v << 1) | 0;
        } else {
            int v = findMissing(oneBits, column + 1);
            return (v << 1) | 1;
        }
    }
}
