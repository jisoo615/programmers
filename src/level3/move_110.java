package level3;

import java.util.Arrays;
import java.util.Stack;

//https://programmers.co.kr/learn/courses/30/lessons/77886
//110 옮기기
// stack 지대로 이용한 문제 ***
public class move_110 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(
				new Solution().solution(new String[] {"1110","100111100","0111111010"}))
				);

	}

	static class Solution {
	    public String[] solution(String[] s) {
	    	Stack<Character> stack = new Stack<>();
	    	String[] answer = new String[s.length];
	    	int idx = 0;
	    	for(String str : s) {
	    		int cnt_110 = 0;

	    		for(char c : str.toCharArray()) {// 이렇게 stack으로 쌓아가며 알아보면 미리 110의 갯수를 구할수도 있음
	    			stack.push(c);

	    			if(stack.size()<3) continue;
	    			// 110 -> stack에서 꺼낸순서 011
	    			char first = stack.pop();
	    			char second = stack.pop();
	    			char third = stack.pop();

	    			if(first!='0' || second!='1' || third!='1' ) {
	    				stack.push(third);// 다시 넣을땐 반대로 넣어줘야 원상태
	    				stack.push(second);
	    				stack.push(first);
	    				continue;
	    			}
	    			cnt_110++;
	    		}
	    		// stack에 있는 남은부분과 110 붙이기
	    		StringBuilder sb = new StringBuilder();
	    		while(!stack.isEmpty()) {
	    			if(stack.peek()=='1') {
	    				sb.insert(0, stack.pop());
	    			}
	    			else if(stack.peek()=='0' && cnt_110>0) {
    					sb.insert(0, "110");
    					cnt_110--;

	    			}else {// 110 갯수 없는 0일때
	    				sb.insert(0, stack.pop());
	    			}
	    		}

	    		while(cnt_110>0) {// 110을 넣을데가 없었다면 맨 앞에 붙여줌
	    			sb.insert(0, "110");
	    			cnt_110--;
	    		}

	    		answer[idx++] = sb.toString();
	    	}
	    	return answer;
	}
	}

}
