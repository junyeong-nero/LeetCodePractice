#include <stdio.h>

void swap(int *arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

void quickSort(int *arr, int start, int end) {
    if (start >= end) return;
    int target = arr[end];
    int i = start - 1;
    for (int j = start; j < end; j++) {
        if (arr[j] <= target) {
            swap(arr, ++i, j);
        }
    }
    swap(arr, i + 1, end);
    quickSort(arr, i + 1, end);
    quickSort(arr, start, i);
}

int calculate(int *arr, int len) {
    quickSort(arr, 0, len - 1);
    int res = 0;
    int k = arr[len / 2];
    for (int i = 0; i < len; ++i) {
        int a = arr[i] - k;
        if (a > 0)
            res += a;
        else
            res -= a;
    }
    return res;
}

int main() {
    int len = 8;
    int data[8] = {2, 1, 3, 123, 1, 99, 1, 2};
    printf("%d\n", calculate(data, len));
}