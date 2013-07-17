public class ValidParentheses {
	private static final Map<Character, Character> map;
	static {
		map = new HashMap<Character, Character>();
		map.put(‘(‘, ‘)’);
		map.put(‘[‘, ‘]’);
		map.put(‘{‘, ‘}’);
}

	public boolean isValid(String s) {
		ArrayDeque<Character> stack = new ArrayDeque<Character>();
for (int i = 0; i < s.length(); i++) {
	char c = s.charAt(i);
	if (map.containsKey(c)) {
		char left = map.get(c);
		if (stack.isEmpty() || stack.pop() != left) return false;
	} else {
		stack.push(c);
}
}	
		return stack.isEmpty();
}

public static void main(String[] args) {
	ValidParentheses vp = new ValidParentheses();
	assert(false == vp.isValid(“[[[“));	
}
}
