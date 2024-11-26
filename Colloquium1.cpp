#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> FirstFibonacciNums(int num) {
    vector<int> fibonacciNums;

    if (num <= 0) {
        cout << "incorrect num" << endl;
        return fibonacciNums;
    }
    if (num > 47) {
        cout << "num is too large for this function" << endl;
        num = 47;
    }
    fibonacciNums.push_back(0);

    if (num == 1) {
        return fibonacciNums;
    }
    fibonacciNums.push_back(1);

    for (int i = 2; i < min(num, 47); i++) {
        int next = fibonacciNums[i - 1] + fibonacciNums[i - 2];
        fibonacciNums.push_back(next);
    }
    return fibonacciNums;
}

void PrintVector(vector<int> arr) {
    for (int i = 0; i < arr.size(); i++) {
        cout << arr[i] << ' ';
    }
    cout << endl;
}



int main()
{
    int num;
    cout << "Enter num" << endl;
    cin >> num;
    
    vector<int> fibonacciArr = FirstFibonacciNums(num);
    if (fibonacciArr.size() > 0) {
        cout << "First " << fibonacciArr.size() << " Fibonacci nums: ";
        PrintVector(fibonacciArr);
    }
}