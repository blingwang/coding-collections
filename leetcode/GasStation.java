public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        assert(gas.length == cost.length);
        int N = gas.length;
        
        int curLeft = 0;
        int totalLeft = 0;
        int start = 0;
        for (int i = 0; i < N; i++) {
            curLeft += gas[i] - cost[i];
            totalLeft += gas[i] - cost[i];
            if (curLeft < 0) {// first invalid sum, drop all pre
                start = i + 1;
                curLeft = 0;
            }
        }
        
        return totalLeft >= 0 ? start : -1;
    }
}
