package level3;
//https://programmers.co.kr/learn/courses/30/lessons/42627
//디스크 컨트롤러

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class disk_controller {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		System.out.println(s.solution(jobs));

	}

	static class Solution {
		//오는 순서대로 인데, 작업시간이 빨리끝나는 순서대로
		//작업도중에 들어왔다면 작업시간이 적은 순대로 정렬되는 priorityqueue에 넣고 활용
	    public int solution(int[][] jobs) {
	    	int answer = 0;
	        Arrays.sort(jobs, (int[] j1, int[] j2)->{//도착한 순, 작업시간 작은순
	        	if(j1[0]==j2[0]) {
	        		return j1[1] - j2[1];
	        	}else {
	        		return j1[0] - j2[0];
	        	}
	        });
	        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
				@Override
				public int compare(int[] job1, int[] job2) {//작업시간 작은순
					return job1[1] - job2[1];
				}
			});

	        int i=0;//큐에 총 들어간 작업 개수
	        int time = 0;
	        while(i < jobs.length) {
	        	while(i < jobs.length && time >= jobs[i][0]) {//먼저 i가 배열길이보다 큰 상태에서 배열을 검사하면 범위오류가 일어남. 주의
	        		pq.add(jobs[i]);
	        		i++;
	        	}

	        	if(pq.isEmpty()) {
	        		time++;
	        	}else {
	        		int[] job = pq.poll();
	        		time += job[1];
	        		answer += (time-job[0]);
	        	}
	        }


	        while(!pq.isEmpty()) {//모든 작업이 들어간 후 소요시간 적은 것 다 처리하기
	        	int[] job = pq.poll();
	        	time += job[1];
	        	answer += (time - job[0]);
	        }


	        return answer/jobs.length;
	    }


	}

}

