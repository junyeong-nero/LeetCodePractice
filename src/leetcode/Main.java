package leetcode;

import DataStructure.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode res = sol.insertIntoBST(new TreeNode(), 5);
        System.out.println(res.val);
    }
}
