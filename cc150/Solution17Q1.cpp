void swap(int &a, int &b) {
    a = a - b;
    b = a + b;
    a = b - a;
}

void swapXOR(int &a, int &b) { // can support more data types
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
}
