Given a list of words, output all pairs of words such that the pair when concatenated together will create a palindrome

Given: [‘a’, ‘ab’, ‘ccba’, ‘llama’, ‘mall’, ‘za’]
Output: [(‘a’, ‘za’), (‘ab’, ‘a’), (‘ab’, ‘ccba’), (‘llama’, ‘mall’)]

root
|     \ 
a(x)    b
| \  \     \
b  m  z(x)  a(x)
|   \
c    a
|     |
c(x)  l
      |
      l(x)

class Node {
  char value;
  Node[] children;  // one for each letter
  boolean isEnd;   // marks if end of word
}

class Pair {
  Pair(String first, String second);

  getFirst
  getSecond
}

public Pair[] getPalindromePairs(String[] words) {
	ArrayList<Pair> palindromes = new ArrayList<Pair>();

      // Another way was to concatenate w1 + w2 AND w2 + w1. 
	for (int i = 0; i < words.length; i++) {
		for (int j = i+1; j < words.length; j++) {
	String candidate = words[i] + words[j];
	if (isPalindrome(candidate)) {
		Arraylist.add(new Pair(words[i], words[j]));	
}
}
}

	palindromes.toArray();
}

private boolean isPalindrome(String candidate) {
	int len = candidate.length();
	for (int i = 0; i < len/2; i++) {
		if (candidate.charAt(i) != candidate.charAt(len-i-1)) {
			return false;
}
}
	return true;
}

public Pair[] getPalindromePairs(String[] words) {
	ArrayList<Pair> palindromes = new ArrayList<Pair>();

	Node prefixTree = constructPrefixTreeInReverse(words);
	
	for (int i = 0; i < words.length; i++) {
String w = words.[i];
	
}

	return palindromes.toArray();
}

For each word, see if in list. if there are further branches off that node, then do dfs and remember path (check palindrome against path). 
