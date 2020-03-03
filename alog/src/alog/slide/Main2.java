package alog.slide;

import java.util.Scanner;

public class Main2 {

	static int N;
	static int M;
	static int[][] MAP;
	static boolean[][] visited;
	static int[][] memory;
	static int pattern[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };

	static int answer = Integer.MAX_VALUE;
	static int count = 0;

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			N = sc.nextInt();
			M = sc.nextInt();

			MAP = new int[N][M];
			memory = new int[N][M];
			visited = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					MAP[i][j] = sc.nextInt();
				}
			}

//			Queue<Node> node = new LinkedList<>();
//			node.add(new Node(0, 0));
//			while (!node.isEmpty()) {
//				Node n = node.poll();
//
//				int x = n.x;
//				int y = n.y;
//				for (int i = 0; i < pattern.length; i++) {
//					int nx = x + pattern[i][0];
//					int ny = y + pattern[i][1];
//					if (nx > -1 && ny > -1 && nx < M && ny < N && MAP[y][x] > MAP[ny][nx]) {
//
//					}
//				}
//			}
			visited[0][0] = true;
			System.out.println(dfs(0, 0));

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(memory[i][j]);
//				}
//				System.out.println();
//			}

			// System.out.println(count);

		}
	}

	private static int dfs(int y, int x) {

		if (y >= N)
			return 0;
		if (x >= M)
			return 0;

		if (y == N - 1 && x == M - 1) {
			count++;
			return 1;
		}

		for (int i = 0; i < pattern.length; i++) {
			int nx = x + pattern[i][0];
			int ny = y + pattern[i][1];

			if (nx > -1 && ny > -1 && nx < M && ny < N && MAP[y][x] > MAP[ny][nx]) {
				if (!visited[ny][nx]) {
					visited[ny][nx] = true;
					memory[ny][nx] = dfs(ny, nx);
				}
				memory[y][x] += memory[ny][nx];
//				for (int ix = 0; ix < N; ix++) {
//					for (int jx = 0; jx < M; jx++) {
//						System.out.print(memory[ix][jx]);
//					}
//					System.out.println();
//				}
//				System.out.println();
			}

		}
		return memory[y][x];
	}

}
