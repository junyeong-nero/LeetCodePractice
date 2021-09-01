package leetcode;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = new int[]{3, 9, 7, 1, 2, 3};
        int[] arr2 = new int[]{1, 2, 3, 6, 8, 9 };
        System.out.println(Solution.numberOfWeeks(arr));
        System.out.println(Solution.numberOfWeeks(arr2));
    }
}
