package leetcode;

import javax.xml.stream.events.EndDocument;
import java.util.*;

public class Solution {

    public void commitForRestDay(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("today is sunday");
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, List.of(), 0, targetSum);
        return res;
    }

    public void dfs(TreeNode root, List<List<Integer>> res, List<Integer> list, int current, int target) {
        if (root == null) return;
        List<Integer> temp = new ArrayList<>(list);
        temp.add(root.val);
        current += root.val;
        if (root.right == null && root.left == null) {
            if (current == target)
                res.add(temp);
            return;
        }
        dfs(root.right, res, temp, current, target);
        dfs(root.left, res, temp, current, target);
    }

    public int findNthDigit(int n) {
        long cond = 0;
        for (int k = 1; k < 10; k++) {
            long t = (long) Math.pow(10, k - 1);
            // 10
            // 2 * 90
            // 3 * 900
            long cond1 = k * (t * 10 - (t == 1 ? 0 : t));
//            System.out.println("cond : " + cond1);
            if (n >= cond + cond1) {
                cond += cond1;
                continue;
            }
            long num = (n - cond) / k + (t == 1 ? 0 : t); // nth number
            int digit = (int) ((n - cond) % k);
            int[] arr = new int[k];
            for (int i = 0; i < k; i++) {
                arr[k - 1 - i] = (int) (num % 10);
                num /= 10;
            }
            System.out.println(Arrays.toString(arr));
            return arr[digit];
        }
        return 0;
    }

    public int findNthDigit2(int n) {
        int len = 1, i = 1;
        long range = 9;
        while(n > len * range){
            n -= len * range;
            len++;
            range *= 10;
            i *= 10;
        }

        i += (n - 1) / len;
        String s = Integer.toString(i);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }

    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(arr);
        subsetWithDup(arr, res, List.of(), 0);
        return new ArrayList<>(res);
    }

    public void subsetWithDup(int[] arr, Set<List<Integer>> res, List<Integer> current, int index) {
        if (arr.length == index) {
            res.add(current);
            return;
        }
        subsetWithDup(arr, res, current, index + 1);
        List<Integer> temp = new ArrayList<>(current);
        temp.add(arr[index]);
        subsetWithDup(arr, res, temp, index + 1);
    }

    public String removeDuplicates(String s, int k) {
        int[] map = new int[26];
        Arrays.fill(map, 0);
        ArrayList<Character> target = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int n = s.length();
        boolean check = true;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            map[index]++;
            if (map[index] >= k) {
                target.add(s.charAt(i));
                check = false;
            }
        }
        if (check) return s;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!target.contains(c))
                builder.append(c);
        }
        return removeDuplicates(builder.toString(), k);
    }

    public int overlap(int[][] img1, int[][] img2, int x, int y) {
            int n = img1.length;
            int res = 0;
        int[][] point1 = new int[2][2];
        int[][] point2 = new int[2][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    point1[0][0] = Math.min(point1[0][0], i);
                    point1[0][1] = Math.min(point1[0][1], i);
                    point1[1][0] = Math.max(point1[1][0], i);
                    point1[1][1] = Math.max(point1[1][1], i);
                }
                if (img2[i][j] == 1) {
                    point2[0][0] = Math.min(point2[0][0], i);
                    point2[0][1] = Math.min(point2[0][1], i);
                    point2[1][0] = Math.max(point2[1][0], i);
                    point2[1][1] = Math.max(point2[1][1], i);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (img1[i][j] == 1) {
                    point1[0][0] = Math.min(point1[0][0], i);
                    point1[0][1] = Math.min(point1[0][1], i);
                    point1[1][0] = Math.max(point1[1][0], i);
                    point1[1][1] = Math.max(point1[1][1], i);
                }
                if (img2[i][j] == 1) {
                    point2[0][0] = Math.min(point2[0][0], i);
                    point2[0][1] = Math.min(point2[0][1], i);
                    point2[1][0] = Math.max(point2[1][0], i);
                    point2[1][1] = Math.max(point2[1][1], i);
                }
            }
        }
        return res;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int areaIndex = 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int size = fillIsland(grid, i, j, areaIndex);
                map.put(areaIndex, size);
                areaIndex++;
            }
        }

        int res = map.getOrDefault(2,0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighbors = new HashSet<>();
                    neighbors.add(i > 0 ? grid[i - 1][j] : 0);
                    neighbors.add(j > 0 ? grid[i][j - 1] : 0);
                    neighbors.add(i < n - 1 ? grid[i + 1][j] : 0);
                    neighbors.add(j < n - 1 ? grid[i][j + 1] : 0);
                    int area = 1;
                    for (int neighbor : neighbors) {
                        area += map.get(neighbor);
                    }
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    public int fillIsland(int[][] grid, int x, int y, int fill) {
        int n = grid.length;
        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] != 1)
            return 0;
        grid[x][y] = fill;

        int res = 1;
        res += fillIsland(grid, x + 1, y, fill);
        res += fillIsland(grid, x - 1, y, fill);
        res += fillIsland(grid, x, y + 1, fill);
        res += fillIsland(grid, x, y - 1, fill);
        return res;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> temp = new ArrayList<>();
        if (wordList.contains(endWord)) {
            _findLadders(beginWord, endWord, wordList, List.of(beginWord), temp);
        } else {
            return temp;
        }
        int min = Integer.MAX_VALUE;
        for (List<String> list : temp) {
            min = Math.min(min, list.size());
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : temp) {
            if (list.size() == min) res.add(list);
        }
        return res;
    }

    public int diff(String a, String b) {
        int len = a.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i))
                count++;
        }
        return count;
    }

    public void _findLadders(String beginWord, String endWord, List<String> wordList, List<String> current, List<List<String>> res) {
        if (diff(beginWord, endWord) == 1) {
            current.add(endWord);
            res.add(current);
            return;
        }
        for (String s : wordList) {
            if (diff(beginWord, s) == 1) {
                List<String> temp = new ArrayList<>(wordList);
                temp.remove(s);
                List<String> tempCurrent = new ArrayList<>(current);
                tempCurrent.add(s);
                _findLadders(s, endWord, temp, tempCurrent, res);
            }
        }
    }

    // 1
    // 2, 1
    // 2, 3, 1
    // 2, 1, 4, 3
    // 3, 1, 2, 5, 4
    public int[] beautifulArray(int N) {
        int[] res = new int[N];
        if (N == 1) {
            return new int[]{1};
        } else if (N == 2) {
            return new int[]{1, 2};
        } else {
            int[] odds = beautifulArray((N + 1) / 2);
            int[] even = beautifulArray(N / 2);
            for (int i = 0; i < odds.length; i++) {
                res[i] = odds[i] * 2 - 1;
            }
            for (int j = 0; j < even.length; j++) {
                res[odds.length + j] = even[j] * 2;
            }
        }
        return res;
//        int[] res = new int[n];
//        int target = (n + 1) / 2;
//        if (n % 2 != 0) {
//            res[0] = target;
//            int temp = 1;
//            for (int i = 1; temp < target && i < n; i += 2) {
//                res[i++] = temp++;
//                res[i++] = temp++;
//            }
//
//            temp = n;
//            for (int i = 3; i < n; i += 2) {
//                res[i++] = temp--;
//                res[i++] = temp--;
//            }
//        } else {
//            int temp = 1;
//            for (int i = 0; i < n; i += 2) {
//                temp += 2;
//                res[i++] = temp - 1;
//                res[i++] = temp - 2;
//            }
//
//            temp = n;
//            for (int i = 2; temp > target && i < n; i += 2) {
//                res[i++] = temp--;
//                res[i++] = temp--;
//            }
//        }
//        return res;
    }

    public int countConsistentStrings(String allowed, String[] words) {
        char[] temp = allowed.toCharArray();
        ArrayList<Character> list = new ArrayList<>();
        for (char c : temp) list.add(c);

        int res = 0;
        for (String s : words) {
            boolean b = true;
            char[] arr = s.toCharArray();
            for (char c : arr) {
                if (!list.contains(c)) {
                    b = false;
                }
            }
            if (b)
                res++;
        }
        return res;
    }

    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        root.left = left;
        root.right = right;
        if (left == null && right == null) {
            if (root.val == 1) return root;
            else return null;
        }
        return root;
    }

    public int partitionDisjoint(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            boolean b = true;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < max) {
                    b = false;
                    break;
                }
            }
            if (b)
                return i + 1;
        }
        return 0;
    }

    public static class Transaction {
        String name;
        String city;
        int time;
        int amount;
        String info;
        boolean valid = true;

        public Transaction(String info) {
            this.info = info;
            String[] split = info.split(",");
            name = split[0];
            time = Integer.parseInt(split[1]);
            amount = Integer.parseInt(split[2]);
            city = split[3];
        }

        public boolean isValid(Transaction other) {
            if (other.name.equals(this.name)
                    && Math.abs(other.time - this.time) <= 60
                    && !other.city.equals(this.city))
                return false;
            else
                return true;
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        int len = transactions.length;
        Transaction[] arr = new Transaction[len];
        for (int i = 0; i < len; i++) {
            arr[i] = new Transaction(transactions[i]);
        }
        for (int i = 0; i < len; i++) {
            if (arr[i].amount > 1000)
                arr[i].valid = false;
            for (int j = i + 1; j < len; j++) {
                if (!arr[i].isValid(arr[j])) {
                    arr[i].valid = false;
                    arr[j].valid = false;
                    break;
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (Transaction t : arr) {
            if (!t.valid)
                res.add(t.info);
        }
        return res;
    }

    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];
        for (int[] arr : indices) {
            int row = arr[0];
            int col = arr[1];

            for (int i = 0; i < n; i++) {
                matrix[row][i]++;
            }
            for (int j = 0; j < m; j++) {
                matrix[j][col]++;
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] % 2 != 0) {
                    res++;
                }
            }
        }
        return res;
    }

    public String pushDominoes(String dominoes) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < dominoes.length(); i++) {
            char c = dominoes.charAt(i);
            if (c == '.') {
                int left = i - 1;
                int right = i + 1;
                char cleft = '.';
                char cright = '.';

                while (left > 0 && dominoes.charAt(left) == '.') left--;
                while (right < dominoes.length() && dominoes.charAt(right) == '.') right++;
                if (left >= 0) cleft = dominoes.charAt(left);
                if (right < dominoes.length()) cright = dominoes.charAt(right);

//                System.out.printf("%d%n", i);
//                System.out.printf("%d, %c%n", left, cleft);
//                System.out.printf("%d, %c%n", right, cright);
                if (cleft == '.') {
                    if (cright == 'L') builder.append(cright);
                    else               builder.append('.');
                } else if (cright == '.') {
                    if (cleft == 'R') builder.append(cleft);
                    else              builder.append('.');
                } else {
                    if (cleft == 'L' && cright == 'R') builder.append('.');
                    else if (cleft == 'R' && cright == 'L') {
                        int dl = i - left;
                        int dr = right - i;
                        if (dl == dr)       builder.append('.');
                        else if (dl > dr)   builder.append(cright);
                        else                builder.append(cleft);
                    }
                    else if(cleft == 'R' && cright == 'R') builder.append('R');
                    else if(cleft == 'L' && cright == 'L') builder.append('L');
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;

        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left != null && right != null)
            return root;
        if (left != null) return left;
        return right;
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length - k + 1];
        PriorityQueue<Integer> left = new PriorityQueue<>(1, Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>(1);

        for(int i = 0; i < nums.length; i++) {
            if(left.size() <= right.size()) {
                right.add(nums[i]);
                left.add(right.remove());
            } else {
                left.add(nums[i]);
                right.add(left.remove());
            }

            if(left.size() + right.size() == k) {
                double median;
                if(left.size() == right.size()) {
                    median = (double) ((long)left.peek() + (long)right.peek()) / 2;
                } else {
                    median = (double) left.peek();
                }

                int start = i - k + 1;
                result[start] = median;
                if(!left.remove(nums[start])) {
                    right.remove(nums[start]);
                }
            }
        }
        return result;
    }

//    public double getMedian(Queue<Integer> queue) {
//        ArrayList<Integer> arr = new ArrayList<>(queue);
//        arr.sort(Integer::compareTo);
//        if (arr.size() % 2 == 0) {
//            return ((double)arr.get(arr.size() / 2 - 1) + (double)arr.get(arr.size() / 2)) / 2.0f;
//        } else {
//            return (double) arr.get(arr.size() / 2);
//        }
//    }
//
//    public double[] medianSlidingWindow(int[] arr, int k) {
//        Queue<Integer> queue = new LinkedList<>();
//        double[] res = new double[arr.length - k + 1];
//        for (int i = 0; i < k; i++)
//            queue.add(arr[i]);
//
//        int count = 0;
//        for (int i = k; i < arr.length; i++) {
//            res[count++] = getMedian(queue);
//            queue.remove();
//            queue.add(arr[i]);
//        }
//        res[count] = getMedian(queue);
//        return res;
//    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode();
        ListNode temp = res;
        int count = 0;
        int[] arr = new int[k];
        while (head != null) {
            arr[count] = head.val;
            count++;
            head = head.next;
            if (count == k) {
                for (int i = k - 1; i >= 0; i--) {
                    temp.next = new ListNode(arr[i]);
                    temp = temp.next;
                }
                arr = new int[k];
                count = 0;
            }
        }
        for (int i = 0; i < k; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return res.next;
    }

    // |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int res = Math.abs(arr1[0] - arr1[1]) + Math.abs(arr2[0] - arr2[1]) + 1;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                res = Math.max(res, Math.abs(arr1[i] - arr1[j]) + Math.abs(arr2[i] - arr2[j]) + Math.abs(i - j));
            }
        }
        return res;
    }

    // n -> [1, 500]
    public String generateTheString(int n) {
        if (n % 2 == 0) {
            return "a".repeat(n - 1) + 'b';
        } else {
            return "a".repeat(n);
        }
    }

    public List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                int temp = target - (arr[i] + arr[j]);
                int x = j + 1, y = arr.length - 1;
                while (x < y) {
                    if (arr[x] + arr[y] == temp) {
                        list.add(Arrays.asList(arr[i], arr[j], arr[x], arr[y]));
                        x++;
                        y--;
                        while (x + 1 < arr.length && arr[x] == arr[x - 1]) x++;
                        while (y - 1 > 0 && arr[y] == arr[y + 1]) y--;
                    } else if (arr[x] + arr[y] > temp) {
                        y--;
                    } else {
                        x++;
                    }
                }
                while (j + 1 < arr.length && arr[j] == arr[j + 1]) j++;
            }
            while (i + 1 < arr.length && arr[i] == arr[i + 1]) i++;
        }
        return list;
    }

    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    public boolean canBeTriangle(int a, int b, int c) {
        int large = Math.max(a, Math.max(b, c));
        // large < sum of others => large - sum of others <  90
        int sum_of_others = a + b + c - large;
        return large < sum_of_others;
    }

    // 2, 2, 3, 4
    // ^        ^
    public int triangleNumber(int[] arr) {
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (canBeTriangle(arr[i], arr[j], arr[k])) {
//                        System.out.printf("%d|%d|%d%n", arr[i], arr[j], arr[k]);
                        res++;
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }

    public int triangleNumber2(int[] arr) {
        int count = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length-2; i++) {
            if(arr[i] != 0) {
                int k = i + 2;
                for (int j = i + 1; j < arr.length - 1; j++) {
                    while (k < arr.length && arr[i] + arr[j] > arr[k]) {
                        k++;
                    }
                    // cause we have k++ when we get out of the loop
                    // so we have to -1 while we count the number
                    count += k - 1 - j;
                }
            }
        }
        return count;
    }

    // 96 * 9 + 96 * 9

    public int numDecodings(String s) {
        /* initial conditions */
        long[] dp = new long[s.length()+1];
        dp[0] = 1;
        if(s.charAt(0) == '0'){
            return 0;
        }
        dp[1] = (s.charAt(0) == '*') ? 9 : 1;

        /* bottom up method */
        for(int i = 2; i <= s.length(); i++){
            char first = s.charAt(i-2);
            char second = s.charAt(i-1);

            // For dp[i-1]
            if(second == '*'){
                dp[i] += 9*dp[i-1];
            }else if(second > '0'){
                dp[i] += dp[i-1];
            }

            // For dp[i-2]
            if(first == '*'){
                if(second == '*'){
                    dp[i] += 15*dp[i-2];
                }else if(second <= '6'){
                    dp[i] += 2*dp[i-2];
                }else{
                    dp[i] += dp[i-2];
                }
            }else if(first == '1' || first == '2'){
                if(second == '*'){
                    if(first == '1'){
                        dp[i] += 9*dp[i-2];
                    }else{ // first == '2'
                        dp[i] += 6*dp[i-2];
                    }
                }else if( ((first-'0')*10 + (second-'0')) <= 26 ){
                    dp[i] += dp[i-2];
                }
            }

            dp[i] %= 1000000007;
        }
        /* Return */
        return (int)dp[s.length()];
    }

    public int numDecodings2(String s) {
        int n = s.length();
        if (n == 1) {
            char c = s.charAt(0);
            if (c == '*') return 9;
            if (c >= '1' && c <= '9') return 1;
            return 0;
        } else if (n == 2) {
            char c1 = s.charAt(0);
            char c2 = s.charAt(1);
            int k = 0;
            if (c1 == '1') {
                if (c2 == '*') k = 9;
                if (c2 >= '0' && c2 <= '9') k = 1;
            }
            if (c1 == '2') {
                if (c2 == '*') k = 6;
                if (c2 >= '0' && c2 <= '6') k = 1;
            }
            if (c1 == '*') {
                if (c2 >= '0' && c2 <= '6') k = 2; // 13, 23
                if (c2 >= '7' && c2 <= '9') k = 1; // 19, (29 -> no)
                if (c2 == '*') k = 15;
            }

            int temp2 = numDecodings(s.substring(0, 1));
            temp2 *= numDecodings(s.substring(1));
            return k + temp2;

        } else if (n > 2) {
            int temp;
            temp = numDecodings(s.substring(0, 1));
            temp *= numDecodings(s.substring(1));

            int temp2;
            temp2 = numDecodings(s.substring(0, 2));
            temp2 *= numDecodings(s.substring(2));

            return temp + temp2;
        }
        return 0;
    }

    // 9 * 9 * 9 + 96 * 9 + 9 * 96

    public String customSortString(String order, String str) {
        int[] map = new int[26];
        int n = order.length();
        int m = str.length();
        Arrays.fill(map, 0);
        for (int i = 0; i < n; i++) {
            map[order.charAt(i) - 'a'] = n - i;
        }

        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(str.charAt(i));
        }
        list.sort((a, b) -> map[b - 'a'] - map[a - 'a']);

        StringBuilder builder = new StringBuilder();
        for (char c : list) {
            builder.append(c);
        }
        return builder.toString();
    }

    // O(log N) algorithm -> binary search?
    public int findPeakElement(int[] arr) {
        return findPeakElement(arr, 0, arr.length - 1);
    }

    public int findPeakElement(int[] arr, int start, int end) {
        if (start == end) return start;
        int mid = (start + end) / 2;
        int left = findPeakElement(arr, start, mid);
        int right = findPeakElement(arr, mid + 1, end);
        if (arr[left] > arr[mid]) mid = left;
        if (arr[right] > arr[mid]) mid = right;
        return mid;
    }

    // 계단 형식으로 코인을 넣는데, 마지막 줄에 남은 코인의   갯수를 구하여라.
    public int arrangeCoins(int n) {
        return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
    }

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> a = new Stack<>();
        Stack<Character> b = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '#') {
                if (!a.isEmpty()) a.pop();
            } else {
                a.add(c);
            }
        }

        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            if (c == '#') {
                if (!b.isEmpty()) b.pop();
            } else {
                b.add(c);
            }
        }
        return a.equals(b);
    }

