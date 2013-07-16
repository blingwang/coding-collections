#include <iostream>
#include <fstream>
using namespace std;

void printLastKLines(char* fileName) {
    const int K = 10;
    ifstream file (fileName);
    string lines[K];
    int size = 0;

    /* read file line by line into circular array */
    while (file.good()) {
        getline(file, lines[size % K]);
        size++;
    }

    /* compute start of circular array and the size of it */
    int start = size > K ? (size % K) : 0;
    int count = min(K, size);

    /* print last K lines in the order they were read */
    for (int i = 0; i < count; i++) {
        cout << lines[(start + i) % K] << endl;
    }
}
