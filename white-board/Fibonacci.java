public class Fibonacci {
    public static long fib(int n) {
        if (n <= 1) return n;
        else return fib(n-1) + fib(n-2);
    }
    
    public static int fib(int n) {
        int f = 0;
        int g = 1;
      
        for(int i = 0; i < n; i++){
          f = f + g;
          g = f - g;
        } 
      
        return f;
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
