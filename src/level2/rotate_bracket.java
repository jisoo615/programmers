package level2;

import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/76502
//괄호 회전하기
public class rotate_bracket {

	public static void main(String[] args) {
		Solution s = new Solution();
		String str = "[](){}";
		System.out.print(s.solution(str));

	}

	static class Solution {
	    public int solution(String s) {//{} [] ()
	        int answer = 0;
	        for(int i=0; i<s.length(); i++) {
	        	s = s.substring(1) + s.substring(0, 1);
	        	if(isRight(s)) {
	        		answer++;
	        	}
	        }

	        return answer;
	    }

	    public boolean isRight(String str) {
	    	Stack<Character> stack = new Stack<>();
	    	for(char bracket : str.toCharArray()) {
	    		if(stack.isEmpty()) {
	    			stack.push(bracket);
	    		}else {
	    			char pre = stack.peek();
	    			switch(bracket) {
	    			case ')': if(pre=='(') stack.pop();
	    				break;
	    			case '}': if(pre=='{') stack.pop();
	    				break;
	    			case ']': if(pre=='[') stack.pop();
	    				break;
	    			default:
	    				stack.push(bracket);
	    				break;
	    			}
	    		}
	    	}
	    	return stack.isEmpty();
	    }
	}

}
