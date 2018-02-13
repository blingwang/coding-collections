/**
 * @param {string} s
 * @return {string}
 */
var reverseString = function(s) {
    // Using the spread operator to split a string into characters 
    // has the advantage of handling non-BMP Unicode characters correctly 
    // (which comprise two “JavaScript characters”).
    return [...s].reverse().join('');
};
