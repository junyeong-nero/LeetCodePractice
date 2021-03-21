package leetcode;

import java.util.*;
import java.util.function.Consumer;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = Collections.emptyList();
        if(digits.length() == 0)
            return res;
        char[] sp = digits.toCharArray();
        for (char s : sp) {
            res = _letterCombination(res, s);
        }
        return res;
    }

    public List<String> _letterCombination(List<String> arr, char target) {
        Map<Character, List<String>> map = new HashMap<>();
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));

        if(arr.size() == 0)
            return map.get(target);

        List<String> temp = map.get(target);
        ArrayList<String> res = new ArrayList<>();
        for (String s : temp) {
            for (String t : arr) {
                res.add(t + s);
            }
        }
        return res;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode d = head, res = new ListNode(), dummy = res;
        ArrayList<Integer> arr = new ArrayList<>();
        int count = 0;
        while (true) {
            if (count < k) {
                if(d == null)
                    break;
                arr.add(d.val);
                d = d.next;
                count++;
            } else {
                for (int j = arr.size() - 1; j >= 0; j--) {
                    dummy.next = new ListNode(arr.get(j));
                    dummy = dummy.next;
                }
                arr.clear();
                count = 0;
            }
        }
        for (int i = 0; i < arr.size(); i++) {
            dummy.next = new ListNode(arr.get(i));
            dummy = dummy.next;
        }
        return res.next;
    }

    public List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                int sec = target - (arr[i] + arr[j]);
                int x = j + 1, y = arr.length - 1;
                while (x < y) {
                    if(arr[x] + arr[y] == sec) {
                        list.add(Arrays.asList(arr[i], arr[j], arr[x], arr[y]));
                        x++;
                        y--;
                        while(x + 1 < arr.length && arr[x] == arr[x - 1]) x++;
                        while(y - 1 > 0 && arr[y] == arr[y + 1]) y--;
                    } else if (arr[x] + arr[y] > sec) {
                        y--;
                    } else {
                        x++;
                    }
                }
                while(j + 1 < arr.length && arr[j] == arr[j + 1]) j++;
            }
            while(i + 1 < arr.length && arr[i] == arr[i + 1]) i++;
        }
        return list;
    }

    public int romanToInt(String s) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int l = s.length();
        if(l == 0)
            return 0;
        for (int i = 0; i < values.length; i++) {
            if (s.substring(0, 1).equals(romanSymbols[i])) {
                return values[i] + romanToInt(s.substring(1));
            } else if (l >= 2 && s.substring(0, 2).equals(romanSymbols[i])) {
                return values[i] + romanToInt(s.substring(2));
            }
        }
        return 0;
    }

    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num = num - values[i];
                result.append(romanSymbols[i]);
            }
        }
        return result.toString();
    }

/*
    4ms
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        while (num != 0) {
            int target = num % 10;
            if (count == 3) {
                builder.append("M".repeat(target));
            } else {
                char[] char_i = {'I', 'X', 'C', 'M'};
                char[] char_v = {'V', 'L', 'D'};
                if (target == 9) {
                    builder.append(char_i[count + 1]);
                    builder.append(char_i[count]);
                } else if (target == 4) {
                    builder.append(char_v[count]);
                    builder.append(char_i[count]);
                } else if (target >= 5) {
                    builder.append(String.valueOf(char_i[count]).repeat(target - 5));
                    builder.append(char_v[count]);
                } else {
                    builder.append(String.valueOf(char_i[count]).repeat(target));
                }
            }
            count++;
            num /= 10;
        }
        return builder.reverse().toString();
    }
*/

    public int maxArea(int[] arr) {
        int a, b, res = 0;
        int i = 0, j = arr.length - 1;
        do {
            a = arr[i];
            b = arr[j];
            res = Math.max(res, Math.min(a, b) * (j - i));

            if (a < b) {
                while (i < arr.length && arr[i] <= a) i++;
            } else {
                while (j > 0 && arr[j] <= b) j--;
            }
        } while (i != arr.length && j != 0 && i < j);
        return res;
    }

