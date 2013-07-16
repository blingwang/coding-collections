import java.util.*;
public class GenerateParentheses {
    private int N;
    private ArrayList<String> result;

    public ArrayList<String> generateParenthesis(int n) {
        N = n;
        result = new ArrayList<String>();

        char[] prefix = new char[N*2];        
        generateParenthesis(prefix, 0, 0);     

        return result;
    }

    private void generateParenthesis(char[] prefix, int leftCount, int rightCount) {
        if (leftCount < rightCount || leftCount > N) return;

        if (leftCount == N && rightCount == N) {
            result.add(new String(prefix));
            return;
        }

        int index = leftCount + rightCount;
        prefix[index] = '(';
        generateParenthesis(prefix, leftCount+1, rightCount);
        prefix[index] = ')';
        generateParenthesis(prefix, leftCount, rightCount+1);
    }
}
