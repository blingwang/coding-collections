using namespace std;
/* flip n */
unsigned int flip(unsigned int n)
{
    int i, newInt = 0;
    for (i=0; i<sizeof(int); ++i)
    {
        newInt += (n & 0x0001);
        newInt <<= 1;
        n >>= 1;
    }
    return newInt;
}

bool isPalindrome(int n)
{
    int flipped = flip(n);
    /* shift to remove trailing zeroes */
    while (!(flipped & 0x0001))
        flipped >>= 1;
    return n == flipped;
}
