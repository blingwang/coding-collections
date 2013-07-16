void reverse(char *str){
    char* end = str;
    char tmp;
    if(str){
        while(*end){// find end of the string
            ++end;
        }
        --end; // set one char back, since last char is null

        // swap characters from start of string with the end 
        // of the string, untill the pointers meet in the middle
        while(str < end){
            tmp = *str;
            *str++ = *end;
            *end++ = tmp;
        }
    }
}
