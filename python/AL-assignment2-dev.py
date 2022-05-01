from typing import List

def abs(n):
    if n < 0:
        return -n
    else:
        return n

def cal(arr, d):
    _sum = 0
    for i in arr:
        _sum += abs(i - d)
    return _sum

def quick_sort(arr):
    if len(arr) <= 1:
        return arr
    target = arr[len(arr) // 2]
    less, eq, large = [], [], []

    # partition
    for num in arr:
        if num < target:
            less.append(num)
        elif num > target:
            large.append(num)
        else:
            eq.append(num)

    # sum
    return quick_sort(less) + eq + quick_sort(large)

def fun(arr : List[int], n : int):
    if n == 0:
        return 0
    if n == 1:
        return arr[0]
        
    arr = quick_sort(arr)
    ans = cal(arr, arr[n // 2])
    # print ("cal : ", ans)

    temp = cal(arr, 0)
    idx = 0
    for i in range(0, n):
        v = cal(arr, i)
        if temp > v:
            idx = i
            temp = v

    print(ans, " == ", temp)
    return ans

if __name__ == "__main__":
    test_cases = [
        [],
        [1],
        [1, 2, 3],
        [1, 2, 3, 9, 8, 5, 4, 2, 10, 111, 234, 109, 123, 999999],
        [1, 2, 3, 9, 8, 5],
        [1, 2, 3, 9, 8, 5, 4, 2, 10, 111],
        [1, 2, 3, 9, 8, 5, 4, 2, 10, 111, 234, 109, 123],
        [9, 8, 7, 6, 5, 4, 3, 2, 1],
        [20, 9, 8, 7, 6, 5, 4, 3, 2, 1],
        [3, 3, 3, 3],
    ]
    for test in test_cases:
        fun(test, len(test))
    