// a naive token scanner-based solution
bool reverseWords( char str[] ){
    char *buffer;
    int slen, tokenReadPos, wordReadPos, wordEnd, writePos = 0;
    
    slen = strlen(str);
    // position of the last character is length - 1
    tokenReadPos = slen - 1;
    buffer = (char *) malloc(slen + 1);
    if( !buffer )
        return false; // malloc failed
    while( tokenReadPos >= 0 ){
        if( str[tokenReadPos] == ' ' ){// non-word characters
            // write character
            buffer[writePos++] = str[tokenReadPos--];
        }else{ // word characters
            // store position of end of word
            wordEnd = tokenReadPos;
            // scan to next non-word character
            while( tokenReadPos >= 0 && str[tokenReadPos] != ' ' )
                tokenReadPos--;
            // tokenReadPos went past the start of word
            wordReadPos = tokenReadPos + 1;
            //copy the characters of the word
            while( wordReadPos <= wordEnd ) {
                buffer[writePos++] = str[wordReadPos++];
            }

        }
    }

    // null terminate buffer and copy over str
    buffer[writePos] = '\0';
    strlcpy(str, buffer, slen + 1);
    free(buffer);

    return true; // reverseWords successful
}

// an in-place solution: reverse string, then reverse string in each word
void wcReverseWords( wchar_t str[] ){
    int start = 0, end = 0, length;
    length = wcslen(str);
    // reverse entire string
    wcReverseString( str, 0, length - 1 );

    while( end < length ){
        if( str[end] != L' ' ){// skip non-word characters
            // save position of beginning of word
            start = end;
            // scan to next non-word character
            while( end < length && str[end] != L' ' )
                end++;
            // back up to end of word
            end--;
            // reverse word
            wcReverseString( str, start, end );
        }
        end++; // advance to next token;
    }
}

void wcReverseString( wchar_t str[], int start, int end ){
    while( end > start ){
        // exchange characters
        wchar_t temp = str[start];
        str[start] = str[end];
        str[end] = temp;
        // move indices towards middle
        start++; 
        end--;
    }
}

