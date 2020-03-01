package alog.flower;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int map[][];

	static int visted[][];
	static int answer = Integer.MAX_VALUE;

	static int pattern[][] = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	static Queue<Node> nodes = new LinkedList<Main.Node>();

	static int k;

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			k = sc.nextInt();

			map = new int[k][k];
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < k; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < k; i++) {
				for (int j = 0; j < k; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

			// dfs(0, 0);
			dfsFind(0, 0, 1);

			System.out.println(answer);
		}
	}

	private static void dfs(int x, int y) {
		if (y >= k) {
			return;
		}
		if (x >= k) {
			y = y + 1;
			x = 1;
			dfs(x, y);
		} else {
			dfsFind(x, y, 1);
			dfs(x + 1, y);
		}
	}

	private static void dfsFind(int x, int y, int depth) {
		if (depth == 4) {
			int value = 0;
			while (!nodes.isEmpty()) {
				Node v = nodes.poll();
				value += v.value;
				System.out.println("v.value " + v.value);
			}
			answer = Integer.min(answer, value);
			System.out.println("value " + value);
			return;
		}

		int nDept = depth;

		if (isRightPosition(x, y, depth)) {
			nDept += 1;
		}
		for (int i = x; i < k; i++) {
			for (int j = 0; j < k; j++) {
				dfsFind(i + 1, j, nDept);
			}
		}
		removeNode(nDept);
	}

	private static void removeNode(int depth) {
		for (Iterator<Node> iterator = nodes.iterator(); iterator.hasNext();) {
			Node node = iterator.next();
			if (node.depth == depth) {
				nodes.remove(node);
			}
		}
	}

	private static boolean isRightPosition(int x, int y, int depth) {
		if (checkedRanage(x, y)) {
			Queue<Node> dd = new LinkedList<>();
			for (int i = 0; i < pattern.length; i++) {
				int nx = x + pattern[i][0];
				int ny = y + pattern[i][1];
				if (checkedRanage(nx, ny)) {
					System.out.println(map[ny][nx]);
					Node temp = new Node(nx, ny, map[ny][nx], depth);
					System.out.println(temp);
					if (nodes.contains(temp)) {
						return false;
					}
					dd.add(temp);
				} else {
					return false;
				}

			}
			nodes.add(new Node(x, y, map[y][x], depth));
			nodes.addAll(dd);
		}
		return true;
	}

	private static boolean checkedRanage(int nx, int ny) {
		return nx > -1 && ny > -1 && nx < k && ny < k;
	}

	static class Node {
		int value;
		int x = 0;
		int y = 0;
		int depth = 0;

		Node() {
		}

		Node(int x, int y, int value, int depth) {
			this.x = x;
			this.y = y;
			this.value = value;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", value=" + value + "]";
		}

		@Override
		public boolean equals(Object obj) {
			Node dd = (Node) obj;
			if (dd.x == this.x && dd.y == this.y)
				return true;
			else
				return super.equals(obj);
		}

	}
}
