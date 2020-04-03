package woonjae.hacker.twostring;

import java.util.HashMap;
import java.util.Scanner;

public class Solution {

	// Complete the checkMagazine function below.
	static void checkMagazine(String[] magazine, String[] note) {
		HashMap<String, Integer> maps = new HashMap<>();
		for (int i = 0; i < magazine.length; i++) {
			maps.put(magazine[i], maps.getOrDefault(magazine[i], 0) + 1);
		}

		for (int i = 0; i < note.length; i++) {
			int value = maps.getOrDefault(note[i], 0);
			if (value == 0) {
				System.out.println("No");
				return;
			}
			maps.put(note[i], value - 1);
		}
		System.out.println("Yes");
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String[] mn = scanner.nextLine().split(" ");

		int m = Integer.parseInt(mn[0]);

		int n = Integer.parseInt(mn[1]);

		String[] magazine = new String[m];

		String[] magazineItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < m; i++) {
			String magazineItem = magazineItems[i];
			magazine[i] = magazineItem;
		}

		String[] note = new String[n];

		String[] noteItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			String noteItem = noteItems[i];
			note[i] = noteItem;
		}

		checkMagazine(magazine, note);

		scanner.close();
	}
}
