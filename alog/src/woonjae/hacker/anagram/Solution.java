package woonjae.hacker.anagram;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	// Complete the twoStrings function below.
	static String twoStrings(String s1, String s2) {

		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s1.length(); i++) {
			char d = s1.charAt(i);
			map.put(d, map.getOrDefault(d, 0) + 1);
		}

		int count = 0;
		for (int i = 0; i < s2.length(); i++) {
			char d = s2.charAt(i);
			int value = map.getOrDefault(d, 0);
			if (value > 1) {
				count = 2;
			} else if (value > 0) {
				count++;
			}
			if (count == 2) {
				break;
			}
		}
		return (count == 2) ? "YES" : "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			String s2 = scanner.nextLine();

			String result = twoStrings(s1, s2);
			System.out.println(result);

		}

		scanner.close();
	}
}
