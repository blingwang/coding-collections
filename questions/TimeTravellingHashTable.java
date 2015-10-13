import java.io.*;
import java.util.*;

/* 
Your previous Plain Text content is preserved below:

'foo' > 1 > 'bar'
 'foo' > 3 > 'buzz'
 
 Accessors
 'foo', 1 > 'bar'
 'foo', 2 > 'bar'
 'foo', 4 > 'buzz'
 'foo', 0 > None
 */

class Solution {
  Map<String, TreeMap<Integer, String>> data;
  
  public Solution() {
    data = new HashMap<String, TreeMap<Integer, String>>();
  }

  public void put(String key, int time, String value) {
    if (!data.containsKey(key)) {
      data.put(key, new TreeMap<Integer, String>());
    }
    
    TreeMap<Integer, String> valuesMap = data.get(key);
    valuesMap.put(time, value);
  }
  
  public String get(String key, int time){
    if (!data.containsKey(key)) {
      return null;
    }
    
    TreeMap<Integer, String> valuesMap = data.get(key);
    Map.Entry<Integer,String> entry = valuesMap.floorEntry(time);
    
    if (entry != null) {
      return entry.getValue();
    }
    
    return null;
  }
  
  public static void main(String[] args) {
    Solution timeTravellingMap = new Solution();
    timeTravellingMap.put("foo", 1, "bar");
    timeTravellingMap.put("foo", 3, "buzz");
    
    assert timeTravellingMap.get("foo", 1).equals("bar") : "Should be bar";
    assert timeTravellingMap.get("foo", 2).equals("bar") : "Should be bar";
    assert timeTravellingMap.get("foo", 4).equals("buzz") : "Should be buzz";
    assert timeTravellingMap.get("foo", 0) == null : "Should be null";
      
  }
}
