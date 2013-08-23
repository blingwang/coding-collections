import java.util.*;

public class Solution {
    private static final int stackSize = 100;
    private int[] buffer = new int[stackSize * 3];
    private int[] stackCount = {0, 0, 0};// element count

    public void push(int stackNum, int value) {
        // check if we have space
        if (stackCount[stackNum] >= stackSize) {
            throw new RuntimeException("Out of space!");
        }

        int index = stackNum * stackSize + stackCount[stackNum];
        buffer[index] = value;
        stackCount[stackNum]++;
    }

    public int pop(int stackNum) {
        if (stackCount[stackNum] == 0){
            throw new EmptyStackException();
        }

        int index = stackNum * stackSize + stackCount[stackNum] - 1;
        int value = buffer[index];
        buffer[index] = 0;
        stackCount[stackNum]--;

        return value;
    }

    public int peek(int stackNum) {
        int index = stackNum * stackSize + stackCount[stackNum] - 1;

        return buffer[index];
    }

    public boolean isEmpty(int stackNum) {
        return stackCount[stackNum] == 0;
    }
}
