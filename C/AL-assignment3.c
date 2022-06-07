// #include <iostream.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stdio.h>

#define MAX 1000

// get distance function
float distance(float a[2], float b[2]) { return sqrt(pow(a[0] - b[0], 2) + pow(a[1] - b[1], 2)); }

float min_distance(float points[MAX][2], int n) {
    float res = 0.0;
    int used = 0;

    bool check[n];
    float minDist[n];

    for (int i = 0; i < n; i++) {
        minDist[i] = INT_MAX;
        check[i] = false;
    }
    minDist[0] = 0;

    while (used < n) {
        float min_dst = INT_MAX;
        int cur = -1;
        for (int i = 0; i < n; ++i) {
            if (!check[i] && min_dst > minDist[i]) {
                min_dst = minDist[i];
                cur = i;
            }
        }
        res += min_dst;
        used++;
        check[cur] = true;
        for (int i = 0; i < n; i++) {
            float dst = distance(points[cur], points[i]);
            if (!check[i] && minDist[i] > dst) {
                minDist[i] = dst;
            }
        }
    }
    return res;
}

int main() {
    float array[3][2] = {
        {1, 2},   // row 0 = 1, 2, 0, 0, 0
        {6, 7},   // row 1 = 6, 7, 8, 0, 0
        {11, 12}  // row 2 = 11, 12, 13, 14, 0
    };
    float res = min_distance(array, 3);
    printf("res : %f\n", res);
    return 0;
}
