package level2;

import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/12973
//짝지어 제거하기
public class eliminate_pair {

	public static void main(String[] args) {
		String s = "baabaa";
		int answer = 0;//완전 제거할수 있으면 1 안되면 0
		Stack<Character> stack = new Stack<>();

		stack.push(s.charAt(0));
		for(int i=1; i<s.length(); i++) {
			if(!stack.isEmpty() && stack.peek()==s.charAt(i)) {
				stack.pop();
			}else {
				stack.push(s.charAt(i));
			}
		}

		if(stack.isEmpty()) {
			answer = 1;
		}else {
			answer = 0;
		}

		System.out.print(answer);

	}

}
