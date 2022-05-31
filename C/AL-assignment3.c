// #include <iostream.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stdio.h>

#define MAX 1000

// get distance function
float distance(float a[2], float b[2]) { return sqrt(pow(a[0] - b[0], 2) + pow(a[1] - b[1], 2)); }

float min_distance(float points[MAX][2], int n) {
    // return value
    float res = 0;
    // count used points
    int used = 0;

    bool check[n];
    float minDist[n];

    for (int i = 0; i < n; i++) {
        minDist[i] = INT_MAX;
        check[i] = false;
    }
    minDist[0] = 0;

    while (used < n) {
        // get minimum
        float currMinEdge = INT_MAX;
        int currNode = -1;
        for (int node = 0; node < n; ++node) {
            if (!check[node] && currMinEdge > minDist[node]) {
                currMinEdge = minDist[node];
                currNode = node;
            }
        }

        printf("cur : %f, %f\n", points[currNode][0], points[currNode][1]);
        res += currMinEdge;
        used++;
        check[currNode] = true;

        // Update adjacent nodes of current node.
        for (int nextNode = 0; nextNode < n; ++nextNode) {
            float dist = distance(points[currNode], points[nextNode]);
            printf("dst : %f\n", dist);
            if (!check[nextNode] && minDist[nextNode] > dist) {
                minDist[nextNode] = dist;
            }
        }
    }
    printf("res : %f\n", res);
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