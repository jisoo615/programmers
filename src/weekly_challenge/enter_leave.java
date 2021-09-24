package weekly_challenge;

import java.util.HashSet;
//https://programmers.co.kr/learn/courses/30/lessons/86048
public class enter_leave {

	public static void main(String[] args) {
		int[] enter = {1, 3, 2, 4, 6, 5, 8, 7, 9, 10};
			//{1, 10, 9, 2, 3, 8, 7, 4, 5, 6};
		int[] leave = {9, 5, 1, 10, 7, 4, 8, 6, 2, 3};
			//{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		//기댓값 8, 9, 9, 9, 8, 9, 9, 9, 8, 6
		//기댓값 9, 7, 7, 5, 5, 5, 3, 3, 1, 1

		int[] meet = new int[enter.length];
		int leaveTH = 0;
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<enter.length; i++) {
			set.add(enter[i]);

			if(set.contains( leave[leaveTH])) {
				for(int inner : set) meet[ inner-1 ] = Math.max( meet[inner-1], (set.size()-1));
			}

			while(set.contains( leave[leaveTH] )) {
				set.remove( leave[leaveTH] );
				leaveTH += 1;//더이상 회의실에 없는 사람이 나올때까지
				if(leaveTH >= leave.length) break;
			}
		}


		for(int cnt : meet)
		System.out.print(cnt+" ");

	}

}
