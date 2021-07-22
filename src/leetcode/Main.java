package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.invalidTransactions(new String[]{
                "alice,20,800,mtv","bob,50,1200,mtv"
        }));
    }
}
