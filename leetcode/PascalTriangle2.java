import java.util.*;
public class PascalTriangle2 {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>(rowIndex+1);
        result.add(1);
        
        for (int row = 1; row <= rowIndex; row++) {
            result.add(1);
            for (int i = row-1; i > 0; i--) {
                result.set(i, result.get(i-1) + result.get(i));
            }
        }
        
        return result;
    }
}
