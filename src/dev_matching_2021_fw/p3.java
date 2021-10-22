package dev_matching_2021_fw;

import java.util.LinkedList;

public class p3 {

	public static void main(String[] args) {
		int[][] macaron = {{1,1},{2,1},{1,2},{3,3},{6,4},{3,1},{3,3},{3,3},{3,4},{2,1}};
		for(String str: solution(macaron)) {
			System.out.println(str);
		}

	}

	public static String[] solution(int[][] macaron) {
		String[] answer = new String[6];
		LinkedList<Integer>[] arr= new LinkedList[6];
		for(int i=0; i<6; i++) {
			arr[i] = new LinkedList<Integer>();
		}
		for(int[] q:macaron) {
			arr[q[0]].add(q[1]);
			game(arr);
		}

		return answer;
	}

	public static void game(LinkedList<Integer>[] arr) {

	}

}
