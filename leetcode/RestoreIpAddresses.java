import java.util.*;
public class RestoreIpAddresses {
    String s;
    ArrayList<String> ipList;
    int[] groupStarts;

    public ArrayList<String> restoreIpAddresses(String s) {
        this.s = s;
        ipList = new ArrayList<String>();
        groupStarts = new int[4];
        
        if (s.length() < 4 && s.length() > 12) return ipList;
        restoreIpAddresses(0, 0);
        
        return ipList;
    }

    private void restoreIpAddresses(int start, int groupIndex) {
        if (groupIndex == 4) {
            if (start == s.length()) addIpToList();
            return;
        }
        
        if (start >= s.length()) return;
        
        groupStarts[groupIndex] = start;
        
        restoreIpAddresses(start+1, groupIndex+1);
        if (s.charAt(start) != '0') restoreIpAddresses(start+2, groupIndex+1);
        if (validThreeDigits(start)) restoreIpAddresses(start+3, groupIndex+1);
    }

    private void addIpToList() {
        String ip = "";
        for (int i = 0; i < 3; i++) {
            ip += s.substring(groupStarts[i], groupStarts[i+1]) + ".";
        }
        ip += s.substring(groupStarts[3]);
        ipList.add(ip);
    }

    private boolean validThreeDigits(int start) {
        if (start + 2 >= s.length()) return false;
        if (s.charAt(start) == '0') return false;
        int value = Integer.parseInt(s.substring(start, start+3));
        if (value > 255) return false;
        return true;
    }
}
