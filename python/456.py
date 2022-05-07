from typing import List

class Solution:

    res = False

    def merge(self, arr1, arr2):
        i = j = 0
        res = []
        while i < len(arr1) and j < len(arr2):
            if arr1[i] < arr2[j]:
                if i < len(arr1):
                    self.res = True
                res.append(arr1[i])
                i += 1
            else:
                res.append(arr2[j])
                j += 1

        if i == len(arr1):
            for k in range(j, len(arr2)):
                res.append(arr2[k])
        if j == len(arr2):
            for k in range(i, len(arr1)):
                res.append(arr1[k])
        return res


    def mergesort(self, arr):
        n = len(arr)
        if n == 1:
            return arr
        mid = len(arr) // 2
        left = self.mergesort(arr[:mid])
        right = self.mergesort(arr[mid:])
        return self.merge(left, right) 


    def find132pattern(self, nums: List[int]) -> bool:
        n = len(nums)
        if n <= 2:
            return False
        
        for i in range(n - 2):
            m = -10^9
            for j in range(i + 1, n):
                # print(j)
                if nums[j] <= nums[i]:
                    continue
                elif nums[j] > m:
                    m = nums[j]
                elif nums[j] < m:
                    # print(m, i, j)
                    return True
                
        return False


test = [1,2,3,4,-4,-3,-5,-1]
print(Solution().find132pattern(test))