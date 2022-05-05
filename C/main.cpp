#include <iostream>

using namespace std;

void print_array(int *arr, int len) {
    cout << "{";
    for (int i = 0; i < len; i++) {
        cout << arr[i];
        if (i < len - 1) cout << ", ";
    }
    cout << "}" << endl;
}

void swap(int *arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void median_sort(int *arr, int start, int end) {
    if (start >= end) return;
    int target = arr[end];
    int i = start - 1;
    for (int j = start; j < end; j++) {
        if (arr[j] <= target) {
            i++;
            swap(arr, i, j);
        }
    }
    swap(arr, i + 1, end);
    int left = i - start + 1;
    int right = end - i;
    if (left < right) {
        median_sort(arr, i + 1, end);
    } else {
        median_sort(arr, start, i);
    }
}

int calculate(int *arr, int len) {
    median_sort(arr, 0, len - 1);
    print_array(arr, len);
    int res = 0;
    int k = arr[len / 2];
    for (int i = 0; i < len; ++i) {
        int a = arr[i] - k;
        res += a > 0 ? a : -a;
    }
    return res;
}

int main() {
    int len = 3;
    int data[len] = {2, 1, 3};
    print_array(data, len);
    cout << "median : " << calculate(data, len - 1) << endl;
    print_array(data, len);
}