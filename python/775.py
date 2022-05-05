inversion = 0

def fun(arr):
	a = local_count(arr)
	merge_sort(arr)
	return local_count(arr) == inversion

def local_count(arr):
	n = 0
	for i in range(len(arr) - 1):
		if arr[i] > arr[i + 1]:
			n += 1
	return n

# merge sort
def merge_sort(arr):
    if len(arr) < 2:
        return arr

    mid = len(arr) // 2
    low_arr = merge_sort(arr[:mid])
    high_arr = merge_sort(arr[mid:])

    merged_arr = []
    l = h = 0
    while l < len(low_arr) and h < len(high_arr):
        if low_arr[l] < high_arr[h]:
            merged_arr.append(low_arr[l])
            l += 1
        else:
			inversion += len(high_arr) - h
			merged_arr.append(high_arr[h])
			h += 1
	merged_arr += low_arr[l:]
	merged_arr += high_arr[h:]
	return merged_arr


test = [1, 0, 2]
fun(test)
