import java.util.*;
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || !path.startWith('/')) return null;
        
        String[] fileNames = path.trim().split("/");
        ArrayDeque<String> deque = new ArrayDeque<String>();
        for (String fileName : fileNames) {
            if (fileName.equals("") || fileName.equals(".")) {
                // do nothing
            } else if (fileName.equals("..")) {
                if (!deque.isEmpty()) deque.removeLast();
            } else {
                deque.addLast(fileName);
            }
        }
        
        if (deque.isEmpty()) return "/";
        
        StringBuilder simplified = new StringBuilder();
        while (!deque.isEmpty()) {
            simplified.append("/"); 
            simplified.append(deque.removeFirst());
        }
        
        return simplified.toString();
    }
}
