import java.util.*;
class Solution9Q11 {
    public int fDP(String exp, boolean result, int s, int e, 
            HashMap<String, Integer> q) {
        String key = "" + result + s + e;
        if (q.containsKey(key)) {
            return q.get(key);
        }

        if (s == e) { // start=end, single char
            if (exp.charAt(s) == '1' && result == true) {
                return 1;
            } else if (exp.charAt(s) == '0' && result == false) {
                return 1;
            }
            return 0;
        }

        int c = 0;
        if (result) {
            for (int i = s + 1; i <=e; i += 2) {
                char op = exp.charAt(i);
                if (op == '&') {
                    c += fDP(exp, true, s, i-1, q) * fDP(exp, true, i+1, e, q);
                } else if (op == '|') {
                    c += fDP(exp, true, s, i-1, q) * fDP(exp, true, i+1, e, q);
                    c += fDP(exp, true, s, i-1, q) * fDP(exp, false, i+1, e, q);
                    c += fDP(exp, false, s, i-1, q) * fDP(exp, true, i+1, e, q);
                } else if (op == '^') {
                    c += fDP(exp, true, s, i-1, q) * fDP(exp, false, i+1, e, q);
                    c += fDP(exp, false, s, i-1, q) * fDP(exp, true, i+1, e, q);
                }
            }
        } else {
            for (int i = s + 1; i <=e; i += 2) {
                char op = exp.charAt(i);
                if (op == '&') {
                    c += fDP(exp, false, s, i-1, q) * fDP(exp, true, i+1, e, q);
                    c += fDP(exp, true, s, i-1, q) * fDP(exp, false, i+1, e, q);
                    c += fDP(exp, false, s, i-1, q) * fDP(exp, false, i+1, e, q);
                } else if (op == '|') {
                    c += fDP(exp, false, s, i-1, q) * fDP(exp, false, i+1, e, q);
                } else if (op == '^') {
                    c += fDP(exp, true, s, i-1, q) * fDP(exp, true, i+1, e, q);
                    c += fDP(exp, false, s, i-1, q) * fDP(exp, false, i+1, e, q);
                }
            }
        }

        q.put(key, c);
        return c;
    }
}

