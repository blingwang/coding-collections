import java.util.*;
class Solution9Q10 {
    private class Box {
        public boolean  canBeAbove(Box bottom) {
            return true;
        }
    }

    private int stackHeight(ArrayList list) {
        return 0;
    }
    
    public ArrayList<Box> createStackDP(Box[] boxes, Box bottom, 
            HashMap<Box, ArrayList<Box>> stackMap) {
        if (bottom != null && stackMap.containsKey(bottom)) {
            return stackMap.get(bottom);
        }

        int maxHeight = 0;
        ArrayList<Box> maxStack = null;
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i].canBeAbove(bottom)) {
                ArrayList<Box> newStack = createStackDP(boxes, boxes[i], stackMap);
                int newHeight = stackHeight(newStack);
                if (newHeight > maxHeight) {
                    maxStack = newStack;
                    maxHeight = newHeight;
                }
            }
        }

        if (maxStack == null) {
            maxStack = new ArrayList<Box>();
        }

        if (bottom != null) {
            maxStack.add(0, bottom); // insert in bottom of stack, elements shifted
        }
        stackMap.put(bottom, maxStack);

        return (ArrayList<Box>)maxStack.clone();
    }
}
