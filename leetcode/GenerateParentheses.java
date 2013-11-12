import java.util.*;
public class GenerateParentheses {
    private int n;
    private ArrayList<String> result;
    
    public ArrayList<String> generateParenthesis(int n) {
        this.n = n;
        result = new ArrayList<String>();
        
        char[] prefix = new char[n*2];
        generate(0, 0, prefix);
        
        return result;
    }
    
    private void generate(int leftCount, int rightCount, char[] prefix) {
        if (leftCount < rightCount || leftCount > n) return;
        
        int curIndex = leftCount + rightCount;
        if (curIndex == n * 2) {
            result.add(new String(prefix));
            return;
        }
        
        prefix[curIndex] = '(';
        generate(leftCount+1, rightCount, prefix);
        prefix[curIndex] = ')';
        generate(leftCount, rightCount+1, prefix);
    }
}
