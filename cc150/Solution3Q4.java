import java.util.*;
public class Solution3Q4 {
    public static void main(String[] args) {
        HanoiTower ht = new HanoiTower(3);
        ht.play();
    }
}

class HanoiTower {
    private final int n;
    private Tower[] towers;
    
    public HanoiTower(int n) {
        this.n = n;
        towers = new Tower[3];
        
        for (int i = 0; i < 3; i++) {
            towers[i] = new Tower(i);
        }
        
        for (int i = n-1; i >= 0; i--) {
            towers[0].push(i);
        }
    }
    
    public void play() {
        moveDisks(3, 0, 2, 1);
    }
    
    public void moveDisks(int n, int from, int to, int buffer) {
        if (n== 0) return;
        
        moveDisks(n-1, from, buffer, to);
        moveTop(from, to);
        moveDisks(n-1, buffer, to, from);
    }
    
    public void moveTop(int from, int to) {
        int disk = towers[from].pop();
        towers[to].push(disk);
        System.out.println("Move disk " + disk + " from " + towers[from].index() +
                            " to " + towers[to].index());
    }
    
    private static class Tower {
        private int index;
        private ArrayDeque<Integer> disks;
        
        public Tower(int index) {
            this.index = index;
            disks = new ArrayDeque<Integer>();
        }
        
        public int index() {
            return index;
        }
        
        public void push(int i) {
            if (!disks.isEmpty() && i >= disks.peek()) {
                throw new RuntimeException("Error placing " + i + " to Tower " + index());
            } 
            
            disks.push(i);
        }
        
        public int pop() {
            return disks.pop();
        }
    }
}
