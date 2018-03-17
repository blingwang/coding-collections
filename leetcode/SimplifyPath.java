class Solution {
    public String simplifyPath(String path) {
        Set<String> skip = new HashSet<>(Arrays.asList("", ".", ".."));
        Deque<String> deque = new ArrayDeque<>();
        
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !deque.isEmpty()) {
                deque.removeLast();
            } else if (!skip.contains(dir)) {
                deque.addLast(dir);
            }
        }
        
        return "/" + String.join("/", deque);
    }
}