//    public String reorganizeString(String s) {
//        int n = s.length();
//        int[] arr = new int[30];
//        Arrays.fill(arr, 0);
//        for (int i = 0; i < n; ++i) {
//            char c = s.charAt(i);
//            arr[c - 'a']++;
//            if (arr[c - 'a'] > (n + 1) / 2) {
//                return "";
//            }
//        }
//        StringBuilder builder = new StringBuilder();
//
//        int count = 0;
//        while (count < n) {
//            for (int i = 0; i < 26; i++) {
//                if (arr[i] > 0) {
//                    builder.append((char)(i + 'a'));
//                    arr[i]--;
//                    count++;
//                }
//            }
//        }
//        return builder.toString();
//    }

    public String reorganizeString(String s) {
        int n = s.length();
        int[] arr = new int[30];
        Arrays.fill(arr, 0);
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            arr[c - 'a']++;
            if (arr[c - 'a'] > (n + 1) / 2) {
                return "";
            }
        }
        List<Integer> index = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            if (arr[i] > 0) index.add(i);
        }
        index.sort((a, b) -> arr[b] - arr[a]);

        StringBuilder builder = new StringBuilder();
        int count = 0;
        while (count < n) {
            for (int i = 0; i < 26; i++) {
                int current = index.get(i);
                if (arr[current] > 0) {
                    builder.append((char) (current + 'a'));
                    arr[current]--;
                    count++;
                }
            }
        }
        return builder.toString();
    }

    public boolean isIsomorphic(String s, String t) {
        return isIsomorphic2(s, t) && isIsomorphic2(t, s);
    }

    public boolean isIsomorphic2(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            char d = t.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) != d) return false;
            } else {
                map.put(c, d);
            }
        }
        return true;
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int end = intervals[0][1];
        int count = 1;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }

