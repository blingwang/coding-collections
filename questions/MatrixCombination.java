
/*
Write a function that takes a 2-dimensional array of strings of size m x n. And prints out every combinations of elements from each row. The first character should be a character from the first array, the second character should be a character from the second array, the third character should be a character from the third array, and so on.


input: [[a, b], 
        [1, 2], 
        [*, +]]
        
output:
a1*
a1+
a2*
a2+
b1*
b1+
b2*
b2+
*/

public void product(int m, int n, String[][] things, String curr, int currIndex) {
    if (currentIndex == m) {
        System.println(curr);
        return;
    }
    
    String curStr = things[currentIndex];
    for (int i = 0; i < n; i++) {
        curr.append(curStr.charAt(i));
        product(m, n, things, curr, currIndex++); 
        curr.removeCharAt(i);   
    }   

    return;
}
