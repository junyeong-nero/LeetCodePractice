#include <stdbool.h>

int maximum69Number(int num) {
    int digit = 10000;
    int res = 0;
    bool check = true;
    for (int i = 0; i < 5; i++) {
        int n = (num / digit) % 10;
        if (check && n == 6) {
            res += 9 * digit;
            check = false;
        } else {
            res += n * digit;
        }
        digit /= 10;
    }
    return res;
}

int main() {}