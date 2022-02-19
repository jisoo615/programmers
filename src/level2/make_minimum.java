package level2;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/12941
//최솟값 만들기
public class make_minimum {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution(new int[] {1, 4, 2},
				new int[] {5, 4, 4}));

	}
	static class Solution{
	    public int solution(int []A, int []B){
	        int answer = 0;
	        Arrays.sort(A);
	        Arrays.sort(B);
	        for(int i=0; i<A.length; i++) {
	        	answer += A[i]*B[B.length-i-1];
	        }

	        return answer;
	    }
	}

}
