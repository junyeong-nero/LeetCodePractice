package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution.ListNode l = new Solution.ListNode(1, new Solution.ListNode(2, new Solution.ListNode(3, new Solution.ListNode(4, new Solution.ListNode(5)))));
//        Solution.ListNode l = new Solution.ListNode(1, new Solution.ListNode(2, new Solution.ListNode(3)));
        Solution sol = new Solution();
        Solution.ListNode res = sol.reverseKGroup(l, 3);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
