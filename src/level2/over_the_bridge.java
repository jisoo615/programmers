package level2;
//https://programmers.co.kr/learn/courses/30/lessons/42583
//다리를 지나는 트럭
import java.util.LinkedList;
import java.util.Queue;

public class over_the_bridge {

	public static void main(String[] args) {
		Solution s = new Solution();
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
		System.out.print(s.solution(bridge_length, weight, truck_weights));
	}

	static class Solution {
	    public int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 0;
	        Queue<Integer> q = new LinkedList<>();//다라위에 있는 무게들(트럭들)이 있는 큐

	        int sum = 0;
	        for(int i=0; i<truck_weights.length; i++) {
	        	while(true) {
	        		if(q.isEmpty()) {//다리위가 비어있다면 트럭추가
	        			q.offer(truck_weights[i]);
	        			sum += truck_weights[i];
	        			answer++;
	        			break; //브레이크 해서 다음 트럭이 지나갈지 말지 판단해야 되기때문

	        		}else if(q.size()==bridge_length) {//다리위가 꽉차면
	        			sum -= q.poll();
	        		}else {
	        			if(sum+truck_weights[i] <= weight) {
	        				q.offer(truck_weights[i]);
	        				sum += truck_weights[i];
	        				answer++;
	        				break; //브레이크 해서 다음 트럭이 지나갈지 말지 판단해야 되기 때문
	        			}else {//이번 트럭을 못올리면 0을 넣어줌
	        				q.offer(0);
	        				answer++;
	        			}
	        		}
	        	}
	        }
	        //다리 길이만큼 초를 더해줘야함
	        return answer+bridge_length;
	    }
	}

}
