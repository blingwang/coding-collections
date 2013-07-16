// find the only duplicate number in n numbers with range from 1~n-1
class DedupXor{
static int duplicate(int []input)
    {
        int n=input.length;
        int XOR1=1;
        for(int i=2;i<=n-1;i++)
        {
            XOR1=XOR1^i;
        }
        int XOR2=input[0];
        for(int i=1;i<n;i++)
        {
            XOR2=XOR2^input[i];
        }
        return XOR1^XOR2;
    }

public static void main(String[] args){
    int [] list={2,3,1,5,4,6,3};
    System.out.println(duplicate(list));
}

}
