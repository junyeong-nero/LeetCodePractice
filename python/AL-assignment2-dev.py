from typing import List

import random

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

def median_sort(arr):
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
    if len(less) < len(large):
        return less + eq + median_sort(large)
    elif len(less) > len(large):
        return median_sort(less) + eq + large
    else:
        return arr

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
    ans_quick = cal(arr, arr[n // 2])
    # print ("cal : ", ans)

    arr = median_sort(arr)
    ans_median = cal(arr, arr[n // 2])

    temp = cal(arr, 0)
    idx = 0
    for i in arr:
        v = cal(arr, i)
        if temp > v:
            idx = i
            temp = v

    print(temp, " == ", ans_quick)
    print(ans_quick, " == ", ans_median)
    # assert(temp == ans_quick)
    # assert(temp == ans_median)
    if temp != ans_quick or temp != ans_median:
        print(arr)
    return temp

def mutate(arr):
    pick = random.randrange(0, 2)
    if pick == 0:
        arr.append(random.randrange(1, 20000))
    elif pick == 1:
        random.shuffle(arr)

if __name__ == "__main__":
    test_case = []
    for i in range(1000):
        # print(test_case)
        fun(test_case, len(test_case))
        mutate(test_case)
    
    # test_cases = [
    #     [],
    #     [1],
    #     [1, 2, 3],
    #     [1, 2, 3, 9, 8, 5, 4, 2, 10, 111, 234, 109, 123, 999999],
    #     [1, 2, 3, 9, 8, 5],
    #     [1, 2, 3, 9, 8, 5, 4, 2, 10, 111],
    #     [1, 2, 3, 9, 8, 5, 4, 2, 10, 111, 234, 109, 123],
    #     [9, 8, 7, 6, 5, 4, 3, 2, 1],
    #     [20, 9, 8, 7, 6, 5, 4, 3, 2, 1],
    #     [3, 3, 3, 3],
    #     [20, 10, 11, 19, 9, 3, 2, 19, 10, 3, 200, 10, 1, 2, 12, 6, 120, 1, 1, 1, 123],
    #     [20, 10, 11, 19, 9, 3, 2, 19, 10, 3, 200, 10, 1, 2, 12, 6],
    #     [20, 10, 11, 19, 9, 3, 2, 19, 10, 3, 200, 10, 1, 2, 12, 6, 123]
    # ]
    # for test in test_cases:
    #     fun(test, len(test))
    