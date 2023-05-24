#include <bits/stdc++.h>
using namespace std;
 
void direct_mapping(int, int, int);
void fully_associative_mapping(int, int);
void set_associative_mapping(int, int, int);

int main(){

    int mainMemSize, cacheMemSize, wordSize, MMsize, cacheSize, tagSize, lineSize;

    cout << "Main memory address size(Gb): ";
    cin >> mainMemSize;

    cout << "Cache memory size(Mb): ";
    cin >> cacheMemSize;

    cout << "Cache size(byte): ";
    cin >> wordSize;

    cout << endl;

    direct_mapping(mainMemSize, cacheMemSize, wordSize);
    fully_associative_mapping(mainMemSize, wordSize);
    set_associative_mapping(mainMemSize, cacheMemSize, wordSize);

    return 0;
}

void direct_mapping(int mainMemSize, int cacheMemSize, int wordSize){
    
    cout << "Direct Mapping" << endl;

    int MMsize, cacheSize, tagSize, lineSize;

    MMsize = 30 + log2(mainMemSize);
    cacheSize = 20 + log2(cacheMemSize);
    wordSize = log2(wordSize*8.0);

    tagSize = MMsize - cacheSize;
    lineSize = cacheSize - wordSize;

    cout << "|\tTag\t|\tLine\t|\tWord" << endl;
    cout << "|\t" << tagSize << " bits\t|\t" << lineSize << "bits\t|\t" << wordSize << "bits" << endl;

    cout << endl << endl;
}

void fully_associative_mapping(int mainMemSize, int wordSize){
    
    cout << "Fully/Associative Mapping" << endl;

    int MMsize, tagSize;

    MMsize = 30 + log2(mainMemSize);
    wordSize = log2(wordSize*8.0);

    tagSize = MMsize - wordSize;

    cout << "|\tTag\t|\tWord\t|" << endl;
    cout << "|\t" << tagSize << " bits\t|\t" << wordSize << "bits\t|"<< endl;

    cout << endl << endl;
}

void set_associative_mapping(int mainMemSize, int cacheMemSize, int wordSize){
    
    cout << "Set-Associative Mapping" << endl;

    int MMsize, cacheSize, tagSize, lineSize, k;
    cout << "k-set (n-way): ";
    cin >> k;

    MMsize = 30 + log2(mainMemSize);
    cacheSize = 20 + log2(cacheMemSize/k);
    wordSize = log2(wordSize*8.0);

    tagSize = MMsize - cacheSize;
    lineSize = cacheSize - wordSize;

    cout << "|\tTag\t|\tLine\t|\tWord" << endl;
    cout << "|\t" << tagSize << " bits\t|\t" << lineSize << "bits\t|\t" << wordSize << "bits" << endl;

    cout << endl << endl;
}
