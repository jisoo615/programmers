package kako;

//https://programmers.co.kr/learn/courses/30/lessons/92345
//카카오 2022 사라지는 발판
public class kakao_2022_disappear_footstand {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] board = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
		int[] aloc = {1, 0};
		int[] bloc = {1, 2};
		System.out.print(s.solution(board, aloc, bloc));
	}

	static class Solution {
		static int[][] dxy= {{0, 1},{0, -1}, {1, 0}, {-1, 0}};
	    public int solution(int[][] board, int[] aloc, int[] bloc) {
	        int answer = -1;

	        //무조건 a가 먼저 움지거여야 하고, b가 무조건 이겨야 하는 경우중 젤 적게 움직이는 횟수를 구하라
	        //b가 이기는 경우 = a가 갈곳이 없을때
	        //모든 경우의 수중에 제일 적은 초이 결과만 계속 내어 리턴한다.
	        dfs(aloc, bloc, 0, board);


	        return answer;
	    }

		private void dfs(int[] aloc, int[] bloc, int move, int[][] board) {
			board[aloc[0]][aloc[1]]--;
			board[bloc[0]][bloc[1]]--;
			for(int i=0; i<4; i++) {
				int nx = aloc[0]+dxy[i][0];
				int ny = aloc[1]+dxy[i][1];
				if(nx>=0 && nx<board.length && ny>=0&&ny<board.length) {
					if(board[nx][ny]!=0) {
						//aq.add(new int[] {nx, ny});
					}
				}
			}//for a's dxy

			for(int i=0; i<4; i++) {
				int nx = bloc[0]+dxy[i][0];
				int ny = bloc[1]+dxy[i][1];
				if(nx>=0 && nx<board.length && ny>=0&&ny<board.length) {
					if(board[nx][ny]!=0) {
						//return dfs
					}
				}
			}//for b's dxy




			}


	}

}
