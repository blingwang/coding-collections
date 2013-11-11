import java.util.*;
public class RestoreIpAddresses {
    String s;
    ArrayList<String> ipList;
    int[] fieldStarts;
    
    public ArrayList<String> restoreIpAddresses(String s) {
        this.s = s;
        ipList = new ArrayList<String>();
        fieldStarts = new int[4];
        
        restore(0, 0);
        
        return ipList;
    }
    
    private void restore(int start, int field) {
        if (field == 4 && start == s.length()) {
            addIpToList();
            return;
        }
        
        if (field == 4 || start == s.length()) return;
        
        int availableDigits = s.length() - start;
        int minDigitsNeeded = 4 - field;
        int maxDigitsNeeded = (4 - field) * 3;
        if (availableDigits < minDigitsNeeded || availableDigits > maxDigitsNeeded) return;
        
        fieldStarts[field] = start;
        
        restore(start+1, field+1);
        if (isValidIp(start, start+1)) restore(start+2, field+1);
        if (isValidIp(start, start+2)) restore(start+3, field+1);
    }
    
    private void addIpToList() {
        String ip = "";
        for (int i = 0; i < 3; i++) {
            ip += s.substring(fieldStarts[i], fieldStarts[i+1]) + ".";
        }
        ip += s.substring(fieldStarts[3]);
        
        ipList.add(ip);
    }
    
    private boolean isValidIp(int start, int end) {
        if (start < 0 || end >= s.length()) return false;
        if (s.charAt(start) == '0') return false;
        int value = Integer.parseInt(s.substring(start, end+1));
        return value > 0 && value <= 255;
    }
}
