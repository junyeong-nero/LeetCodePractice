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
        System.out.println(sol.stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
        System.out.println(sol.stringMatching(new String[]{"leetcode", "et", "code"}));
        System.out.println(sol.stringMatching(new String[]{"blue", "green", "bu"}));

    }
}
