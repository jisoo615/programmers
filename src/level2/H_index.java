package level2;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42747
//H-index
public class H_index {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] citations = {3, 0, 6, 1, 5};
		System.out.print(s.solution(citations));

	}

	static class Solution {
	    public int solution(int[] citations) {
	    	Arrays.sort(citations);
	        int max = 0;
	        for(int i=0; i<citations[citations.length-1]; i++) {
	        	int cnt = 0;
	        	int h = i;
	        	for(int j=0; j<citations.length; j++) {
	        		if(citations[j] >= h) cnt++;
	        	}
	        	if(h <= cnt) {
	        		max = max < h ? h:max;
	        	}
	        }
	        return max;
	    }
	}

}
