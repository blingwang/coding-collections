import java.util.*;
public class SingleNumberII {
    public int singleNumber(int[] A) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        
        for (int num : A) {
            int count = counts.containsKey(num) ? counts.get(num) : 0;
            counts.put(num, count + 1);
        }
        
        for (int key : counts.keySet()) {
            if (counts.get(key) == 1) {
                return key;
            }
        }
        
        return 0;
    }
    
    public int singleNumber2(int[] A) {
        int[] bitCount = new int[32];
        
        for (int num : A) {
            for (int i = 0; i < 32; i++) {
                bitCount[i] += (num >> i) & 1;
            }
        }
        
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCount[i] % 3 != 0) {
                result |= (1 << i);
            }
        }
        
        return result;
    }
}
