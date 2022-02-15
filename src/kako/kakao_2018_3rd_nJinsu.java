package kako;

public class kakao_2018_3rd_nJinsu {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(2,4,2,1));
		System.out.println(s.solution(16,16,2,1));

	}

	static class Solution {
	    public String solution(int n, int t, int m, int p) {
	    	// n:진수, t:출력할숫자갯수, m:게임인원, p:내순서
	        StringBuilder answer = new StringBuilder();

	        //필요한 개별 숫자개수 = m*t
	        int total = m*t-1;
	        int digit=1;
	        StringBuilder sb = new StringBuilder();
	        sb.append("0");
	        while(total>0) {
	        	String nJinsu = toNJinsu(n, digit);
	        	sb.append(nJinsu);
	        	total -= nJinsu.length();
	        	digit++;
	        }

	        for(int i=0; i<t; i++) {
	        	answer.append(sb.charAt((p-1)+(m*i)));
	        }

	        return answer.toString();
	    }

	    String toNJinsu(int n, int x) {
	    	String[] alpha = {"A", "B", "C", "D", "E", "F"};
	    	StringBuilder sb = new StringBuilder();

	    	while(x>0) {
	    		int remain = x%n;
	    		if(remain>=10) {
	    			sb.append(alpha[remain-10]);
	    		}else {
	    			sb.append(remain);
	    		}
	    		x /= n;
	    	}

	    	return sb.reverse().toString();
	    }
	}

}
