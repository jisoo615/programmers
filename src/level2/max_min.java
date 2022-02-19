package level2;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/12939
//최댓값과 최댓값
public class max_min {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("-1 -2 -3 -4"));

	}

	static class Solution {
	    public String solution(String s) {
	        String answer = "";
	        String[] arr = s.split(" ");
	        int[] arr_int = new int[arr.length];
	        for(int i=0; i<arr_int.length; i++) {
	        	arr_int[i] = Integer.parseInt(arr[i]);
	        }
	        Arrays.sort(arr_int);
	        answer = arr_int[0]+" "+arr_int[arr_int.length-1];
	        return answer;
	    }
	}

}
