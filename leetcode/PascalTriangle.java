import java.util.*;
public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) return result;
        
        ArrayList<Integer> row0 = new ArrayList<Integer>();
        row0.add(1);
        result.add(row0);
        
        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> preRow = result.get(i-1);
            ArrayList<Integer> curRow = new ArrayList<Integer>();
            curRow.add(1);
            
            for (int j = 1; j < i; j++) {
                curRow.add(preRow.get(j-1) + preRow.get(j));
            }
            
            curRow.add(1);
            result.add(curRow);
        }
        
        return result;
    }
}
