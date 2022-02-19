package level2;

public class fibonacci {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(5));

	}
	static class Solution {
		int[] dp;
		int sum=0;
	    public int solution(int n) {//n번째 피보나치 수
	        int answer = 0;
	        dp = new int[100001];
	        dp[0]=0;
	        dp[1]=1;
	        dp[2]=1;
	        dp[3]=2;
	        answer = fibo(n);

	        return answer%1234567;
	    }

	    int fibo(int n) {
	    	if(n==0) return dp[0];
	    	if(dp[n]>0) return dp[n];
	    	return dp[n] = (fibo(n-1)+fibo(n-2))%1234567;
	    }
	}

}
