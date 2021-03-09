package leetcode;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Solution {

    public String longestPalindrome(String s) {
        String res = s.substring(0, 1);
        int len = -1;
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = arr[i];
            if (map.containsKey(c)) {
                String temp = s.substring(map.get(c), i + 1);
                if (temp.length() > len && check(temp)) {
                    len = temp.length();
                    res = temp;
                }
            }
            map.put(c, i);
        }
        return res;
    }

    public boolean check(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            if(arr[i] != arr[arr.length - 1 - i])
                return false;
        }
        return true;
    }

    public double findMedianSortedArrays(int[] arr, int[] arr2) {
        int al1 = arr.length;
        int al2 = arr2.length;
        int v1 = 0, v2 = 0;

        // 5 -> 2, 4 -> 1, 2
        int len = al1 + al2;
        int t1, t2;
        t2 = len / 2;
        if (len % 2 == 0)
            t1 = len / 2 - 1;
        else
            t1 = t2;

        int p = 0;
        int i = 0, j = 0;
        boolean type;
        while (!(i == al1 && j == al2)) {
            int ai = i == al1 ? Integer.MAX_VALUE : arr[i];
            int aj = j == al2 ? Integer.MAX_VALUE : arr2[j];
            type = ai < aj;
            int value = Math.min(ai, aj);

//            System.out.println(value);
            if(p == t1) v1 = value;
            if(p == t2) {
                v2 = value;
                return (v1 + v2) / 2F;
            }
            p++;
            if(type) i++;
            else j++;
        }
        return 0;
    }



    public int lengthOfLongestSubstring(String s) {
        int res = -1, i = 0, j;
        if (s.length() <= 1)
            return s.length();

        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put(chars[i], i);

        for (j = 1; j < s.length(); j++) {
            if (map.containsKey(chars[j])) {
                int target = map.get(chars[j]);
                while (i <= target) {
                    map.remove(chars[i]);
                    i++;
                }
            }
            res = Math.max(res, j - i + 1);
            map.put(chars[j], j);
        }
        return res;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy, res = new ListNode(0);
        dummy = res;
        while (l1 != null || l2 != null) {
            int temp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + dummy.val;
            dummy.val = temp % 10;
            if(temp >= 10)
                dummy.next = new ListNode(temp / 10);
            dummy = dummy.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {              // skip same result
                continue;
            }
            int j = i + 1, k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                    while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result
                } else if (nums[j] + nums[k] > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum_1(int[] arr) {
        HashSet<List<Integer>> list = new HashSet<>();
        Consumer<Integer> p = (index) -> {
            int target = arr[index];
            for (int i = index + 1; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] + arr[j] == -target) {
                        List<Integer> a = Arrays.asList(target, arr[i], arr[j]);
                        a.sort(Integer::compareTo);
                        list.add(a);
                    }
                }
            }
        };
        for (int i = 0; i < arr.length; i++) p.accept(i);
        return new ArrayList<>(list);
    }

    public List<List<Integer>> threeSum_2(int[] arr) {
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int key = arr[i] + arr[j];
                List<List<Integer>> l = new ArrayList<>();
                if(map.containsKey(key))
                    l = map.get(key);

                l.add(Arrays.asList(i, j));
                map.put(key, l);
            }
        }

        Set<List<Integer>> list = new HashSet<>();
        for (int index = 0; index < arr.length; index++) {
            int value = arr[index];
            if (map.containsKey(-value)) {
                List<List<Integer>> l = map.get(-value);
                for (List<Integer> a : l) {

                    if(a.contains(index))
                        break;

                    List<Integer> b = new ArrayList<>();
                    a.stream().forEach(integer -> b.add(arr[integer]));
                    b.add(value);
                    b.sort(Integer::compareTo);
                    list.add(b);
                }
            }
        }

        return new ArrayList<>(list);
    }
}