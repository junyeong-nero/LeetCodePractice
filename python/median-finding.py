def median(arr):
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
        return less + eq + median(large)
    elif len(less) > len(large):
        return median(less) + eq + large
    else:
        return arr

def real_median(arr):
    arr.sort()
    print("real_ans : ", arr[len(arr) // 2])

def my_median(arr):
    a = median(arr)
    if len(arr) % 2 == 0:
        print("my_ans : ", a[len(a) // 2])
        print("my_ans : ", a[len(a) // 2 + 1])
    else: 
        print("my_ans : ", a[len(a) // 2])

test = [20, 10, 11, 19, 9, 3, 2, 19, 10, 3, 200, 10, 1, 2, 12, 6, 120, 1, 1, 1, 123]
my_median(test)
real_median(test)
