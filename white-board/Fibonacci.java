public class Fibonacci {
    public static long fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }
    
    public static int fib(int n) {
        int fn1 = 0; // f(0)
        int fn2 = 1; // f(-1)
      
        for(int i = 0; i < n; i++){// fib(1) to fib(n)
          fn1 = fn1 + fn2;
          fn2 = fn1 - fn2;
        } 
      
        return fn1;
    }

    /*
    * 0 1 1 2 3 5 8 13  Fibonacci seq.
    * 0 1 2 3 4 5 6 7 <-- index
    *
    *Ex: given index 6, return sum of 0, 1, 1, 2, 3, 5
    */
    public int fibSum(int maxIndex) {    
        int sum = 0;
        int fn1 = 0;
        int fn2 = 1;
        
        for (int i = 1; i < maxIndex; i++) {
            fn1 = fn1 + fn2;
            fn2 = fn1 - fn2;
            sum += fn1;
        }
        
        return sum;
    }
    
    public static void printFibs(int limit) {         
        long[] series = new long[limit];
       
        //create first 2 series elements
        series[0] = 0;
        series[1] = 1;
       
        //create the Fibonacci series and store it in an array
        for(int i=2; i < limit; i++){
                series[i] = series[i-1] + series[i-2];
        }
       
        //print the Fibonacci series numbers
       
        System.out.println("Fibonacci Series upto " + limit);
        for(int i=0; i< limit; i++){
                System.out.print(series[i] + " ");
        }
    }
    
    public static long tailRecursive(long n) {
        if (n <= 2) {
            return 1;
          }
        return tailRecursiveAux(0, 1, n);
    }
          
    private static long tailRecursiveAux(long a, long b, long count) {
        if(count <= 0) {
            return a;
        }
        return tailRecursiveAux(b, a+b, count-1);
    }
    
    public double getFibonacci(int n) {
        double f1 = Math.pow(((1 + Math.sqrt(5)) / 2.0), n);
        double f2 = Math.pow(((1 - Math.sqrt(5)) / 2.0), n);
    
        return Math.floor((f1 - f2) / Math.sqrt(5));
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        for (int i = 1; i <= N; i++)
            System.out.println(i + ": " + fib(i));
    }

}
