import java.util.*;
public class GrayCode {
    public ArrayList<Integer> grayCode2(int n) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        int count = 1 << n;
        
        for (int i = 0; i < count; i++) {
            numList.add(i ^ (i>>1));
        }
        
        return numList;
    }

    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        numList.add(0);
        
        for (int i = 0; i < n; i++) {
            for (int j = numList.size()-1; j >= 0; j--) {
                numList.add(numList.get(j) | (1<<i));
            }
        }
        
        return numList;
    }
}
