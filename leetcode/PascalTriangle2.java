import java.util.*;
public class PascalTriangle2 {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(1);
        
        for (int i = 1; i <= rowIndex; i++) {
            row.add(1);
            for (int j = i - 1; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j-1));
            }
        }
        
        return row;
    }
}
