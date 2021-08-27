package leetcode;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] arr = new int[][]{
                {0, 0, 2, 2}, {1, 0, 2, 3}, {1, 0, 3, 1}
        };
        System.out.println(sol.UScheck2("aaa", "aa"));
        System.out.println(sol.UScheck2("cb", "aabbcc"));
        System.out.println(sol.findLUSlength(new String[]{"aabbcc", "aabbcc", "bc", "bcc", "aabbccc"}));
        System.out.println(sol.findLUSlength(new String[]{"aaa", "aaa", "aa"}));
    }
}
