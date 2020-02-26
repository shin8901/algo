package alog;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p1 {

	static int xlength;
	static int ylength;
	static int map[][];

	static int k;

	static int max = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {

		Scanner sc = new Scanner(System.in);

		k = sc.nextInt();
		xlength = sc.nextInt();
		ylength = sc.nextInt();

		int x = xlength - 1;
		int y = ylength - 1;

		map = new int[ylength][xlength];
		boolean visited[][][] = new boolean[ylength][xlength][k + 1];

		for (int i = 0; i < ylength; i++) {
			for (int j = 0; j < xlength; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0, 0, k, 0));

		// 말폼 이동
		int pattern1[][] = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };
		// 원숭이폼 이동
		int pattern2[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
		visited[0][0][k] = true;

		while (!q.isEmpty()) {
			Node d = q.poll();
			// System.out.println(d);
			if (d.x == x && d.y == y) {
				max = Integer.min(max, d.count);
				// System.out.println(d.count);
				break;
			}

			// 말폼
			if (d.k > 0) {
				for (int i = 0; i < pattern1.length; i++) {
					int nx = d.x + pattern1[i][0];
					int ny = d.y + pattern1[i][1];
					int nk = d.k - 1;

					if (nx > -1 && ny > -1 && nx < xlength && ny < ylength && map[ny][nx] == 0) {
						if (!visited[ny][nx][nk]) {
							visited[ny][nx][nk] = true;
							q.add(new Node(nx, ny, nk, d.count + 1));
						}

					}
				}
			}

			// 원숭이 폼
			for (int i = 0; i < pattern2.length; i++) {
				int nx = d.x + pattern2[i][0];
				int ny = d.y + pattern2[i][1];
				int nk = d.k;

				if (nx > -1 && ny > -1 && nx < xlength && ny < ylength && map[ny][nx] == 0) {
					// System.out.println(nx + " " + ny);
					if (!visited[ny][nx][nk]) {
						visited[ny][nx][nk] = true;
						q.add(new Node(nx, ny, nk, d.count + 1));
					}
				}
			}

		}

		System.out.println(max == Integer.MAX_VALUE ? -1 : max);
	}

	static class Node {
		Node() {
		}

		Node(int x, int y, int k, int count) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.count = count;
		}

		int x = 0;
		int y = 0;
		int k = 0;
		int count = 0;

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", k=" + k + ", count=" + count + "]";
		}

	}

}
