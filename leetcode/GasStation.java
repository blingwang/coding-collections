public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        assert(gas.length == cost.length);
        int N = gas.length;
        
        int curGas = 0; // gas left after each edge from valid start
        int totalGas = 0; // total gas left until current edge
        int start = 0;
        
        for (int i = 0; i < N; i++) {
            curGas += gas[i] - cost[i];
            totalGas += gas[i] - cost[i];
            
            if (curGas < 0) {// first invalid sum, drop all pre
                start = i + 1;
                curGas = 0;
            }
        }
        
        return totalGas >= 0 ? start : -1;
    }
}