//    public boolean overlapInterval(int[][] intervals, int n, int target_index) {
//        boolean temp = false;
//        if (n == intervals[target_index][1]) return true;
//        for (int i = 0; i < intervals.length; i++) {
//            int[] inv = intervals[i];
//            if (i != target_index && inv[0] == n) {
//                temp |= overlapInterval(intervals, inv[1], target_index);
//            }
//        }
//        return temp;
//    }
//
//    public int eraseOverlapIntervals(int[][] intervals) {
//        int res = 0;
//        for (int i = 0; i < intervals.length; i++) {
//            if (overlapInterval(intervals, intervals[i][0], i)) {
//                intervals[i][0] = Integer.MIN_VALUE;
//                intervals[i][1] = Integer.MAX_VALUE;
//                res++;
//            }
//        }
//        return res;
//    }

    public int findLengthOfLCIS(int[] arr) {
        int res = 1, len = 1, temp = arr[0];
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] > temp) {
                len++;
            } else {
                res = Math.max(res, len);
                len = 1;
            }
            temp = arr[i];
        }
        return Math.max(res, len);
    }

    public int lengthOfLIS(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) max = Math.max(max, dp[i]);
        return max;
    }

    int[] dp_lis;

    public int lengthOfLIS2(int[] arr) {
        dp_lis = new int[arr.length];
        Arrays.fill(dp_lis, -1);
        int res = 1;
        for (int i = 0; i < arr.length; ++i) {
            lengthOfLIS2(arr, i);
            res = Math.max(res, dp_lis[i]);
        }
        return res;
    }

    public void lengthOfLIS2(int[] arr, int start) {
        if (dp_lis[start] != -1) return;
        int res = 0;
        for (int i = start; i < arr.length; ++i) {
            if (arr[i] > arr[start]) {
                lengthOfLIS2(arr, i);
                res = Math.max(res, dp_lis[i]);
            }
        }
        dp_lis[start] = res + 1;
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res = sumSubmatrix(matrix, 0, 0, n, m);
        return res;
    }

    public int sumSubmatrix(int[][] matrix, int sx, int sy, int ex, int ey) {
        int sum = 0;
        for (int x = sx; x < ex; ++x) {
            for (int y = sy; y < ey; ++y) {
                sum += matrix[x][y];
            }
        }
        return sum;
    }

    public int kthSmallest2(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m * n];
        res[0] = matrix[0][0];
        for (int i = 1; i < m * n; i++) res[i] = matrix[i / n][i % n];
        Arrays.sort(res);
        return res[k - 1];
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] index = new int[n];
        int count = 0;
//        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) index[i] = 0;
        while (count != k) {
            int min = 0;
            for (int i = 1; i < n; ++i) {
                if (index[min] < n && index[i] < n && matrix[min][index[min]] >= matrix[i][index[i]])
                    min = i;
                if (index[min] >= n)
                    min = i;
            }
            count++;
//            list.add(matrix[min][index[min]]);
//            System.out.println(list);
            if (count == k) return matrix[min][index[min]];
            index[min]++;
        }
//        System.out.println(list);
        return matrix[0][0];
    }

    public int subtractProductAndSum(int n) {
        List<Integer> list = new ArrayList<>();
        while (n != 0) {
            list.add(n % 10);
            n /= 10;
        }
        int m = 1;
        for (int i : list) m *= i;

        int s = 0;
        for (int j : list) s += j;
        return m - s;
    }

    int[][] dp_min;

    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        dp_min = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp_min[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            minFallingPathSum(matrix, 0, i);
            res = Math.min(res, dp_min[0][i]);
        }
        return res;
    }

    public void minFallingPathSum(int[][] matrix, int x, int y) {
        if (x >= matrix.length || x < 0 || y >= matrix[0].length || y < 0)
            return;

        if (x == matrix.length - 1) {
            dp_min[x][y] = matrix[x][y];
            return;
        }
        if (dp_min[x][y] != Integer.MAX_VALUE)
            return;

        minFallingPathSum(matrix, x + 1, y - 1);
        minFallingPathSum(matrix, x + 1, y);
        minFallingPathSum(matrix, x + 1, y + 1);
        int temp = dp_min[x + 1][y];
        if (x + 1 < matrix.length && y - 1 >= 0 && y - 1 < matrix[0].length)
            temp = Math.min(temp, dp_min[x + 1][y - 1]);
        if (x + 1 < matrix.length && y + 1 < matrix[0].length)
            temp = Math.min(temp, dp_min[x + 1][y + 1]);

        dp_min[x][y] = matrix[x][y] + temp;
    }

    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int v : arr) {
            if (!map.containsKey(v)) map.put(v, 1);
            else map.put(v, map.get(v) + 1);
        }
        List<Integer> list = new ArrayList<>(map.values());
        list.sort((a, b) -> b - a);

        int sum = 0, res;
        for (res = 0; sum < arr.length / 2; ++res) sum += list.get(res);
        return res;
    }

    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) arr[i] = arr[i >> 1] + (i & 1);
        return arr;
    }

    public int consecutiveNumbersSum_shortener(int n) {
        int res = 0, tmp = 0;
        for (int i = 1; i <= n; ++i) {
            tmp += i;
            if (tmp > n) break;
            if ((n - tmp) % i == 0) ++res;
        }
        return res;
    }

    public int consecutiveNumbersSum(int n) {
        int res = 0;
        // x^2 + x - 2n;
        for (int i = 1; i <= n; i++) {
            if (i * (i + 1) > 2 * n) break;
            if (consecutiveNumbersSum(n, i)) {
                res++;
            }
        }
        return res;
    }

    public boolean consecutiveNumbersSum(int n, int k) {
        int tmp = n - k * (k + 1) / 2;
        if (tmp < 0) return false;
        return tmp % k == 0;
    }

    public List<String> stringMatching(String[] words) {
        List<String> list = new ArrayList<>();
        for (int j = 0; j < words.length; ++j) {
            for (int i = 0; i < words.length; ++i) {
                if (i != j && words[i].contains(words[j])) {
                    list.add(words[j]);
                    break;
                }
            }
        }
        return list;
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int column = mat[0].length;
        int[][] res = new int[r][c];
        int count = 0;
        if (row * column != r * c) return mat;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                res[count / c][count % c] = mat[i][j];
                count++;
            }
        }
        return res;
    }


    //    Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
