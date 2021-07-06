package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] tmp = new int[][]{
                {1, 2},
                {3, 4}
        };
        System.out.println(Arrays.deepToString(sol.matrixReshape(tmp, 4, 1)));
        System.out.println(sol.consecutiveNumbersSum(79932));

//        if(sol.consecutiveNumberSum(79932, 62831))
//            System.out.println("wow");
    }
}
