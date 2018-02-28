class Solution {
    public String complexNumberMultiply(String a, String b) {
        int[] valA = getValue(a);
        int[] valB = getValue(b);
        
        int real = valA[0] * valB[0] - valA[1] * valB[1];
        int img = valA[0] * valB[1] + valA[1] * valB[0];
        
        return real + "+" + img + "i";
    }
    
    private int[] getValue(String s) {
        String[] splited = s.split("\\+");
        int[] val = new int[2];
        val[0] = Integer.parseInt(splited[0]);
        val[1] = Integer.parseInt(splited[1].replace("i", ""));
        return val;
    }
}
