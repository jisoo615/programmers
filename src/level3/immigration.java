package level3;

//https://programmers.co.kr/learn/courses/30/lessons/43238
//입국심사
public class immigration {

	public static void main(String[] args) {
		int n = 6;
		int[] times = {7, 10};//return 28
		System.out.print(new Solution().solution(n, times));

	}

	static class Solution{
		public long solution(int n, int[] times) {
	        int biggest = times[0];
	        for(int time:times) {
	        	biggest = biggest < time ? time:biggest;
	        }
	        long max = (long)biggest*n;//최대로 걸리는 시간
	        long start = 0; long end = max; long mid = 0;
	        while(start < end) {//lower bound를 찾아야됨 (찾고자하는 숫자가 처음 나오는 지점)
	        					//반대로 upper bound는 찾고자하는 숫자보다 큰 숫자가 처음으로 나오는 지점
	        	mid = (long) Math.floor((start+end)/2);

	        	long people = peopleToTime(mid, times);

	        	if(people >= n) {//작아져야됨
	        		end = mid;
	        	}
	        	else if(people < n) {//커져야됨
	        		start = mid+1;
	        	}
	        }

	        return end;
	    }
		public long peopleToTime(long timeLimit, int[] times ) {//long 타입으로 반환해야됨.
			 //제한된 시간동안 심사할수있는 총 인원을 구하는 메소드
			int sum = 0;
			for(int time : times) {
				sum += timeLimit/time;
			}
			return sum;
		}
	}

}
