class Solution10Q4 {
    public void checkDuplicates(int[] array) {
        BitSet bs = new BitSet(32000);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (bs.get(num-1)) {
                System.out.println(num);
            } else {
                bs.set(num-1);
            }
        }
    }

    class BitSet {
        int[] bitset;

        public BitSet(int size) {
            bitset = new int[size >> 5]; // divide by 32
        }

        public boolean get(int pos) {
            int wordNumber = (pos >> 5); // divide by 32
            int bitNumber = (pos & 0x1F); // mod 32
            return (bitset[wordNumber] & (1 << bitNumber)) != 0;
        }

        public void set(int pos) {
            int wordNumber = (pos >> 5); 
            int bitNumber = (pos & 0x1F);
            bitset[wordNumber] |= 1 << bitNumber;
        }
    }
}
