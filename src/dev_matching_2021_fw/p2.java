package dev_matching_2021_fw;

import java.util.HashMap;
import java.util.PriorityQueue;

public class p2 {

	public static void main(String[] args) {
		int leave = 4;
		String day = "FRI";
		int[] holidays = {6, 21, 23, 27, 28};//공휴일
		System.out.print(solution(leave, day, holidays));
	}

	public static int solution(int leave, String day, int[] holidays) {
        int answer = -1;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("MON", 1); map.put("TUE", 2); map.put("WED", 3); map.put("THU", 4);
        map.put("FRI", 5); map.put("SAT", 6); map.put("SUN", 0);

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int h:holidays) {
        	q.add(h);
        }
        int sat = 7-map.get(day);
        while(sat<31) {
        	q.add(sat); q.add(sat+1);
        	sat += 7;
        }

        while(!q.isEmpty()) {
        	int now = q.poll();
        	int next = q.poll();
        	if(now+1 == next) {

        	}
        }

        return answer;
    }

}
