package level2;
//https://programmers.co.kr/learn/courses/30/lessons/12913
//땅따먹기
//4열 n헹 한 행씩 내려올 때, 같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다. 가장 높은 점수는?
public class ddangddamukgi_dp {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		System.out.println(s.solution(land));
	}

	static class Solution {
	    int solution(int[][] land) {
	        int answer = 0;

	        answer = dp(land);

	        return answer;
	    }

	   static int dp(int[][] land) {
		   for(int i=1; i<land.length; i++) {
			   land[i][0] += max(land[i-1][1], land[i-1][2], land[i-1][3]);
			   land[i][1] += max(land[i-1][0], land[i-1][2], land[i-1][3]);
			   land[i][2] += max(land[i-1][0], land[i-1][1], land[i-1][3]);
			   land[i][3] += max(land[i-1][0], land[i-1][1], land[i-1][2]);
		   }
		   int answer = 0;
		   for(int i=0; i<4; i++) {
			   if(answer < land[land.length-1][i]) {
				   answer = land[land.length-1][i];
			   }
		   }
		   return answer;
	   }

	  static int max(int x, int y, int z) {
		   int max = Math.max(x, Math.max(y, z));
		   return max;
	   }
	}

}
