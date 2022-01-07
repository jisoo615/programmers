package level2;
//https://programmers.co.kr/learn/courses/30/lessons/12909
//올바른 괄호
public class right_bracket {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "(())()";
		System.out.print(sol.solution(s));

	}

	static class Solution {
	    boolean solution(String s) {
	    	//stack대신 left right 의 카운트를 세서 대신한다.
	    	int left = 0;
	        for(char c : s.toCharArray()) {
	        	if(c=='(') left++;
	        	else {//c==')'
	        		left--;
	        		if(left<0) return false;
	        	}
	        }
	        if(left==0) return true;
	        else return false;
	    }
	}

}
