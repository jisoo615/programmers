package level2;

import java.util.PriorityQueue;

public class moreSpicy {

	public static void main(String[] args) {
		int[] scoville = {7, 7, 7, 7};
		int k = 7;
		int answer = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int x:scoville) q.add(x);

		while(q.peek() < k) {
			if(q.size()==1) {
				answer = -1;
				break;
			}
			int mixedSpicy = q.poll() + q.poll()*2;
			answer += 1;
			q.offer(mixedSpicy);
		}


		System.out.print(answer);

	}
}
