package weekly_challenge;

import java.util.LinkedList;
//입실 퇴실
//https://programmers.co.kr/learn/courses/30/lessons/86048
public class enter_leave {

	public static void main(String[] args) {
		int[] enter = {1, 3, 2, 4, 6, 5, 8, 7, 9, 10};
			//{1, 10, 9, 2, 3, 8, 7, 4, 5, 6};
		int[] leave = {9, 5, 1, 10, 7, 4, 8, 6, 2, 3};
			//{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		//기댓값 8, 9, 9, 9, 8, 9, 9, 9, 8, 6
		//기댓값 9, 7, 7, 5, 5, 5, 3, 3, 1, 1
		int leaveIndex = 0;

		LinkedList<Integer> list = new LinkedList<>();
		int[][] graph = new int[enter.length][enter.length];

		for(int i=0; i<enter.length; i++) {
			list.add(enter[i]);

			while( !list.isEmpty() && list.contains(leave[leaveIndex])) {

				int leavingPerson = leave[leaveIndex];
				list.remove( list.indexOf(leavingPerson) );

				for(int j=0; j<list.size(); j++) {
					graph[ leavingPerson-1 ][ list.get(j)-1 ] = 1;
					graph[ list.get(j)-1 ][ leavingPerson-1 ] = 1;
				}

				leaveIndex++;
			}

		}

		int[] answer = new int[enter.length];
		for(int i=0; i<graph.length; i++) {
			int meet = 0;
			for(int j=0; j<graph.length; j++) {
				if(graph[i][j] != 0) {
					meet++;
				}
			}

			answer[i] = meet;
		}

		for(int x:answer)
		System.out.print(x+" ");

	}

}