//    Each vowel 'a' may only be followed by an 'e'.
//    Each vowel 'e' may only be followed by an 'a' or an 'i'.
//    Each vowel 'i' may not be followed by another 'i'.
//    Each vowel 'o' may only be followed by an 'i' or a 'u'.
//    Each vowel 'u' may only be followed by an 'a'.
    public int countVowelPermutation(int n) {
        int[][] dp = new int[n + 1][5];
        int mod = 1000000007;
        for (int i = 1; i <= n; i++) { // length
            for (int j = 0; j < 5; j++) { // a, e, i, o, u
                if (i == 1) dp[i][j] = 1;
                else {
                    int res = 0;
                    if (j == 0) {
                        res = (res + dp[i - 1][1]) % mod;
                    } else if (j == 1) {
                        res = (res + dp[i - 1][0]) % mod;
                        res = (res + dp[i - 1][2]) % mod;
                    } else if (j == 2) {
                        res = (res + dp[i - 1][0]) % mod;
                        res = (res + dp[i - 1][1]) % mod;
                        res = (res + dp[i - 1][3]) % mod;
                        res = (res + dp[i - 1][4]) % mod;
                    } else if (j == 3) {
                        res = (res + dp[i - 1][2]) % mod;
                        res = (res + dp[i - 1][4]) % mod;
                    } else {
                        res = (res + dp[i - 1][0]) % mod;
                    }
                    dp[i][j] = res;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 5; i++) sum = (sum + dp[n][i]) % mod;
        return sum;
    }

    // "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua"

    public int countVowelPermutation(int n, int len, int last) {
        int res = 0;
        if (len == 0) {
            res += countVowelPermutation(n, len + 1, 0);
            res += countVowelPermutation(n, len + 1, 1);
            res += countVowelPermutation(n, len + 1, 2);
            res += countVowelPermutation(n, len + 1, 3);
            res += countVowelPermutation(n, len + 1, 4);
        } else if (len == n) return 1;
        else {
            if (last == 0) {
                res += countVowelPermutation(n, len + 1, 1);
            } else if (last == 1) {
                res += countVowelPermutation(n, len + 1, 0);
                res += countVowelPermutation(n, len + 1, 2);
            } else if (last == 2) {
                res += countVowelPermutation(n, len + 1, 0);
                res += countVowelPermutation(n, len + 1, 1);
                res += countVowelPermutation(n, len + 1, 3);
                res += countVowelPermutation(n, len + 1, 4);
            } else if (last == 3) {
                res += countVowelPermutation(n, len + 1, 2);
                res += countVowelPermutation(n, len + 1, 4);
            } else if (last == 4) {
                res += countVowelPermutation(n, len + 1, 0);
            }
        }
        return res;
    }

    public int longestMountain(int[] arr) {
        if (arr.length < 3) return 0;
        int res = 0, before, len = 0;
        boolean upward = false;
        boolean downward = false;
        before = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > before) {
                if (!downward && !upward) upward = true;
                if (downward && upward) {
                    res = Math.max(res, len);
                    len = 0;
                    upward = false;
                    downward = false;
                    i--;
                    continue;
                }
                len++;
            }
            if (arr[i] < before) {
                if (upward && !downward) {
                    downward = true;
                    len++;
                }
                if (downward) len++;
            }
            if (arr[i] == before || i == arr.length - 1) {
                if (downward && upward) {
                    res = Math.max(res, len);
                    len = 0;
                    upward = false;
                    downward = false;
                    continue;
                } else {
                    len = 0;
                    upward = false;
                    downward = false;
                }
            }
            before = arr[i];
        }
        return res;
    }


    public double new21Game(int n, int k, int maxPts) {
        if (k == 0 || n >= k + maxPts) return 1;
        double dp[] = new double[n + 1], Wsum = 1, res = 0;
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = Wsum / maxPts;
            if (i < k) Wsum += dp[i];
            else res += dp[i];
            if (i - maxPts >= 0) Wsum -= dp[i - maxPts]; // 왜지?
        }
        return res;
        // n 보다 큰 값을 가질 확률을 구해서 빼자
    }

    double game_sum = 0;
    double game_total = 0;

    public void new21Game(int n, int k, int maxPts, int sum) {
        if (sum > n) return;
        for (int i = 1; i <= maxPts; i++) {
            int tmp = sum + i;
            if (i >= k) { // k보다 커서 종료되고, 총합이 n 보다 작거나 같은 경우
                game_total++; // 종료되는 모든 프로세스의 수
                if (tmp <= n) game_sum++; // 최종합이 tmp보다 작은 경우
            }
            if (i < k) // k보다 작아서 종료되지 않고 다음 프로세스로 넘어가는 경우
                new21Game(n, k, maxPts, tmp);
        }
    }

    int bst_sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        bstToGst(root.right);
        root.val += bst_sum;
        bst_sum = root.val;
        bstToGst(root.left);
        return root;
    }

    TreeNode result_node = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        findNode(true, root, p, q);
        if (root == null) return null;
        if (root.val == p.val || root.val == q.val) return root;
        TreeNode leftAns = lowestCommonAncestor(root.left, p, q);
        TreeNode rightAns = lowestCommonAncestor(root.right, p, q);
        if (leftAns != null && rightAns != null) return root;
        if (leftAns != null) return leftAns;
        return rightAns;
    }

    public boolean findNode(boolean result, TreeNode root, TreeNode target, TreeNode q) {
        boolean res = root.val == target.val;
        if (root.right != null) res |= findNode(result, root.right, target, q);
        if (root.left != null) res |= findNode(result, root.left, target, q);
        if (result && res) {
            boolean temp = findNode(false, root, q, q);
            if (temp) result_node = root;
        }
        return res;
    }

    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> rights = new Stack<TreeNode>();
        while (node != null) {
            list.add(node.val);
            if (node.right != null) {
                rights.push(node.right);
            }
            node = node.left;
            if (node == null && !rights.isEmpty()) {
                node = rights.pop();
            }
        }
        return list;
    }

    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; ++i) {
            res ^= (start + 2 * i);
        }
        return res;
    }

    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0;
        for (end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                k--;
            }
            if (k < 0) {
                if (nums[start] == 0) {
                    k++;
                }
                start++;
            }
        }
        return end - start;
    }

