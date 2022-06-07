class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        L = len(triangle)
        dp = []
        for i in range(L):
            dp.append([999] * (i + 1))
        dp[0][0] = triangle[0][0]
        for i in range(1, L):
            N = len(dp[i])
            if i >= 1:
                dp[i][0] = dp[i - 1][0] + triangle[i][0]
                dp[i][N - 1] = dp[i - 1][N - 2] + triangle[i][N - 1]    
            for j in range(1, N - 1):
                dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j]
        print(dp)
        return min(dp[L - 1])