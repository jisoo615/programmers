package level2;

public class kakao_2021_intern {
//
	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
		                     {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
		                     {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
		                     {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
		                     {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
		int answer[] = solution(places);
		for(int a : answer) System.out.print(a+", ");
	}

	public static int[] solution(String[][] places) {//5���� ������ ���� 5*5�ڸ��� ���´�.
		int[] answer = {};
		boolean visited[][] = new boolean[5][5];


		return answer;
	}

	static int[] dirX = {-1, };
	static int[] dirY = {0, };

	public static boolean dfs(String[][] places, boolean[][] visited) {

		return true;
	}

}
