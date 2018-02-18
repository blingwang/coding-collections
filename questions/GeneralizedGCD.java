class GCD
{
    public int generalizedGCD(int num, int[] arr)
    {
        int result = arr[0];
        for (int i=1; i<num; i++)
            result = gcd(arr[i], result);
         
        return result;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd (b, a % b);
    }
}
