package kako;
//https://programmers.co.kr/learn/courses/30/lessons/92335
//k진수에서 소수찾기
public class kakao_2022_prime_in_kNum {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(110011, 10));

	}
//자료형 잘 맞추기
	static class Solution {
	    public int solution(int n, int k) {
	        int answer=0;
	        StringBuilder sb = new StringBuilder();
	        while(n>=k) {
	        	sb.append(n%k);
	        	n = n/k;
	        }
	        sb.append(n);
	        String result = sb.reverse().toString();

	        String[] arr = result.split("0");
	        for(String s : arr) {
	        	if(!s.isEmpty() &&isPrime(Long.valueOf(s))) {
	        		answer+=1;
	        	}
	        }

	        return answer;
	    }

	    private boolean isPrime(long num) {
    		if(num==1) return false;
    		if(num==2) return true;//2는 소수

    		int max = (int)Math.sqrt(num);
    		for(int i=3; i<=max; i+=2) {
    			if(num%i==0) return false;
    		}

	    	return true;
	    }
	}

}