//    public int longestOnes(int[] arr, int k) {
//        if(k >= arr.length) return arr.length;
//
//        int res = 0, temp = 0, count = 0;
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < arr.length; ++i) {
//            if (arr[i] == 1) temp++;
//            if (arr[i] == 0) count++;
//            if (i != 0 && arr[i] == 0) {
//                list.add(temp);
//                temp = 0;
//            }
//        }
//        if(count <= k) return arr.length;
//        list.add(temp);
//
//        int len = list.size() - k;
//        for (int i = 0; i < len; ++i) {
//            int sum = 0;
//            for (int j = 0; j < list.size() && j < k + 1; j++) sum += list.get(i + j);
//            res = Math.max(res, sum + k);
//        }
//        return res;
//    }

//    public int longestOnes(int[] arr, int k, int start) {
//        int res = 0, temp = 0;
//        int count = k;
//        for (int i = start; i < arr.length; ++i) {
//            if (arr[i] == 1) temp++;
//            if (arr[i] == 0) {
//                if (count > 0) {
//                    count--;
//                    temp++;
//                } else {
//                    res = Math.max(res, temp);
//                    temp = 0;
//                    count = k;
//                }
//            }
//        }
//        res = Math.max(res, temp);
//        return res;
//    }
//
//    public int longestOnes(int[] arr, int k) {
//        int res = 0;
//        for (int i = 0; i < arr.length; i++) {
//            res = Math.max(res, longestOnes(arr, k, i));
//        }
//        return res;
//    }

    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] res = new double[query_row + 2];
        res[0] = poured;
        for (int row = 1; row <= query_row; row++)
            for (int i = row; i >= 0; i--)
                res[i + 1] += res[i] = Math.max(0.0, (res[i] - 1) / 2);
        return Math.min(res[query_glass], 1.0);
    }

    double combination(int p, int q) {
        return factorial(p) / (factorial(p - q) * factorial(q));
    }

    double factorial(int n) {
        double res = 1;
        for (int i = 2; i <= n; i++) {
            res *= n;
        }
        return res;
    }

    public String removeDuplicates(String s) {
        int len = s.length();
        StringBuilder builder = new StringBuilder();
        boolean b = true;
        for (int i = 0; i < len; ++i) {
            if (i < len - 1 && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                b = false;
            } else builder.append(s.charAt(i));
        }
        if (b)
            return builder.toString();
        else
            return removeDuplicates(builder.toString());
    }

    public int candy(int[] ratings) {
        int[] child = new int[ratings.length];
        Arrays.fill(child, 1);

        for (int i = 0; i < ratings.length; i++) {
            if (i - 1 >= 0)
                while (ratings[i] > ratings[i - 1] && child[i] <= child[i - 1]) child[i]++;
            if (i + 1 <= ratings.length - 1)
                while (ratings[i] > ratings[i + 1] && child[i] <= child[i + 1]) child[i]++;
        }
        int sum = 0;
        for (int i : child) {
            sum += i;
        }
        return sum;
    }

    public int countRestrictedPaths(int n, int[][] edges) {
        return 0;
    }

    public int countAllPaths(int n, int[][] edges) {
        countAllPaths(n, Collections.singletonList(1), 0, edges);
        return 0;
    }


    public void countAllPaths(int target, List<Integer> road, int weight, int[][] edges) {
        int current = road.get(road.size() - 1);
        if (current == target)
            System.out.println(road);
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] == current && !road.contains(edges[i][1])) {
                List<Integer> temp = new ArrayList<>(road.size() + 1);
                temp.addAll(road);
                temp.add(edges[i][1]);
                countAllPaths(target, temp, weight + edges[i][2], edges);
            }
            if (edges[i][1] == current && !road.contains(edges[i][0])) {
                List<Integer> temp = new ArrayList<>(road.size() + 1);
                temp.addAll(road);
                temp.add(edges[i][0]);
                countAllPaths(target, temp, weight + edges[i][2], edges);
            }
        }
    }

    public void moveZeroes(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                index++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public boolean isLexicographic(String[] arr, int index) {
        boolean check = true;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j].charAt(index) > arr[j + 1].charAt(index)) check = false;
        }
        return check;
    }

    public int minDeletionSize(String[] arr, int index) {
        if (index >= arr[0].length())
            return 0;

        boolean check = true;
        ArrayList<String[]> list = new ArrayList<>();
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j].charAt(index) > arr[j + 1].charAt(index)) check = false;
            if (arr[j].charAt(index) == arr[j + 1].charAt(index)) {
                list.add(new String[]{arr[j], arr[j + 1]});
            }
        }
        if (!check) return 1 + minDeletionSize(arr, index + 1);
        else {
            if (list.isEmpty()) return 0;
            else {
                int temp = 0;
                for (String[] strings : list) {
                    if (strings[0].charAt(index + 1) > strings[1].charAt(index + 1)) {
                        temp = 1;
                        break;
                    }
                }
                if (temp == 1) return minDeletionSize(arr, index + 2);
                else return 0;
            }
        }
    }

    public int minDeletionSize(String[] A) {
        int res = 0, n = A.length, m = A[0].length(), i, j;
        boolean[] sorted = new boolean[n - 1];
        for (j = 0; j < m; ++j) {
            for (i = 0; i < n - 1; ++i) {
                if (!sorted[i] && A[i].charAt(j) > A[i + 1].charAt(j)) {
                    res++;
                    break;
                }
            }
            if (i < n - 1) continue;
            for (i = 0; i < n - 1; ++i) {
                sorted[i] |= A[i].charAt(j) < A[i + 1].charAt(j);
            }
        }
        return res;
    }

    public boolean canJump(int[] arr) {
//        return canJump(0, arr);
        return canJump(arr, arr.length - 1);
    }

    public boolean canJump(int[] arr, int lastIndex) {
        int last = lastIndex, i;
        for (i = last - 1; i >= 0; i--) {
            if (i + arr[i] >= last) last = i;
        }
        return last <= 0;
    }

    public boolean canJump(int index, int[] arr) {
        if (index == arr.length - 1)
            return true;
        for (int i = arr[index]; i >= 1; i--) {
            if (canJump(index + i, arr))
                return true;
        }
        return false;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        int w = matrix.length;
        int h = matrix[0].length;

        int[] x = {1, 0, -1, 0};
        int[] y = {0, 1, 0, -1};
        int type = 0;
        while (true) {
            if (list.size() == w * h)
                break;
            list.add(matrix[i][j]);
            matrix[i][j] = Integer.MAX_VALUE;

            int I = i + y[type];
            int J = j + x[type];
            if (I < 0 || I > w - 1 || J < 0 || J > h - 1 || matrix[I][J] == Integer.MAX_VALUE) {
                type++;
                type %= 4;
            }
            i += y[type];
            j += x[type];
        }
        return list;
    }

    public static int maxSubArray(int[] A) {
        int maxSoFar = A[0], maxEndingHere = A[0];
        for (int i = 1; i < A.length; ++i) {
            maxEndingHere = Math.max(maxEndingHere + A[i], A[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public boolean checkQueen(int x, int y, int x2, int y2) {
        if (x == x2 || y == y2)
            return true;
        else return Math.abs(x - x2) == Math.abs(y - y2);
    }

    public boolean checkQueen(List<List<Integer>> list, int i, int j) {
        for (List<Integer> l : list) {
            if (checkQueen(l.get(0), l.get(1), i, j))
                return true;
        }
        return false;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 1) {
            res.add(Collections.singletonList("Q"));
            return res;
        }
        if (n > 1 && n < 4)
            return res;

        for (int x = 1; x < n - 1; x++) {
            solveNQueens(res, new ArrayList<>(), n, x, 0);
        }
        return res;
    }

    public List<String> convert(int n, List<List<Integer>> temp) {
        List<String> s = new ArrayList<>();
        for (List<Integer> l : temp) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == l.get(1))
                    builder.append('Q');
                else
                    builder.append('.');
            }
            s.add(builder.toString());
        }
        return s;
    }

    public int solveNQueens(List<List<String>> res, List<List<Integer>> current, int n, int x, int y) {
        if (current.size() == n) {
            res.add(convert(n, current));
            return 0;
        }
        int s = current.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // previous check
                if (!checkQueen(current, i, j) && !checkQueen(x, y, i, j)) {
                    current.add(Arrays.asList(i, j));
                    int temp = solveNQueens(res, current, n, i, j);
                    if (temp == -1)
                        current.remove(current.size() - 1); // remove last index
                }
            }
        }
        if (s == current.size()) return -1;
        else return s + 1;
    }

    public int negative(int n) {
        if (n != Integer.MIN_VALUE) return -n;
        return 0;
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        int res = 0;
        long x = Math.abs((long) dividend);
        long y = Math.abs((long) divisor);

        while (x >= y) {
            x -= y;
            res++;
        }
        return res * sign;
    }

    public int[] searchRange(int[] arr, int target) {
        int[] res = new int[]{-1, -1};
        searchRange(res, arr, target, 0, arr.length - 1);
        return res;
    }

    public void searchRange(int[] res, int[] arr, int target, int start, int end) {
        if (arr.length == 0)
            return;
        if (arr.length == 1) {
            if (arr[0] == target) {
                res[0] = 0;
                res[1] = 0;
            }
            return;
        }

        int mid = (start + end) / 2;
        if (start > end) return;
        if (arr[mid] == target) {
            boolean[] b = {true, true};
            if (mid == 0 || arr[mid - 1] != target) {
                res[0] = mid;
                b[0] = false;
            }
            if (mid == arr.length - 1 || arr[mid + 1] != target) {
                res[1] = mid;
                b[1] = false;
            }
            if (b[0]) searchRange(res, arr, target, start, mid - 1);
            if (b[1]) searchRange(res, arr, target, mid + 1, end);
        } else if (arr[mid] < target) {
            searchRange(res, arr, target, mid + 1, end);
        } else {
            searchRange(res, arr, target, start, mid - 1);
        }
    }

    public boolean isMatch(String s, String p) {
        if (p.equals("*") && s.length() == 1) return true;
        if (p.equals("?")) return true;

        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Character> wilds = new ArrayList<>();
        temp.add(-1);
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '?') {
                temp.add(i);
                wilds.add('?');
            }
            if (p.charAt(i) == '*') {
                temp.add(i);
                wilds.add('*');
            }
        }
        temp.add(p.length());

        if (temp.size() == 2)
            return s.equals(p);

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < temp.size() - 1; i++) {
            String ss = p.substring(temp.get(i) + 1, temp.get(i + 1));
            if (!ss.equals(""))
                strings.add(ss);
        }

        ArrayList<ArrayList<Integer>> k = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            ArrayList<Integer> r = findIndexes(s, strings.get(i));
            k.add(r);
        }
        return true;
    }

    public ArrayList<Integer> findIndexes(String str, String find) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; str.indexOf(find, i) != -1; i++) {
            i = str.indexOf(find, i);
            res.add(i);
        }
        return res;
    }

    public boolean isMatch(ArrayList<Integer> arr, ArrayList<Integer> wilds) {
        // check -1;
        boolean b = arr.stream().anyMatch(element -> element == -1);
        if (b) return false;

        // check up-stair
        ArrayList<Integer> cmp = new ArrayList<>(arr);
        cmp.sort(Integer::compareTo);
        if (!cmp.equals(arr)) return false;

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i + 1) - arr.get(i) == 2 && wilds.get(i) == '*') return false;
            if (arr.get(i + 1) - arr.get(i) > 2 && wilds.get(i) == '?') return false;
        }

        return true;
    }

    public int searchInsert(int[] arr, int target) {
        return searchInsert(arr, target, 0, arr.length - 1);
    }

    public int searchInsert(int[] arr, int target, int start, int end) {
        int temp = (start + end) / 2;
        if (arr[temp] == target) return temp;
        else if (start == end) return start + (arr[start] > target ? 0 : 1);
        else if (arr[temp] > target) return searchInsert(arr, target, start, temp);
        else return searchInsert(arr, target, temp + 1, end);
    }

    int func(int a, int b) {
        if (a <= 0) return 0;
        if (a == 1) return 1;
        return func(a - 2, a) + func(a - 1, b) + a;
    }

    public boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        char[] arr_a = a.toCharArray();
        char[] arr_b = b.toCharArray();
        Arrays.sort(arr_a);
        Arrays.sort(arr_b);
        for (int i = 0; i < a.length(); i++)
            if (arr_a[i] != arr_b[i])
                return false;
        return true;
    }

    public List<List<String>> groupAnagrams(String[] arr) {
        List<List<String>> res = new ArrayList<>();
        if (arr.length == 0)
            return res;
        if (arr.length == 1) {
            res.add(Collections.singletonList(arr[0]));
            return res;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null)
                continue;

            List<String> list = new ArrayList<>();
            list.add(arr[i]);
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == null)
                    continue;
                if (isAnagram(arr[i], arr[j])) {
                    list.add(arr[j]);
                    arr[j] = null;
                }
            }
            arr[i] = null;
            res.add(list);
        }
        return res;
    }

    public int firstMissingPositive(int[] arr) {
        Arrays.sort(arr);
        int index = 0;
        while (index < arr.length && arr[index] <= 0) index++;
        if (index == arr.length || arr[index] > 1)
            return 1;
        else {
            int i, count = arr[index];
            for (i = index; i < arr.length; i++) {
                if (arr[i] != count)
                    return count;
                else {
                    count++;
                    while (i + 1 < arr.length && arr[i] == arr[i + 1]) i++;
                }
            }
            return count;
        }
    }

    public int[] removeElement(int[] arr, int val) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != val) {
                arr[count++] = arr[i];
            }
        }
        return arr;
    }

    public int jump(int[] arr) {
        return jump(arr, 0, 30);
    }

    public int jump(int[] arr, int current, int level) {
        if (level <= 0)
            return -1;
        if (current == arr.length - 1)
            return 0;
        else if (current > arr.length - 1)
            return -1;
        else {
            int value = level;
            for (int i = 1; i <= arr[current]; i++) {
                int temp = jump(arr, current + i, value - 1);
                if (temp != -1 && temp < value) {
                    value = temp;
                }
            }
            if (value == Integer.MAX_VALUE)
                return -1;
            else
                return value + 1;
        }
    }

    public int removeDuplicates(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[count++] = arr[i];
            while (i + 1 < arr.length && arr[i] == arr[i + 1]) i++;
        }
        return count;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        ArrayList<ListNode> temp_list = new ArrayList<>(Arrays.asList(lists));
        while (!temp_list.isEmpty()) {
            ListNode min = null;
            int index = -1;
            for (int i = 0; i < temp_list.size(); i++) {
                ListNode node = temp_list.get(i);
                if (node == null)
                    continue;
                if (min == null || node.val < min.val) {
                    min = node;
                    index = i;
                }
            }
            if (min != null) {
                if (min.next != null)
                    temp_list.set(index, temp_list.get(index).next);
                else
                    temp_list.remove(index);
            } else
                break;
            temp.next = min;
            temp = temp.next;
        }
        return res.next;
    }

    public List<String> generateParenthesis2(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis2("", 0, 0, n, result);
        return result;
    }

    private void generateParenthesis2(String s, int open, int close, int n, List<String> result) {
        if (close == n) {
            result.add(s);
            return;
        }
        if (open > close) generateParenthesis2(s + ")", open, close + 1, n, result);
        if (open < n) generateParenthesis2(s + "(", open + 1, close, n, result);
    }

    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return Collections.emptyList();
        if (n == 1)
            return Collections.singletonList("()");
        if (n == 2)
            return Arrays.asList("()()", "(())");
        List<String> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            List<String> temp = generateParenthesis(n - i);
            List<String> temp2 = generateParenthesis(i);
            for (String s : temp) {
                for (String s2 : temp2) {
                    StringBuilder builder;
                    String t;
                    builder = new StringBuilder();
                    builder.append(s2);
                    builder.append(s);
                    t = builder.toString();
                    if (!res.contains(t))
                        res.add(t);

                    builder = new StringBuilder();
                    builder.append("(".repeat(i));
                    builder.append(s);
                    builder.append(")".repeat(i));
                    t = builder.toString();
                    if (!res.contains(t))
                        res.add(t);
                }
            }
        }
        return res;
    }

    // (())(())
    // ["(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"]

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        final char[] input = s.toCharArray();
        int index = -1;
        for (int i = 0; i < input.length; i++) {
            switch (input[i]) {
                case '(':
                    input[++index] = ')';
                    break;
                case '[':
                    input[++index] = ']';
                    break;
                case '{':
                    input[++index] = '}';
                    break;
                case ')':
                case ']':
                case '}':
                    if (index < 0 || input[index--] != input[i]) {
                        return false;
                    }
                    break;
            }
        }
        return index < 0;
    }

