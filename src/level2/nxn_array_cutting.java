package level2;
//https://programmers.co.kr/learn/courses/30/lessons/87390
//n^2 배열 자르기
public class nxn_array_cutting {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 3;
		int left = 2;
		int right = 5;
		for(int x : s.solution(n, left, right)) {
			System.out.print(x+" ");
		}

	}

	static class Solution {
	    public int[] solution(int n, long left, long right) {
	    	int difference = (int)(right-left)+1;
	        int[] answer = new int[difference];
	        int idx = 0;
	        while(left<=right) {
	        	int quotient = (int)Math.floor(left/n);
	        	int rest = (int)(left%n);

	        	int max = quotient > rest ? quotient : rest;
	        	answer[idx] = max+1;

	        	left+=1;
	        	idx++;
	        }


	        return answer;
	    }
	}

}
