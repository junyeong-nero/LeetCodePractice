package leetcode;

import DataStructure.ListNode;
import DataStructure.MyStack;
import DataStructure.TreeNode;
import com.sun.source.tree.Tree;

import java.util.*;

public class Solution {

	ListNode node;
	int len;

	public Solution() {

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