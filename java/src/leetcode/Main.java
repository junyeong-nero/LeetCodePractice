package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static long merge(int[] arr, int start, int mid, int end) {
		// 1 2 3 4 1 2 3 4
		// start = 0, mid = 3, end = 7
		// start = 0, mid = 4, end = 8
		long inv = 0;
		int n1 = mid - start + 1;
		int n2 = end - mid;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for (int i = 0; i < n1; i++)
			L[i] = arr[start + i];
		for (int i = 0; i < n2; i++)
			R[i] = arr[mid + i + 1];

		int i = 0, j = 0, k = start;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k++] = L[i++];
			} else {
//				System.out.println(L[i] + "," + R[j]);
				arr[k++] = R[j++];
				inv += n1 - i;
			}
		}
		if (i == n1) {
			for (int m = j; m < n2; m++) {
				arr[k++] = R[m];
			}
		}
		if (j == n2) {
			for (int m = i; m < n1; m++) {
				arr[k++] = L[m];
			}
		}
//		System.out.println(Arrays.toString(L));
//		System.out.println(Arrays.toString(R));
//		System.out.println(Arrays.toString(arr));
//		System.out.println(inv);
		return inv;
	}

	public static long mergeSort(int[] arr, int start, int end) {
		if (start >= end)
			return 0;
		int mid = (start + end) / 2;
		long a = mergeSort(arr, start, mid);
		long b = mergeSort(arr, mid + 1, end);
		return merge(arr, start, mid, end) + a + b;
	}

	public static long mergeSort(int[] arr) {
		return mergeSort(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(br.readLine());
		int[] arr = new int[len];
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		for (int i = 0; i < len; i++) {
			arr[i] = Integer.parseInt(tokenizer.nextToken());
		}
		long res = mergeSort(arr);
//		System.out.println(Arrays.toString(arr));
		System.out.println(res);
	}
}
