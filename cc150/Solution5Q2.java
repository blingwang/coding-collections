public class Solution5Q2 {
    public static String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        while (num > 0) {
            //Setting a limit on length: 32 characters
            if (binary.length() > 32) {
                return "ERROR";
            }

            double r = num * 2;
            if (r > 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }

        return binary.toString();
    }

    public static String printBinary2(double num) {
        if(num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append(".");
        double frac = 0.5;

        while (num > 0) {
            if (binary.length() > 32) {
                return "ERROR";
            }

            if (num >= frac) {
                binary.append(1);
                num -= frac;
            } else {
                binary.append(0);
            }
            frac /= 2;
        }
        
        return binary.toString();
    }
}
