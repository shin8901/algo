package woonjae.hacker.array.new_year_chaos;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class Result {

	/*
	 * Complete the 'minimumBribes' function below.
	 *
	 * The function accepts INTEGER_ARRAY q as parameter.
	 */
	public static void minimumBribes(List<Integer> q) {
		// Write your code here

		int count = 0;
		for (int i = 0; i < q.size(); i++) {
			if (q.get(i) - (i + 1) > 2) {
				System.out.println("Too chaotic");
				return;
			}
		}

		for (int i = 0; i < q.size(); i++) {
			if (i + 1 != q.get(i)) {
				int tmpS = i + 1;
				for (int j = i + 1; j < q.size(); j++) {
					if (q.get(j) == tmpS) {
						int tmp = q.get(j - 1);
						q.set(j - 1, q.get(j));
						q.set(j, tmp);
						count += 1;
						i--;
						j = q.size();
					}
				}
			}
		}

		System.out.println(count);

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		Integer[] array = { 1, 2, 5, 3, 4, 7, 8, 6 };
		List<Integer> q = Arrays.asList(array);
		Result.minimumBribes(q);
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//		int t = Integer.parseInt(bufferedReader.readLine().trim());
//
//		IntStream.range(0, t).forEach(tItr -> {
//			try {
//				int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//				List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//						.map(Integer::parseInt).collect(toList());
//
//				Result.minimumBribes(q);
//			} catch (IOException ex) {
//				throw new RuntimeException(ex);
//			}
//		});
//
//		bufferedReader.close();
	}
}
