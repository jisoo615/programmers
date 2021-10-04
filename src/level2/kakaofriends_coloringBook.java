package level2;

import java.util.Stack;
//https://programmers.co.kr/learn/courses/30/lessons/1829
//카카오 프렌즈 컬리링북 색칠하기
public class kakaofriends_coloringBook {

	public static void main(String[] args) {
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int m=6, n=4;
		int[][] book = new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				book[i][j] = picture[i][j];
			}
		}

		int max = 0;
		int area = 0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(book[i][j] > 0) {
					area++;
					max = Math.max(sameArea(i, j, book), max);
				}
			}
		}

		System.out.print("["+area+", "+max+"]");

	}

	static public int sameArea(int x, int y, int[][] picture) {
		int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		int color = picture[x][y];

		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] {x, y});
		picture[x][y] = 0;
		int cnt = 1;
		while(!stack.isEmpty()) {
			int[] xy = stack.pop();

			for(int i=0; i<4; i++) {
				int newx = xy[0] + direction[i][0];
				int newy = xy[1] + direction[i][1];
				if(newx>=0 && newx<picture.length && newy>=0 && newy<picture[0].length) {
					if(color == picture[newx][newy]) {
						stack.push(new int[] {newx, newy});
						cnt++;
						picture[newx][newy] = 0;
						}
					}
			}
		}

		return cnt;
	}

}