/*    public int maxArea(int[] arr) {
        int res = 0;
        for (int target : arr) {
            int a = 0;
            int b = arr.length - 1;
            while (arr[a] < target) a++;
            while (arr[b] < target) b--;
            if (a < b)
                res = Math.max(res, target * (b - a));
        }
        return res;
    }*/

    // start with maxArea(arr, 0)
    public int maxArea(int[] arr, int start) {
        int target;
        if(arr.length - 1 >= start)
            target = arr[start];
        else
            return 0;
        int res = 0;
        for (int i = arr.length - 1; i > 0; i--)
            res = Math.max(res, Math.min(arr[i], target) * (i - start));
        return Math.max(res, maxArea(arr, start + 1));
    }

    public boolean isMatch(String s, String p) {
        return s.equals(p);
    }

    public boolean isPalindrome(int x) {
        if (x >= 0) {
            int cur = 0;
            int num = x;
            while (num != 0){
                cur = cur * 10 + num % 10;
                num /= 10;
            }
            return cur == x;
        } else
            return false;
    }

    public int check2(String str) {
        int res = 0;
        long temp = Long.parseLong(str);
        if(temp > Integer.MAX_VALUE)
            res = Integer.MAX_VALUE;
        else if(temp < Integer.MIN_VALUE)
            res = Integer.MIN_VALUE;
        else
            res = Long.valueOf(temp).intValue();
        return res;
    }

    public int myAtoi(String s) {
        int res = 0, i;
        char[] arr = s.toCharArray();
        boolean symbol = false;

        if(s.length() == 0)
            return 0;

        StringBuilder builder = new StringBuilder();
        for (i = 0; i < arr.length; i++) {
            char c = arr[i];
            if(builder.length() == 0) {
                if ((c >= '0' && c <= '9') || c == '+' || c == '-') {
                    if(c == '+' || c == '-')
                        symbol = true;
                    builder.append(c);
                } else if (c != ' ')
                    break;
            } else {
                if (c >= '0' && c <= '9')
                    builder.append(c);
                else if (c == ' ' || c == '.') {
                    res = check2(builder.toString());
                    break;
                } else if (c == '+' || c == '-') {
                    if (symbol)
                        break;
                    else
                        symbol = true;
                } else {
                    break;
                }
            }
        }
        if (i == arr.length)
            res = check2(builder.toString());
        return res;
    }

    public String convert(String s, int numRows) {
        StringBuilder builder = new StringBuilder();
        char[] arr = s.toCharArray();
        if(numRows == 1)
            return s;
        for (int i = 0; i < numRows; i++) {
            int n = (numRows - i - 1) * 2;
            int n2 = i * 2;
            int j = i;

            if(j >= arr.length)
                break;
            builder.append(arr[j]);

            if(n == 0 && n2 == 0)
                continue;
            while(true) {
                if (n != 0) {
                    j += n;
                    if(j < arr.length)
                        builder.append(arr[j]);
                    else break;
                }

                if(n2 != 0) {
                    j += n2;
                    if(j < arr.length)
                        builder.append(arr[j]);
                    else break;
                }
            }
        }
        return builder.toString();
    }

    public int reverse(int x) {
        double res = 0;
        int neg = x > 0 ? 1 : -1;
        int d = Math.abs(x), count = 1;
        int size = String.valueOf(d).length();
        while (d != 0) {
            res += (d % 10) * Math.pow(10, size - count++);
            d /= 10;
        }
        res *= neg;
        if(res <= Integer.MAX_VALUE && res >= Integer.MIN_VALUE)
            return Double.valueOf(res).intValue();
        else
            return 0;
    }

    private int[] res = new int[]{0, 1};
    private int size = 1;
    public String longestPalindrome(String s) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length - 1; i++) {
            check(arr, i, i);
            if(arr[i] == arr[i + 1]) {
                check(arr, i, i + 1);
            }
        }
        return s.substring(res[0], res[1]);
    }

    public void check(char[] arr, int start, int end) {
        while (start >= 0 && end <= arr.length - 1 && arr[start] == arr[end]) {
            start--;
            end++;
        }
        if (size < end - start) {
            res = new int[]{start + 1, end};
            size = end - start;
        }
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