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
		static public int[][] dxy= {{0, 1},{0, -1}, {1, 0}, {-1, 0}};
	    public int solution(int[][] board, int[] aloc, int[] bloc) {
	        int answer = -1;
	        //TODO:시도는 해봤으나 너무 어려워서 다음에 다시 도전하기, 비슷한 문제 : 백준 알파 틱택토 p16571
	        return answer;
	    }

}
}
