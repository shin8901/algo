package alog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class p1 {

	static int xlength;
	static int ylength;
	static int map[][];

	static int k;

	static int max = Integer.MAX_VALUE;

//	1
//	4 4
//	0 0 0 0
//	1 0 0 0
//	0 0 1 0
//	0 1 0 0

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		k = br.read();
		xlength = br.read();
		ylength = br.read();

		int x = xlength - 1;
		int y = ylength - 1;

		map = new int[xlength][ylength];
		boolean visited[][][] = new boolean[xlength][ylength][k + 1];

		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0, 0, k, 0));

		// 말폼 이동
		int pattern1[][] = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, 1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 } };
		// 원숭이폼 이동
		int pattern2[][] = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, 1 } };
		visited[0][0][k] = true;
		while (!q.isEmpty()) {
			System.out.println(11);
			Node d = q.poll();

			if (d.x == x && d.y == y) {
				max = Integer.min(max, d.count);
				System.out.println(d.count);
				break;
			}

			if (d.x == 1 && d.y == 1) {
				continue;
			}

			// 말폼
			if (d.k > 0) {
				for (int i = 0; i < pattern1.length; i++) {
					int nx = d.x + pattern1[i][0];
					int ny = d.y + pattern1[i][1];
					int nk = d.k - 1;

					if (nx > 0 && ny > 0 && nx < xlength && ny < ylength) {
						if (!visited[nx][ny][nk]) {
							visited[nx][ny][nk] = true;
							Node newNode = new Node(nx, nx, nk, d.count + 1);
							q.add(newNode);
						}

					}
				}
			}

			// 원숭이 폼
			for (int i = 0; i < pattern2.length; i++) {
				int nx = d.x + pattern1[i][0];
				int ny = d.y + pattern1[i][1];
				int nk = d.k;

				if (nx > 0 && ny > 0 && nx < xlength && ny < ylength) {
					if (!visited[nx][ny][nk]) {
						visited[nx][ny][nk] = true;
						Node newNode = new Node(nx, nx, nk, d.count + 1);
						q.add(newNode);
					}
				}
			}

		}

		System.out.println(max);
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
		public boolean equals(Object obj) {
			if (super.equals(obj))
				return true;
			else {
				Node d = (Node) obj;
				if (d.x == this.x && d.y == this.y)
					return true;
				else
					return false;

			}
		}
	}

}
