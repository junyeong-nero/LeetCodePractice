package leetcode;

import DataStructure.ListNode;
import DataStructure.TreeNode;

import java.util.*;
import java.util.function.Consumer;

public class Solution {

	ListNode node;
	int len;

	public Solution() {

	}

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		getAllElements(root1, node -> {
			map.putIfAbsent(node.val, 0);
			if (map.containsKey(node.val))
				map.put(node.val, map.get(node.val) + 1);
		});

		getAllElements(root2, node -> {
			map.putIfAbsent(node.val, 0);
			if (map.containsKey(node.val))
				map.put(node.val, map.get(node.val) + 1);
		});
		List<Integer> list = new ArrayList<>();
		while (!map.isEmpty()) {
			int key = map.firstKey();
			for (int i = 0; i < map.get(key); i++)
				list.add(key);
			map.remove(key);
		}
		return list;
	}

	public void getAllElements(TreeNode root, Consumer<TreeNode> consumer) {
		if (root == null)
			return;
		consumer.accept(root);
		getAllElements(root.left, consumer);
		getAllElements(root.right, consumer);
	}

	public boolean validMountainArray(int[] arr) {
		if (arr.length < 3) return false;
		int i = 0;
		while (i <= arr.length - 2 && arr[i + 1] > arr[i]) i++;
		if (i == 0 || i == arr.length - 1) {
			return false;
		}
		while (i <= arr.length - 2 && arr[i + 1] < arr[i]) i++;
		return i == arr.length - 1;
	}

	public boolean MYvalidMountainArray(int[] arr) {
		int N = arr.length;
		if (N < 3 || arr[0] > arr[1])
			return false;
		boolean side = true;
		for (int i = 0; i < N - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				if (!side) {
					return false;
				}
			} else if (arr[i] > arr[i + 1]) {
				if (side) {
					side = false;
				}
			} else {
				// same
				return false;
			}
		}
		return !side;
	}

	public boolean detectCapitalUse(String word) {
		int n = word.length();
		if (n <= 0)
			return false;
		char c = word.charAt(0);
		// Google
		// USA
		boolean lower = false;
		boolean upper = false;
		if (n >= 2) {
			for (int i = 1; i < n; i++) {
				char a = word.charAt(i);
				lower |= Character.isUpperCase(a);
				upper |= Character.isLowerCase(a);
			}
		}
		if (!lower)
			return true;
		return !upper && Character.isUpperCase(c);
	}

	public int digitGenerator(int digit, int start) {
		int res = 0;
		for (int j = 0; j < digit; j++) {
			res *= 10;
			res += start;
			start += 1;
		}
		return res;
	}

	public List<Integer> sequentialDigits(int low, int high) {
		int n = (int) Math.floor(Math.log10(low)) + 1;
		int m = (int) Math.floor(Math.log10(high)) + 1;
		List<Integer> list = new ArrayList<>();
		// 100 -> 3
		// 123 -> 3
		for (int i = n; i <= m; i++) {
			// 1 - 6 at XXXX
			for (int j = 1; j <= 10 - i; j++) {
				int num = digitGenerator(i, j);
				System.out.println(num);
				if (num >= low && num <= high)
					list.add(num);
				if (num > high)
					break;
			}
		}
		return list;
	}

	public boolean winnerSquareGame(int n) {
		boolean[] dp = new boolean[n + 1];
		for (int i = 1; i <= n; ++i) {
			for (int k = 1; k * k <= i; ++k) {
				if (!dp[i - k * k]) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[n];
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int cur = 0;
		int n = gas.length;
		for (int i = 0; i < n; i++) {
			if (checkCompletCircuit(i, gas, cost))
				return i;
		}
		return -1;
	}

	public boolean checkCompletCircuit(int start, int[] gas, int[] cost) {
		int cur = 0;
		int n = gas.length;
		for (int i = start; i < start + n; i++) {
			int r = i % n;
			cur += gas[r];
			if (cur < cost[r])
				return false;
			cur = cur - cost[r];
		}
		return true;
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;

		ListNode slow = head, fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast)
				break;
		}

		if (slow == fast) {
			slow = head;
			while (slow != fast) {
				slow = slow.next;
				fast = fast.next;
			}
			return slow;
		}
		return null;
	}

	public ListNode MYdetectCycle(ListNode head) {
		ListNode cur = head;
		Set<ListNode> set = new HashSet<>();
		while (cur != null) {
			if (set.contains(cur))
				return cur;
			else
				set.add(cur);
			cur = cur.next;
		}
		return null;
	}

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int N = flowerbed.length;
		if (N == 0)
			return false;
		int count = 0;
		for (int i = 0; i < N; i++) {
			boolean a = i + 1 >= N || flowerbed[i + 1] == 0;
			boolean b = i - 1 < 0 || flowerbed[i - 1] == 0;
			boolean c = flowerbed[i] == 0;
			if (a && b && c) {
				count++;
				flowerbed[i] = 1;
			}
		}
		return n <= count;
	}

	public boolean wordPattern(String pattern, String s) {
		String[] list = s.split(" ");
		HashMap<String, Character> map = new HashMap<>();
		boolean[] check = new boolean[26];
		Arrays.fill(check, false);
		int len = list.length;
		for (int i = 0; i < len; i++) {
			String target = list[i];
			char c = pattern.charAt(i);
			if (map.containsKey(target)) {
				if (map.get(target) != c)
					return false;
			} else {
				if (check[c - 'a'])
					return false;
			}
			map.put(target, c);
			check[c - 'a'] = true;
		}
		return true;
	}


	// BFS
	public int minJumps(int[] arr) {
		int n = arr.length;
		HashMap<Integer, List<Integer>> indicesOfValue = new HashMap<>();
		for (int i = 0; i < n; i++)
			indicesOfValue.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);
		boolean[] visited = new boolean[n];
		visited[0] = true;
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		int step = 0;
		while (!q.isEmpty()) {
			for (int size = q.size(); size > 0; --size) {
				int i = q.poll();
				if (i == n - 1) return step; // Reached to last index
				List<Integer> next = indicesOfValue.get(arr[i]);
				next.add(i - 1);
				next.add(i + 1);
				for (int j : next) {
					if (j >= 0 && j < n && !visited[j]) {
						visited[j] = true;
						q.offer(j);
					}
				}
				next.clear(); // avoid later lookup indicesOfValue arr[i]
			}
			step++;
		}
		return 0;
	}

	int history[];

	public int minJumpsDFS(int[] arr, int pos) {
		int res = Integer.MAX_VALUE;
		int n = arr.length;
		if (history[pos] != Integer.MAX_VALUE)
			return history[pos];
		if (pos == n - 1)
			return 0;
		if (pos + 1 < n)
			res = Math.min(res, minJumpsDFS(arr, pos + 1));
		if (pos - 1 >= 0)
			res = Math.min(res, minJumpsDFS(arr, pos - 1));
		for (int i = pos + 1; i < n; i++) {
			if (arr[i] == arr[pos]) {
				res = Math.min(res, minJumpsDFS(arr, i));
			}
		}
		if (res != Integer.MAX_VALUE)
			history[pos] = res + 1;
		return res + 1;
	}

	//	Read in and ignore any leading whitespace.
