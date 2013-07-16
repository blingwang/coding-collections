public class Solution3Q1{// three stacks using one array
    private static final int stackSize = 100;
    private int[] buffer = new int[stackSize * 3];
    private int[] stackCount = {0, 0, 0};// element count

    public void push(int stackNum, int value) throws Exception {
        // check if we have space
        if (stackCount[stackNum] >= stackSize) {
            throw new Exception("Out of space.");
        }

        int index = stackNum * stackSize + stackCount[stackNum];
        buffer[index] = value;
        stackCount[stackNum]++;
    }

    public int pop(int stackNum) throws Exception {
        if (stackCount[stackNum] == 0){
            throw new Exception("Trying to pop an empty stack");
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