//    public boolean isValid(String s) {
//        return isValid(s, 0, s.length() - 1);
//    }
//
//    public boolean isValid(String s, int start, int end) {
//        if(start > end)
//            return true;
//        else {
//            int i = start;
//            char c = s.charAt(start);
//            if(c == '(') c = ')';
//            else if(c == '[') c = ']';
//            else if(c == '{') c = '}';
//            else
//                return false;
//
//            while(i <= end && s.charAt(i) != c) i++;
//            if(i == end + 1) {
//                return false;
//            } else {
//                boolean b1 = isValid(s, start + 1, i - 1);
//                boolean b2 = isValid(s, i + 1, end);
//                return b1 && b2;
//            }
//        }
//    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        _combinationSum2(res, new ArrayList<>(), candidates, 0, target);
        return res;
    }

    public void _combinationSum2(List<List<Integer>> result, ArrayList<Integer> current, int[] candidates, int index, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
        } else if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                current.add(candidates[i]);
                _combinationSum2(result, current, candidates, i + 1, target - candidates[i]);
                current.remove(current.size() - 1);
            }
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            int n = temp.val;
            temp.val = temp.next.val;
            temp.next.val = n;
            temp = temp.next.next;
        }
        return head;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        if (l1 == null) pointer.next = l2;
        if (l2 == null) pointer.next = l1;
        return head.next;
    }

    List<List<Integer>> result_combinationSum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result_combinationSum = new ArrayList<>();
        combinationSum(candidates, target, new ArrayList<>(), 0);
        return result_combinationSum;
    }

    public void combinationSum(int[] candidates, int target, List<Integer> current, int start) {
        if (target == 0) {
            result_combinationSum.add(current);
        } else if (target > 0) {
            for (int i = start; i < candidates.length; i++) {
                int v = candidates[i];
                if (target - v < 0) continue;
                List<Integer> temp = new ArrayList<>(current);
                temp.add(v);
                combinationSum(candidates, target - v, temp, i);
            }
        }
    }

    public ArrayList<Integer> transform(int[] arr) {
        ArrayList<Integer> temp = new ArrayList<>();
        Arrays.sort(arr);
        for (int v : arr)
            temp.add(v);
        return temp;
    }

    List<List<Integer>> _resPermuteUnique;

    public List<List<Integer>> permuteUnique(int[] arr) {
        _resPermuteUnique = new ArrayList<>();
        recursion_permuteUnique(transform(arr), new ArrayList<>());
        return _resPermuteUnique;
    }

    public void recursion_permuteUnique(ArrayList<Integer> list, ArrayList<Integer> res) {
        if (list.size() == 0)
            _resPermuteUnique.add(res);
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Integer> res_ = new ArrayList<>(res);
            ArrayList<Integer> list_ = new ArrayList<>(list);
            res_.add(list_.get(i));
            list_.remove(i);
            recursion_permuteUnique(list_, res_);
            while (i + 1 < list.size() && list.get(i).equals(list.get(i + 1))) i++;
        }
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int k = i;
            while (haystack.charAt(k) == needle.charAt(k - i)) {
                k++;
                if (k - i == needle.length())
                    return i;
            }
        }
        return -1;
    }
}


/*
    public int search(int[] arr, int target) {
        return searchInRotated(arr, target, 0, arr.length - 1);
    }

    public int searchInRotated(int[] arr, int target, int start, int end) {
        if (arr[start] == target)
            return start;
        if (arr[end] == target)
            return end;
        if (start == end)
            return -1;

        int mid = (start + end) / 2;
        int result = searchInRotated(arr, target, start, mid);
        int result2 = searchInRotated(arr, target, mid + 1, end);
        if (result != -1)
            return result;
        else
            return result2;
    }
*/

