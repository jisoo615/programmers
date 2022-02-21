package level3;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/42628
//이중 우선순위큐
public class double_priorityQueue {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] operations = {"I -45", "I 653", "D 1", "I -642",
				"I 45", "I 97", "D 1", "D -1", "I 333"};
		System.out.println(Arrays.toString(s.solution(operations)));

	}

	static class Solution {
	    public int[] solution(String[] operations) {
	        int[] answer = new int[2];
	        PriorityQueue<Integer> q = new PriorityQueue<>();
	        for(String oper : operations) {
	        	switch(oper.charAt(0)) {
	        	case 'I':
	        		q.add(Integer.parseInt(oper.substring(2)));break;
	        	case 'D':
	        		if(q.isEmpty()) continue;
	        		if(oper.charAt(2)=='-')q.poll();
	        		else q.remove(q.peek());
	        	}
	        }

	        if(q.isEmpty()) return new int[] {0, 0};
	        answer[1]=q.poll(); answer[0]=q.poll();
	        return answer;
	    }
	}

}
