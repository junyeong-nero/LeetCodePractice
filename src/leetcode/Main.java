package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] arr2 = {"", ""};
        System.out.println("sol1 : " + sol.groupAnagrams(arr));
        System.out.println("sol1 : " + sol.groupAnagrams(arr2));
    }

}