//    public int trap(int[] height) {
//        int res = 0;
//        for (int i = 0; i < height.length - 1; i++) {
//            int current = height[i];
//            while (current != 0) {
//                int j = i + 1;
//                int temp = 0;
//                while (j < height.length) {
//                    if (height[j] < current) {
//                        temp += current - height[j];
//                        j++;
//                    } else {
//                        i = j - 1;
//                        res += temp;
//                        break;
//                    }
//                }
//                if (j == height.length) {
//                    current--;
//                } else {
//                    break;
//                }
//            }
//        }
//        return res;
//    }
//
//    public String multiply(String str1, String str2) {
//        if (str1.equals("0") || str2.equals("0"))
//            return "0";
//        if (str1.equals("1"))
//            return str2;
//        if (str2.equals("1"))
//            return str1;
//
//        StringBuilder builder = new StringBuilder();
//        int[] res = new int[str1.length() + str2.length()];
//        char[] arr = str1.toCharArray();
//        char[] arr2 = str2.toCharArray();
//        if (str1.length() < str2.length()) {
//            arr = str2.toCharArray();
//            arr2 = str1.toCharArray();
//        }
//
//        for (int i = 0; i < arr2.length; i++) {
//            char under = arr2[i];
//            int count = i;
//            for (char upper: arr) {
//                int temp = (upper - '0') * (under - '0');
//                res[count + 1] += temp;
//                res[count] += res[count + 1] / 10;
//                res[count + 1] %= 10;
//                count++;
//            }
//        }
//        for (int j = res.length - 1; j > 0; j--) {
//            int temp = res[j];
//            res[j - 1] += temp / 10;
//            res[j] %= 10;
//        }
//        System.out.println(Arrays.toString(res));
//        boolean first = true;
//        for (int i: res) {
//            if (i != 0)
//                first = false;
//            if (i == 0 && first)
//                continue;
//            builder.append(i);
//        }
//        return builder.toString();
//    }
//
//    public void rotate(int[][] matrix) {
//        int size = matrix.length;
//        for (int i = 0; i < (size + 1) / 2; i++) {
//            for (int j = i; j < size - i - 1; j++) {
//                int x = i;
//                int y = j;
//                int temp = matrix[x][y];
//                for (int k = 0; k < 4; k++) {
//                    int sx = y;
//                    int sy = size - 1 - x;
//                    int a = matrix[sx][sy];
//                    matrix[sx][sy] = temp;
//                    temp = a;
//                    x = sx;
//                    y = sy;
//                }
//            }
//        }
//    }
//
//    public int threeSumClosest(int[] arr, int target) {
//        Arrays.sort(arr);
//        int res = arr[0] + arr[1] + arr[2];
//        for (int i = 0; i < arr.length - 2; i++) {
//            int j = i + 1;
//            int k = arr.length - 1;
//            while (j < k) {
//                int sum = arr[i] + arr[j] + arr[k];
//                if (sum > target) {
//                    k--;
//                    if (Math.abs(target - sum) < Math.abs(target - res)) {
//                        res = sum;
//                    }
//                } else if (sum < target) {
//                    j++;
//                    if (Math.abs(target - sum) < Math.abs(target - res)) {
//                        res = sum;
//                    }
//                } else {
//                    return sum;
//                }
//            }
//        }
//        return res;
//    }
//
//    //    public int threeSumClosest(int[] arr, int target) {
//    //        if(arr.length < 3)
//    //            return 0;
//    //        int res = arr[0] + arr[1] + arr[2];
//    //        for (int i = 0; i < arr.length - 2; i++) {
//    //            for (int j = i + 1; j < arr.length - 1; j++) {
//    //                for (int k = j + 1; k < arr.length; k++) {
//    //                    int sum = arr[i] + arr[j] + arr[k];
//    //                    if (Math.abs(res - target) > Math.abs(sum - target)) {
//    //                        res = target;
//    //                    }
//    //                }
//    //            }
//    //        }
//    //        return target;
//    //    }
//
//    //    public int[] searchRange(int[] arr, int target) {
//    //        Collections.binarySearch(Collections.singletonList(arr), target);
//    //    }
//    //
//    //    public int binarySearch(int [])
//
//    public List < Integer > transform(int[] arr) {
//        ArrayList < Integer > temp = new ArrayList < > ();
//        for (int v: arr)
//            temp.add(v);
//        return temp;
//    }
//
//    List < List < Integer >> permuteResult;
//    public List < List < Integer >> permute(int[] arr) {
//        permuteResult = new ArrayList < > ();
//        List < Integer > temp = transform(arr);
//        re_permute(temp, Collections.emptyList());
//        return permuteResult;
//    }
//
//    public void re_permute(List < Integer > list, List < Integer > res) {
//        if (list.size() == 0)
//            permuteResult.add(res);
//        for (int i = 0; i < list.size(); i++) {
//            List < Integer > res_ = new ArrayList < > (res);
//            List < Integer > list_ = new ArrayList < > (list);
//            res_.add(list_.get(i));
//            list_.remove(i);
//            re_permute(list_, res_);
//        }
//    }
//
//    //    public List<Integer> transform(int[] arr) {
//    //        ArrayList<Integer> temp = new ArrayList<>();
//    //        for (int v : arr)
//    //            temp.add(v);
//    //        return temp;
//    //    }
//    //
//    //    public ArrayList<List<Integer>> swap(ArrayList<List<Integer>> list) {
//    //        ArrayList<List<Integer>> res = new ArrayList<>();
//    //        for (List<Integer> temp : list) {
//    //            res.add(temp);
//    //            for (int i = 0; i < temp.size() - 1; i++) {
//    //                for (int j = i + 1; j < temp.size(); j++) {
//    //                    List<Integer> c = new ArrayList<>(List.copyOf(temp));
//    //                    Collections.swap(c, i, j);
//    //                    res.add(c);
//    //                }
//    //            }
//    //        }
//    //        return res;
//    //    }
//    //
//    //    public List<List<Integer>> permute(int[] arr) {
//    //        ArrayList<List<Integer>> res = new ArrayList<>();
//    //        res.add(transform(arr));
//    //
//    //        for (int i = 0; i < arr.length; i++) {
//    //            res = swap(res);
//    //        }
//    //        return res;
//    //    }
//
//    public String countAndSay(int n) {
//        String temp = "1";
//        for (int i = 0; i < n - 1; i++) {
//            temp = lookAndSay(temp);
//        }
//        return temp;
//    }
//
//    public String lookAndSay(String str) {
//        if (str.length() == 0)
//            return str;
//
//        char[] arr = str.toCharArray();
//        int count = 0;
//        char target = arr[0];
//        StringBuilder builder = new StringBuilder();
//        for (char c: arr) {
//            if (target != c) {
//                builder.append(count);
//                builder.append(target);
//                target = c;
//                count = 1;
//            } else {
//                count++;
//            }
//        }
//        builder.append(count);
//        builder.append(target);
//
//        return builder.toString();
//    }
//
//    public String lookAndSay(int n) {
//        int count = 1;
//        int target = n % 10;
//        n /= 10;
//        StringBuilder builder = new StringBuilder();
//        while (true) {
//            int temp = n % 10;
//
//            if (n == 0) {
//                builder.append(target);
//                builder.append(count);
//                break;
//            }
//            n /= 10;
//
//            if (temp != target) {
//                builder.append(target);
//                builder.append(count);
//                target = temp;
//                count = 1;
//            } else {
//                count++;
//            }
//
//        }
//        return builder.reverse().toString();
//    }
//
//    double myPow(double x, int n) {
//        double res = 1;
//        for (int i = 0; i < Math.abs(n); i++)
//            res *= x;
//
//        if (n >= 0)
//            return res;
//        else
//            return 1 / res;
//    }
//
//    public boolean checkLine(char[] line) {
//        Set < Character > set = new HashSet < > ();
//        for (char c: line)
//            if (!set.contains(c)) {
//                if (c != '.') {
//                    set.add(c);
//                }
//            } else {
//                return false;
//            }
//        return true;
//    }
//
//    public boolean checkSection(char[][] board, int i, int j) {
//        Set < Character > set = new HashSet < > ();
//        for (int a = 3 * i; a < 3 * (i + 1); a++) {
//            for (int b = 3 * j; b < 3 * (j + 1); b++) {
//                char c = board[a][b];
//                if (!set.contains(c)) {
//                    if (c != '.') {
//                        set.add(c);
//                    }
//                } else {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//
//    public boolean isValidSudoku(char[][] board) {
//
//        // check horizontal line
//        for (char[] chars: board) {
//            if (!checkLine(chars))
//                return false;
//        }
//
//        // check vertical line
//        for (int j = 0; j < board[0].length; j++) {
//            char[] chars = new char[9];
//            for (int i = 0; i < board.length; i++) {
//                chars[i] = board[i][j];
//            }
//            if (!checkLine(chars))
//                return false;
//        }
//
//        // check sections
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                if (!checkSection(board, i, j))
//                    return false;
//            }
//        }
//
//        return true;
//    }
//
//    public double Postfix(String str) {
//        char[] arr = str.toCharArray();
//        ArrayList < Double > values = new ArrayList < > ();
//        for (char c: arr) {
//            if (c >= '0' && c <= '9')
//                values.add((double)(c - '0'));
//            else {
//                double input = 0;
//                int size = values.size();
//                if (c == '+')
//                    input = values.get(size - 2) + values.get(size - 1);
//                if (c == '*')
//                    input = values.get(size - 2) * values.get(size - 1);
//                if (c == '/')
//                    input = values.get(size - 2) / values.get(size - 1);
//                if (c == '-')
//                    input = values.get(size - 2) - values.get(size - 1);
//
//                values.set(size - 2, input);
//                values.remove(size - 1);
//            }
//        }
//        return values.get(0);
//    }
//
//    public static class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) {
//            this.val = val;
//        }
//        ListNode(int val, ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }
//
//    public int longestValidParentheses(String s) {
//        int res = 0;
//        char[] arr = s.toCharArray();
//        for (int i = 0; i < arr.length; i++) {
//            int left = 0, right = 0;
//            int j = i;
//            while (j < arr.length) {
//                char c = arr[j];
//                if (c == '(')
//                    left++;
//                if (c == ')')
//                    right++;
//                if (right == left)
//                    res = Math.max(res, right * 2);
//                if (right > left)
//                    break;
//                j++;
//            }
//            if (!(j == arr.length && right != left)) {
//                i = j;
//                res = Math.max(res, Math.min(right, left) * 2);
//            }
//        }
//        return res;
//    }
//
//    public String longestCommonPrefix(String[] arr) {
//        String res = "";
//        if (arr.length == 0)
//            return res;
//
//        int i = 0;
//        char[] temp = arr[0].toCharArray();
//        if (_longestCommonPrefix(arr, i)) {
//            StringBuilder builder = new StringBuilder();
//            while (_longestCommonPrefix(arr, i)) {
//                builder.append(temp[i]);
//                i++;
//            }
//            res = builder.toString();
//        }
//        return res;
//    }
//
//    public boolean _longestCommonPrefix(String[] arr, int i) {
//        boolean b = true;
//        if (i >= arr[0].length())
//            return false;
//        char target = arr[0].charAt(i);
//        for (String s: arr) {
//            if (i >= s.length() || s.charAt(i) != target) {
//                b = false;
//                break;
//            }
//        }
//        return b;
//    }
//
//    //    public String longestCommonPrefix(String[] arr) {
//    //        String res = "";
//    //        if(arr.length == 0)
//    //            return res;
//    //
//    //        int i = 0;
//    //        String target = arr[0];
//    //        while (i < target.length()) {
//    //            int k = 1;
//    //            String sub = target.substring(i, i + k);
//    //            while (_longestCommonPrefix(arr, sub)) {
//    //                if(sub.length() > res.length())
//    //                    res = sub;
//    //                if(i + k == target.length())
//    //                    break;
//    //                sub = target.substring(i, i + (++k));
//    //            }
//    //            i += k;
//    //        }
//    //        return res;
//    //    }
//    //
//    //    public boolean _longestCommonPrefix(String[] arr, String target) {
//    //        boolean b = true;
//    //        for (String s : arr) {
//    //            if (!s.contains(target)) {
//    //                b = false;
//    //                break;
//    //            }
//    //        }
//    //        return b;
//    //    }
//
//    public int[] nextPermutation(int[] arr) {
//        int temp = arr.length - 1;
//        int j = arr.length - 1;
//        while (j >= 0 && arr[j] >= arr[temp]) {
//            temp = j;
//            j--;
//        }
//
//        if (j == -1) {
//            Arrays.sort(arr);
//        } else {
//            int min = temp;
//            for (int i = arr.length - 1; i > j; i--) {
//                if (arr[j] < arr[i] && arr[i] < arr[min]) {
//                    min = i;
//                }
//            }
//            int n = arr[min];
//            arr[min] = arr[j];
//            arr[j] = n;
//            Arrays.sort(arr, j + 1, arr.length);
//        }
//        return arr;
//    }
//
//    public List < String > letterCombinations(String digits) {
//        Map < Character, List < String >> map = new HashMap < > ();
//        map.put('2', Arrays.asList("a", "b", "c"));
//        map.put('3', Arrays.asList("d", "e", "f"));
//        map.put('4', Arrays.asList("g", "h", "i"));
//        map.put('5', Arrays.asList("j", "k", "l"));
//        map.put('6', Arrays.asList("m", "n", "o"));
//        map.put('7', Arrays.asList("p", "q", "r", "s"));
//        map.put('8', Arrays.asList("t", "u", "v"));
//        map.put('9', Arrays.asList("w", "x", "y", "z"));
//        ArrayList < String > res = new ArrayList < > ();
//        if (digits.length() == 0)
//            return res;
//
//        char[] sp = digits.toCharArray();
//        for (char c: sp) {
//            List < String > temp = map.get(c);
//            for (String s: temp) {
//                ArrayList < String > arr = new ArrayList < > ();
//                for (String t: res) {
//                    arr.add(t + s);
//                }
//                res = (ArrayList < String > ) arr.clone();
//            }
//        }
//        return res;
//    }
//
//    public ListNode reverseKGroup(ListNode head, int k) {
//        ListNode d = head, res = new ListNode(), dummy = res;
//        ArrayList < Integer > arr = new ArrayList < > ();
//        int count = 0;
//        while (true) {
//            if (count < k) {
//                if (d == null)
//                    break;
//                arr.add(d.val);
//                d = d.next;
//                count++;
//            } else {
//                for (int j = arr.size() - 1; j >= 0; j--) {
//                    dummy.next = new ListNode(arr.get(j));
//                    dummy = dummy.next;
//                }
//                arr.clear();
//                count = 0;
//            }
//        }
//        for (int i = 0; i < arr.size(); i++) {
//            dummy.next = new ListNode(arr.get(i));
//            dummy = dummy.next;
//        }
//        return res.next;
//    }
//
//
//    public int romanToInt(String s) {
//        int[] values = {
//                1000,
//                900,
//                500,
//                400,
//                100,
//                90,
//                50,
//                40,
//                10,
//                9,
//                5,
//                4,
//                1
//        };
//        String[] romanSymbols = {
//                "M",
//                "CM",
//                "D",
//                "CD",
//                "C",
//                "XC",
//                "L",
//                "XL",
//                "X",
//                "IX",
//                "V",
//                "IV",
//                "I"
//        };
//        int l = s.length();
//        if (l == 0)
//            return 0;
//        for (int i = 0; i < values.length; i++) {
//            if (s.substring(0, 1).equals(romanSymbols[i])) {
//                return values[i] + romanToInt(s.substring(1));
//            } else if (l >= 2 && s.substring(0, 2).equals(romanSymbols[i])) {
//                return values[i] + romanToInt(s.substring(2));
//            }
//        }
//        return 0;
//    }
//
//    public String intToRoman(int num) {
//        int[] values = {
//                1000,
//                900,
//                500,
//                400,
//                100,
//                90,
//                50,
//                40,
//                10,
//                9,
//                5,
//                4,
//                1
//        };
//        String[] romanSymbols = {
//                "M",
//                "CM",
//                "D",
//                "CD",
//                "C",
//                "XC",
//                "L",
//                "XL",
//                "X",
//                "IX",
//                "V",
//                "IV",
//                "I"
//        };
//        StringBuilder result = new StringBuilder();
//
//        for (int i = 0; i < values.length; i++) {
//            while (num >= values[i]) {
//                num = num - values[i];
//                result.append(romanSymbols[i]);
//            }
//        }
//        return result.toString();
//    }
//
//    /*
//        4ms
//        public String intToRoman(int num) {
//            StringBuilder builder = new StringBuilder();
//            int count = 0;
//            while (num != 0) {
//                int target = num % 10;
//                if (count == 3) {
//                    builder.append("M".repeat(target));
//                } else {
//                    char[] char_i = {'I', 'X', 'C', 'M'};
//                    char[] char_v = {'V', 'L', 'D'};
//                    if (target == 9) {
//                        builder.append(char_i[count + 1]);
//                        builder.append(char_i[count]);
//                    } else if (target == 4) {
//                        builder.append(char_v[count]);
//                        builder.append(char_i[count]);
//                    } else if (target >= 5) {
//                        builder.append(String.valueOf(char_i[count]).repeat(target - 5));
//                        builder.append(char_v[count]);
//                    } else {
//                        builder.append(String.valueOf(char_i[count]).repeat(target));
//                    }
//                }
//                count++;
//                num /= 10;
//            }
//            return builder.reverse().toString();
//        }
//    */
//
//    public int maxArea(int[] arr) {
//        int a, b, res = 0;
//        int i = 0, j = arr.length - 1;
//        do {
//            a = arr[i];
//            b = arr[j];
//            res = Math.max(res, Math.min(a, b) * (j - i));
//
//            if (a < b) {
//                while (i < arr.length && arr[i] <= a) i++;
//            } else {
//                while (j > 0 && arr[j] <= b) j--;
//            }
//        } while (i != arr.length && j != 0 && i < j);
//        return res;
//    }
//
//    /*    public int maxArea(int[] arr) {
//            int res = 0;
//            for (int target : arr) {
//                int a = 0;
//                int b = arr.length - 1;
//                while (arr[a] < target) a++;
//                while (arr[b] < target) b--;
//                if (a < b)
//                    res = Math.max(res, target * (b - a));
//            }
//            return res;
//        }*/
//
//    // start with maxArea(arr, 0)
//    public int maxArea(int[] arr, int start) {
//        int target;
//        if (arr.length - 1 >= start)
//            target = arr[start];
//        else
//            return 0;
//        int res = 0;
//        for (int i = arr.length - 1; i > 0; i--)
//            res = Math.max(res, Math.min(arr[i], target) * (i - start));
//        return Math.max(res, maxArea(arr, start + 1));
//    }
//
//    public boolean isMatch(String s, String p) {
//        return s.equals(p);
//    }
//
//    public boolean isPalindrome(int x) {
//        if (x >= 0) {
//            int cur = 0;
//            int num = x;
//            while (num != 0) {
//                cur = cur * 10 + num % 10;
//                num /= 10;
//            }
//            return cur == x;
//        } else
//            return false;
//    }
//
//    public int check2(String str) {
//        int res = 0;
//        long temp = Long.parseLong(str);
//        if (temp > Integer.MAX_VALUE)
//            res = Integer.MAX_VALUE;
//        else if (temp < Integer.MIN_VALUE)
//            res = Integer.MIN_VALUE;
//        else
//            res = Long.valueOf(temp).intValue();
//        return res;
//    }
//
//    public int myAtoi(String s) {
//        int res = 0, i;
//        char[] arr = s.toCharArray();
//        boolean symbol = false;
//
//        if (s.length() == 0)
//            return 0;
//
//        StringBuilder builder = new StringBuilder();
//        for (i = 0; i < arr.length; i++) {
//            char c = arr[i];
//            if (builder.length() == 0) {
//                if ((c >= '0' && c <= '9') || c == '+' || c == '-') {
//                    if (c == '+' || c == '-')
//                        symbol = true;
//                    builder.append(c);
//                } else if (c != ' ')
//                    break;
//            } else {
//                if (c >= '0' && c <= '9')
//                    builder.append(c);
//                else if (c == ' ' || c == '.') {
//                    res = check2(builder.toString());
//                    break;
//                } else if (c == '+' || c == '-') {
//                    if (symbol)
//                        break;
//                    else
//                        symbol = true;
//                } else {
//                    break;
//                }
//            }
//        }
//        if (i == arr.length)
//            res = check2(builder.toString());
//        return res;
//    }
//
//    public String convert(String s, int numRows) {
//        StringBuilder builder = new StringBuilder();
//        char[] arr = s.toCharArray();
//        if (numRows == 1)
//            return s;
//        for (int i = 0; i < numRows; i++) {
//            int n = (numRows - i - 1) * 2;
//            int n2 = i * 2;
//            int j = i;
//
//            if (j >= arr.length)
//                break;
//            builder.append(arr[j]);
//
//            if (n == 0 && n2 == 0)
//                continue;
//            while (true) {
//                if (n != 0) {
//                    j += n;
//                    if (j < arr.length)
//                        builder.append(arr[j]);
//                    else break;
//                }
//
//                if (n2 != 0) {
//                    j += n2;
//                    if (j < arr.length)
//                        builder.append(arr[j]);
//                    else break;
//                }
//            }
//        }
//        return builder.toString();
//    }
//
//    public int reverse(int x) {
//        double res = 0;
//        int neg = x > 0 ? 1 : -1;
//        int d = Math.abs(x), count = 1;
//        int size = String.valueOf(d).length();
//        while (d != 0) {
//            res += (d % 10) * Math.pow(10, size - count++);
//            d /= 10;
//        }
//        res *= neg;
//        if (res <= Integer.MAX_VALUE && res >= Integer.MIN_VALUE)
//            return Double.valueOf(res).intValue();
//        else
//            return 0;
//    }
//
//    private int[] res = new int[] {
//            0,
//            1
//    };
//    private int size = 1;
//    public String longestPalindrome(String s) {
//        char[] arr = s.toCharArray();
//        for (int i = 0; i < arr.length - 1; i++) {
//            check(arr, i, i);
//            if (arr[i] == arr[i + 1]) {
//                check(arr, i, i + 1);
//            }
//        }
//        return s.substring(res[0], res[1]);
//    }
//
//    public void check(char[] arr, int start, int end) {
//        while (start >= 0 && end <= arr.length - 1 && arr[start] == arr[end]) {
//            start--;
//            end++;
//        }
//        if (size < end - start) {
//            res = new int[] {
//                    start + 1, end
//            };
//            size = end - start;
//        }
//    }
//
//    public double findMedianSortedArrays(int[] arr, int[] arr2) {
//        int al1 = arr.length;
//        int al2 = arr2.length;
//        int v1 = 0, v2 = 0;
//
//        // 5 -> 2, 4 -> 1, 2
//        int len = al1 + al2;
//        int t1, t2;
//        t2 = len / 2;
//        if (len % 2 == 0)
//            t1 = len / 2 - 1;
//        else
//            t1 = t2;
//
//        int p = 0;
//        int i = 0, j = 0;
//        boolean type;
//        while (!(i == al1 && j == al2)) {
//            int ai = i == al1 ? Integer.MAX_VALUE : arr[i];
//            int aj = j == al2 ? Integer.MAX_VALUE : arr2[j];
//            type = ai < aj;
//            int value = Math.min(ai, aj);
//
//            //            System.out.println(value);
//            if (p == t1) v1 = value;
//            if (p == t2) {
//                v2 = value;
//                return (v1 + v2) / 2F;
//            }
//            p++;
//            if (type) i++;
//            else j++;
//        }
//        return 0;
//    }
//
//
//
//    public int lengthOfLongestSubstring(String s) {
//        int res = -1, i = 0, j;
//        if (s.length() <= 1)
//            return s.length();
//
//        char[] chars = s.toCharArray();
//        HashMap < Character, Integer > map = new HashMap < > ();
//        map.put(chars[i], i);
//
//        for (j = 1; j < s.length(); j++) {
//            if (map.containsKey(chars[j])) {
//                int target = map.get(chars[j]);
//                while (i <= target) {
//                    map.remove(chars[i]);
//                    i++;
//                }
//            }
//            res = Math.max(res, j - i + 1);
//            map.put(chars[j], j);
//        }
//        return res;
//    }
//
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode dummy, res = new ListNode(0);
//        dummy = res;
//        while (l1 != null || l2 != null) {
//            int temp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + dummy.val;
//            dummy.val = temp % 10;
//            if (temp >= 10)
//                dummy.next = new ListNode(temp / 10);
//            dummy = dummy.next;
//            l1 = l1 == null ? null : l1.next;
//            l2 = l2 == null ? null : l2.next;
//        }
//        return res;
//    }
//
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[] {
//                            i,
//                            j
//                    };
//                }
//            }
//        }
//        return null;
//    }
//
//    public List < List < Integer >> threeSum(int[] nums) {
//        List < List < Integer >> res = new ArrayList < > ();
//        Arrays.sort(nums);
//        for (int i = 0; i + 2 < nums.length; i++) {
//            if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
//                continue;
//            }
//            int j = i + 1, k = nums.length - 1;
//            int target = -nums[i];
//            while (j < k) {
//                if (nums[j] + nums[k] == target) {
//                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                    j++;
//                    k--;
//                    while (j < k && nums[j] == nums[j - 1]) j++; // skip same result
//                    while (j < k && nums[k] == nums[k + 1]) k--; // skip same result
//                } else if (nums[j] + nums[k] > target) {
//                    k--;
//                } else {
//                    j++;
//                }
//            }
//        }
//        return res;
//    }
//
//    public List < List < Integer >> threeSum_1(int[] arr) {
//        HashSet < List < Integer >> list = new HashSet < > ();
//        Consumer < Integer > p = (index) -> {
//        int target = arr[index];
//        for (int i = index + 1; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[i] + arr[j] == -target) {
//                    List < Integer > a = Arrays.asList(target, arr[i], arr[j]);
//                    a.sort(Integer::compareTo);
//                    list.add(a);
//                }
//            }
//        }
//        };
//        for (int i = 0; i < arr.length; i++) p.accept(i);
//        return new ArrayList < > (list);
//    }
//
//    public List < List < Integer >> threeSum_2(int[] arr) {
//        HashMap < Integer, List < List < Integer >>> map = new HashMap < > ();
//        Arrays.sort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j < arr.length; j++) {
//                int key = arr[i] + arr[j];
//                List < List < Integer >> l = new ArrayList < > ();
//                if (map.containsKey(key))
//                    l = map.get(key);
//
//                l.add(Arrays.asList(i, j));
//                map.put(key, l);
//            }
//        }
//
//        Set < List < Integer >> list = new HashSet < > ();
//        for (int index = 0; index < arr.length; index++) {
//            int value = arr[index];
//            if (map.containsKey(-value)) {
//                List < List < Integer >> l = map.get(-value);
//                for (List < Integer > a: l) {
//
//                    if (a.contains(index))
//                        break;
//
//                    List < Integer > b = new ArrayList < > ();
//                    a.stream().forEach(integer -> b.add(arr[integer]));
//                    b.add(value);
//                    b.sort(Integer::compareTo);
//                    list.add(b);
//                }
//            }
//        }
//
//        return new ArrayList < > (list);
//    }
