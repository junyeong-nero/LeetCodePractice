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
    return ans

if __name__ == "__main__":
    pass
    # fun(test, len(test))