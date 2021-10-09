package level2;
//https://programmers.co.kr/learn/courses/30/lessons/42626
import java.util.PriorityQueue;

public class moreSpicy {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 4, 5};
		int K = 5;//K는 대문자
		int answer = 0;
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int x:scoville) q.offer(x);

		while(q.peek() < K) {
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
