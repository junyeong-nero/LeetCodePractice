package leetcode;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        // 3, 0, 0, 4
        System.out.println(sol.longestOnes(arr, 2));


        int[] arr2 = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        // 0, [2, 0, 3, 2], 0, 0, 4
        System.out.println(sol.longestOnes(arr2, 3));

//        System.out.println(sol.champagneTower(2, 1, 1));
    }
}
