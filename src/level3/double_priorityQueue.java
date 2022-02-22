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
	        PriorityQueue<Integer> maxQ = new PriorityQueue<>();//최대큐에는 -를 붙여 넣어서 큰수가 젤앞에오게
	        PriorityQueue<Integer> minQ = new PriorityQueue<>();//최소큐에는 그냥 넣어서 최소가 젤앞에오게
	        for(String operation : operations) {
	        	String[] oper = operation.split(" ");
	        	int digit = Integer.parseInt(oper[1]);
	        	switch(oper[0]) {
	        	case "I":
	        		maxQ.add(digit*-1);
	        		minQ.add(digit);
	        		break;

	        	case "D":
	        		if(maxQ.isEmpty()&&minQ.isEmpty()) continue;
	        		if(digit==-1) {//최솟값 삭제
	        			maxQ.remove(minQ.poll()*-1);
	        		}else {//digit==1
	        			minQ.remove(maxQ.poll()*-1);//최댓값 삭제
	        		}
	        	}
	        }

	        if(maxQ.isEmpty()) return new int[] {0, 0};
	        answer[0]=maxQ.poll()*-1; answer[1]=minQ.poll();
	        return answer;//최대, 최솟값
	    }
	}

}
