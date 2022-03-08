package level3;
//https://programmers.co.kr/learn/courses/30/lessons/42898
//등굣길
public class Dp_on_the_way_to_school {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(4,3, new int[][] {{2,2}}));//4

	}

	static class Solution {
		public static int[][] dp;
        private int m, n;
	    public int solution(int m, int n, int[][] puddles) {//집=1,1 학교=m,n, 잠긴곳puddles
            this.m = m; this.n=n;
	        dp = new int[n][m];
            dp[0][0] = 1;//0,0에만 1을 넣어주기 -> 1,0 0,1에 웅덩이 있을 경우 나머지 테두리는 0이 되어야 하기때문
	        for(int[] puddle : puddles) {// x,y -> y,x로 변환필요
	        	dp[puddle[1]-1][puddle[0]-1] = -1;
	        }

	        int answer = find(n-1, m-1);

	        return answer;
	    }

	    int find(int x, int y) {
            if(x<0||x>=this.n || y<0||y>=this.m){//범위 넘어가면
                return 0;
            }
	    	if(dp[x][y] == -1) return 0;

	    	if(dp[x][y] !=0) {
	    		return dp[x][y]%1000000007;
	    	}

	    	return dp[x][y] = (find(x,y-1)+ find(x-1,y))%1000000007;
	    }
	}

}
