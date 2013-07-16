/* Returns true if the machine is little-endian, false if
 * the machine is big-endian
 */
bool isLittleEndian(){
    int testNum;
    char *ptr;
    testNum = 1;
    ptr = (char*) &testNum;
    return (*ptr);
}

bool isLittleEndian2(){
    union{
        int theInteger;
        char singleByte;
    } endianTest;
    endianTest.theInteger = 1;
    return endianTest.singleByte;
}
