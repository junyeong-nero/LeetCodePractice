from typing import List

class Solution:
    def __init__(self):
        pass

    def smallestEqual(self, nums: List[int]) -> int:
        for i in range(len(nums)):
            if i % 10 == nums[i]:
                return i
        return -1

if __name__ == "__main__":
    sol = Solution()
    print(sol.smallestEqual([0, 1, 2]))