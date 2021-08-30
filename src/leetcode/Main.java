package leetcode;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = new int[][]{
                {0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}
        };
        System.out.println(sol.minPatches(new int[]{1, 2, 3, 9}, Integer.MAX_VALUE));
    }
}
