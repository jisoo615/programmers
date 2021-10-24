package level3;

import java.util.Stack;

public class pick_item {

	static class Player{//코드 1줄부터 컴파일 하기 때문에 Player클래스를 new로 생성하기 전에 선언해줘야 한다, static을 붙여줘야 함
		int x; int y;
		public Player(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void main(String[] args) {
		int[][] rectangle= {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
		int characterX =1, characterY= 3;
		int itemX=7, itemY=8;
		System.out.print(solution(rectangle, characterX, characterY, itemX, itemY));
	}

	static public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		int startX = characterX, startY = characterY;
		int endX = itemX, endY = itemY;

		boolean[][] matrix = new boolean[105][105];
		//테두리와 사각형 안에까지 다 true로 지정
		for(int[] rect : rectangle) {
			for(int i=rect[0]*2; i<=rect[2]*2; i++) {
				for(int j=rect[1]*2; j<=rect[3]*2; j++) {
					matrix[i][j] = true;
				}
			}
		}
		//테두리만 빼고 다시 false지정
		for(int[] rect : rectangle) {
			for(int i=rect[0]*2+1; i<rect[2]*2; i++) {
				for(int j=rect[1]*2+1; j<rect[3]*2; j++) {
					matrix[i][j] = false;
				}
			}
		}
		//bfs 부르트포스 완전 탐색
		Stack<Player> stack = new Stack<>();
		stack.push(new Player(startX, startY));
		int[] result = new int[2];
		int cnt=0;
		while(true) {
			if(stack.isEmpty()) {//아이템->출발지 --> cnt-(출발지->아이템 cnt) 해줘야됨
				result[1] = cnt;
				break;
			}

			Player temp = stack.pop();
			int x = temp.x; int y = temp.y;
			if(x==endX && y==endY) {//출발지->아이템
				result[0] = cnt;
				break;
			}
			matrix[x][y]=false;//지난간 자리는 다시 false
			//아래 넷중 하나에 걸려듬 스택에 넣고 -> 그다음 cnt++ 해주기
			if(matrix[x+1][y]==true) stack.push(new Player(x+1, y));
			if(matrix[x][y+1]==true) stack.push(new Player(x, y+1));
			if(matrix[x-1][y]==true) stack.push(new Player(x-1, y));
			if(matrix[x][y-1]==true) stack.push(new Player(x, y-1));

			cnt++;
		}

		return Math.min( result[0]/2, (result[1]-result[0])/2 );
	}
}