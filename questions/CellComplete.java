import java.util.*;

public class Solution
{        
    public List<Integer> cellCompete(int[] states, int days)
    {
        int[] newStates = new int[states.length];
        for (int day = 0; day < days; day++) {
            for (int i = 0; i < states.length; i++) {
                int pre = i==0 ? 0 : states[i-1];
                int next = i==states.length-1 ? 0 : states[i+1];
                newStates[i] = pre  ^ next;
            }
            for (int i = 0; i < states.length; i++) {
                states[i] = newStates[i];
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i : states) {
            result.add(i);
        }
        return result;
    }
}
