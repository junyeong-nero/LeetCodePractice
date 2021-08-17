package leetcode;

import java.util.ArrayList;

class NumArray {

    private ArrayList<Integer> list = new ArrayList<>();

    public NumArray(int[] nums) {
        list.clear();
        for (int n : nums)
            list.add(n);
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i < right; i++)
            sum += list.get(i);
        return sum;
    }
}