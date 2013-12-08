import java.util.*;
public class JumpGame { // BFS on graph: reachability
    public boolean canJump(int[] A) {
        assert(A.length != 0);
        int maxJumpToIndex = 0;
        
        for (int i = 0; i <= maxJumpToIndex; i++) {
            maxJumpToIndex = Math.max(maxJumpToIndex, i + A[i]);
            if (maxJumpToIndex >= A.length - 1) return true;
        }
        
        return false;
    }
    
    public boolean canJump2(int[] A) {
        assert(A.length != 0);
        int nextCanJump = A.length - 1;
        
        for (int i = A.length - 2; i >= 0; i--) {
            if (i + A[i] >= nextCanJump) {
                nextCanJump = i;
            }
        }
        
        return nextCanJump == 0;
    }

    Set<Integer> canNotJumpIndices;
    public boolean canJumpSlow(int[] A) { // too slow, stack overflow
        canNotJumpIndices = new HashSet<Integer>();
        return canJump(A, 0);
    }

    private boolean canJump(int[] A, int curPos) {
        if (canNotJumpIndices.contains(curPos)) return false;
        if (curPos >= A.length-1) return true;
        
        for (int i = 1; i <= A[curPos]; i++) {
            if (canJump(A, curPos + i)) return true;
        }
        
        canNotJumpIndices.add(curPos);
        return false;
    }
}
