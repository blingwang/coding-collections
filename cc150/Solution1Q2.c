void reverse(char *str) {
    int length = strlen(str);
    int c, i, j;
    
    for (i = 0, j = length - 1; i < j; i++, j--) {
        c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
}
