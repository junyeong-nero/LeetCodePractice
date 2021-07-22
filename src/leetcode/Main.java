package leetcode;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.pushDominoes("RR.L"));
        System.out.println(sol.pushDominoes(".L.R...LR..L.."));
        System.out.println(sol.pushDominoes("R.R.L"));
    }
}
