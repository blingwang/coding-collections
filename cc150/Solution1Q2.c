# include <string.h>
void reverse(char *s) {// or char s[]
    int length = strlen(s);
    int c, i, j;
    
    for (i = 0, j = length - 1; i < j; i++, j--) {
        c = s[i];
        s[i] = s[j];
        s[j] = c;
    }
}
