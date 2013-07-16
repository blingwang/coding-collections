import java.util.*;
class Solution9Q6 {
    private void addParen(ArrayList<String> list, int leftRem,
                          int rightRem, char[] str, int count) {
        // make sure left paren comes before right
        if (leftRem < 0 || rightRem < leftRem) {// invalid state
            return; 
        }

        if (leftRem == 0 && rightRem == 0) {
            String s = String.copyValueOf(str);
            list.add(s);
        } else {// add one more char to str
            // we can alwasy add left paren if there are any remaining 
            if (leftRem > 0) {
                str[count] = '(';
                addParen(list, leftRem - 1, rightRem, str, count + 1);
            }

            // if there is any unmatched left paren, we can add a right one
            if (rightRem > leftRem) {
                str[count] = ')';
                addParen(list, leftRem, rightRem - 1, str, count + 1);
            }
        }
    }

    public ArrayList<String> generateParens(int count) {
        char[] str = new char[count * 2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list, count, count, str, 0);
        return list;
    }
}
