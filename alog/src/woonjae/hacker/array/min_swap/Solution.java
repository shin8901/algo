package woonjae.hacker.array.min_swap;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		System.out.println(Arrays.toString(arr));
		int count = 0;
		for (int i = 0; i < arr.length;) {
			if (arr[i] == i + 1) {
				i++;
				continue;
			}
			int tmp = arr[arr[i] - 1];
			arr[arr[i] - 1] = arr[i];
			arr[i] = tmp;
			count++;
			System.out.println(Arrays.toString(arr));
		}

		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
//		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//		int n = scanner.nextInt();
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		int[] arr = new int[n];
//
//		String[] arrItems = scanner.nextLine().split(" ");
//		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//		for (int i = 0; i < n; i++) {
//			int arrItem = Integer.parseInt(arrItems[i]);
//			arr[i] = arrItem;
//		}

		int[] arr = { 4, 3, 1, 2 };
		int res = minimumSwaps(arr);
		System.out.println(res);
//
//		bufferedWriter.write(String.valueOf(res));
//		bufferedWriter.newLine();
//
//		bufferedWriter.close();

		scanner.close();
	}
}