//	Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
//	Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
//	Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
//	If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
//	Return the integer as the final result.
	public int myAtoi(String s) {
		int l = s.length();
		long value = 0;
		int sign = 1;
		boolean start = false;
		for (int i = 0; i < l; i++) {
			char c = s.charAt(i);
			if (!start) {
				if (c == ' ')
					continue;
				else {
					start = true;
					if (c == '.')
						return 0;
					else if (c == '-')
						sign = -1;
					else if (c == '+')
						sign = 1;
					else if (c >= '0' && c <= '9')
						value += c - '0';
					else
						return 0;
				}
			} else {
				if (c >= '0' && c <= '9') {
					value *= 10;
					value += c - '0';

					long temp = value * sign;
					if (temp > Integer.MAX_VALUE) {
						return Integer.MAX_VALUE;
					}
					if (temp < Integer.MIN_VALUE) {
						return Integer.MIN_VALUE;
					}

				} else {
					break;
				}
			}
		}
		return (int) value * sign;
	}

	public int findMinArrowShots(int[][] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		Arrays.sort(points, Comparator.comparingInt(o -> o[1])); //Using Integer.compare() to avoid edge case
		int count = 1;
		int end = points[0][1];
		for (int[] point : points) {
			int start = point[0];
			if (start > end) {
				count++;
				end = point[1];
			}
		}
		return count;
	}

	public boolean checkIntersection(int[] a, int[] b) {
		return (a[0] <= b[0] && b[0] <= a[1]) || (a[0] <= b[1] && b[1] <= a[1]);
	}

	public int[] findIntersection(int[] a, int[] b) {
		return new int[]{Math.max(a[0], b[0]), Math.min(a[1], b[1])};
	}

	// 890. Find and Replace Pattern
	public List<String> findAndReplacePattern(String[] words, String pattern) {
		List<String> res = new ArrayList<>();
		for (String s : words) {
			if (check(s, pattern))
				res.add(s);
		}
		return res;
	}

	public boolean check(String word, String pattern) {
		HashMap<Integer, Integer> map = new HashMap<>(); // pattern -> word
		int n = word.length();
		int m = pattern.length();
		if (n != m)
			return false;
		for (int i = 0; i < m; i++) {
			int p = pattern.charAt(i) - 'a';
			int w = word.charAt(i) - 'a';
			if (!map.containsKey(p) && !map.containsValue(w))
				map.put(p, w);
			else {
				if (map.containsKey(p) && map.get(p) != w)
					return false;
				if (map.containsValue(w)) {
					for (Integer j : map.keySet()) {
						if (map.get(j) == w && j != p)
							return false;
					}
				}
			}
		}
		return true;
	}

	// 701. Insert into a Binary Search Tree
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);
		test(root, val);
		return root;
	}

	public void test(TreeNode root, int val) {
		if (val > root.val) {
			if (root.right == null)
				root.right = new TreeNode(val);
			else
				test(root.right, val);
		} else if (val < root.val) {
			if (root.left == null)
				root.left = new TreeNode(val);
			else
				test(root.left, val);
		}
	}

	public int[] xorQueries(int[] A, int[][] queries) {
		int[] res = new int[queries.length], q;
		for (int i = 1; i < A.length; ++i)
			A[i] ^= A[i - 1];
		for (int i = 0; i < queries.length; ++i) {
			q = queries[i];
			res[i] = q[0] > 0 ? A[q[0] - 1] ^ A[q[1]] : A[q[1]];
		}
		return res;
	}

	public int[] MYxorQueries(int[] arr, int[][] queries) {
		int n = queries.length;
		int[] res = new int[n];
		for (int i = 0; i < queries.length; i++) {
			int start = queries[i][0];
			int end = queries[i][1];
			int temp = arr[start];
			for (int j = start + 1; j <= end; j++) {
				temp ^= arr[j];
			}
			res[i] = temp;
		}
		return res;
	}

	int sumRootToLeafRES = 0;

	public int sumRootToLeaf(TreeNode root) {
		sumRootToLeafDFS(root, 0);
		return sumRootToLeafRES;
	}

	public void sumRootToLeafDFS(TreeNode root, int cur) {
		if (root == null)
			return;
		int temp = root.val + cur * 2;
		if (root.right == null && root.left == null) {
			sumRootToLeafRES += temp;
			return;
		}
		sumRootToLeafDFS(root.right, temp);
		sumRootToLeafDFS(root.left, temp);
	}

	public String addBinary(String a, String b) {
		StringBuilder sa = new StringBuilder(a).reverse();
		StringBuilder sb = new StringBuilder(b).reverse();
		StringBuilder builder = new StringBuilder();
		int size = Math.max(sa.length(), sb.length());
		int raise = 0;
		for (int i = 0; i < size; i++) {
			char ca = i < sa.length() ? sa.charAt(i) : '0';
			char cb = i < sb.length() ? sb.charAt(i) : '0';
			int numA = (int) ca - '0';
			int numB = (int) cb - '0';
			int result = raise + numA + numB;
			builder.append(result % 2);
			raise = result / 2;
		}
		if (raise != 0)
			builder.append(raise);
		return builder.reverse().toString();
	}

	// 773. Sliding Puzzle
	public int slidingPuzzle(int[][] board) {
		String target = "123450";
		String start = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				start += board[i][j];
			}
		}
		HashSet<String> visited = new HashSet<>();
		// all the positions 0 can be swapped to
		int[][] dirs = new int[][]{{1, 3}, {0, 2, 4},
				{1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
		Queue<String> queue = new LinkedList<>();
		queue.offer(start);
		visited.add(start);
		int res = 0;
		while (!queue.isEmpty()) {
			// level count, has to use size control here, otherwise not needed
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				if (cur.equals(target)) {
					return res;
				}
				int zero = cur.indexOf('0');
				// swap if possible
				for (int dir : dirs[zero]) {
					String next = swap(cur, zero, dir);
					if (visited.contains(next)) {
						continue;
					}
					visited.add(next);
					queue.offer(next);

				}
			}
			res++;
		}
		return -1;
	}

	private String swap(String str, int i, int j) {
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(i, str.charAt(j));
		sb.setCharAt(j, str.charAt(i));
		return sb.toString();
	}

	public int MyslidingPuzzle(int[][] board) {
		int[] temp = new int[2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) {
					temp[0] = i;
					temp[1] = j;
				}
			}
		}
		if (check(board))
			return 0;

		return slidingPuzzleDFS(board, temp, -1);
	}

	public int slidingPuzzleDFS(int[][] board, int[] pos, int dir) {
		int res = Integer.MAX_VALUE;
		if (check(board))
			return 0;

		int[] posX = new int[]{0, 1, 0, -1};
		int[] posY = new int[]{1, 0, -1, 0};
		for (int i = 1; i <= 4; i++) {
			int new_dir = (dir + i) % 4;
			int[] new_pos = new int[]{
					pos[0] + posX[new_dir],
					pos[1] + posY[new_dir]
			};
			int x = new_pos[0];
			int y = new_pos[1];
			if (x < 0 || x >= 2 || y < 0 || y >= 3)
				continue;
			if (x == pos[0] && y == pos[1])
				continue;
			int b = board[x][y];
			board[x][y] = 0;
			board[pos[0]][pos[1]] = b;
			System.out.println(Arrays.deepToString(board));
			res = Math.min(res, slidingPuzzleDFS(board, new_pos, new_dir));
			board[x][y] = b;
			board[pos[0]][pos[1]] = 0;
		}
		return res + 1;
	}

	public boolean check(int[][] board) {
		return board[0][0] == 1 && board[0][1] == 2 && board[0][2] == 3 &&
				board[1][0] == 4 && board[1][1] == 5;
	}
}
