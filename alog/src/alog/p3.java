package alog;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p3 {
	static int map[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int hx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int hy[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
	static int dist[][][];
	static int W;
	static int H;
	static int K;

	static class monky {
		int x, y, k;

		public monky(int x, int y, int k) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			this.k = k;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[W][H];
		dist = new int[W][H][K + 1];
		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		bfs();

	}

	static void bfs() {

		Queue<monky> queue = new LinkedList<>();
		queue.add(new monky(0, 0, K));
		while (!queue.isEmpty()) {
			monky m = queue.poll();
			if (m.x == H - 1 && m.y == W - 1) {
				System.out.println(dist[m.x][m.y][m.k]);
				return;
			}
			// K가 남아있는 경우
			if (m.k > 0) {
				for (int i = 0; i < 8; i++) {
					// 맵 탈출 검사
					int x = m.x + hx[i];
					int y = m.y + hy[i];
					if (x > -1 && x < W && y > -1 && y < H && map[x][y] != 1 && dist[x][y][m.k - 1] == 0) {
						dist[x][y][m.k - 1] = dist[m.x][m.y][m.k] + 1;
						queue.add(new monky(x, y, m.k - 1));
					}
				}
			}
			// K가 남아있지 않은 경우
			for (int i = 0; i < 4; i++) {
				int x = m.x + dx[i];
				int y = m.y + dy[i];
				if (x > -1 && x < W && y > -1 && y < H && map[x][y] != 1 && dist[x][y][m.k] == 0) {
					dist[x][y][m.k] = dist[m.x][m.y][m.k] + 1;
					queue.add(new monky(x, y, m.k));
				}
			}
		}
		System.out.println(-1);
	}
}
