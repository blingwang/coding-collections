import java.util.*;

class Solution7Q7 {
    private static int removeMin(Queue<Integer> q) {
        int min = q.peek();
        for (Integer v : q) {
            if (min > v) {
                min = v;
            }
        }

        while (q.contains(min)) {
            q.remove(min);
        }

        return min;
    }

    public static void addProducts(Queue<Integer> q, int v) {
        q.add(v * 3);
        q.add(v * 5);
        q.add(v * 7);
    }

    public static int getKthMagicNumber(int k) {
        if (k < 0) return 0;

        int val = 1;
        Queue<Integer> q = new LinkedList<Integer>();
        addProducts(q, 1);
        for(int i = 0; i < k; i++) {
            val = removeMin(q);
            addProducts(q, val);
        }
        return val;
    }

    public static int getKthMagicNumberFaster(int k) {
        if (k < 0) {
             return 0;
        }

        int val = 0;
        Queue<Integer> queue3 = new LinkedList<Integer>();
        Queue<Integer> queue5 = new LinkedList<Integer>();
        Queue<Integer> queue7 = new LinkedList<Integer>();
        queue3.add(1);

        // include oth through kth iteration
        for (int i = 0; i <= k; i++) {
            int v3 = queue3.size() > 0 ? queue3.peek() : Integer.MAX_VALUE;
            int v5 = queue5.size() > 0 ? queue5.peek() : Integer.MAX_VALUE;
            int v7 = queue7.size() > 0 ? queue7.peek() : Integer.MAX_VALUE;

            val = Math.min(v3, Math.min(v5, v7));

            if (val == v3) {// enqueue into queue 3, 5, 7
                queue3.remove();
                queue3.add(3 * val);
                queue5.add(5 * val);
            } else if (val == v5) { // enqueue into queue 5 and 7
                queue5.remove();
                queue5.add(5 * val);
            } else if (val == v7) { // enqueue into queue 7
                queue7.remove();
            }
            queue7.add(7 * val); // always enqueue into queue 7
        }
        return val;
    }
}


