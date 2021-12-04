package dev_matching_2021_fw;

import java.util.HashMap;
import java.util.StringTokenizer;
//못품
public class cookingTime {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.print(s.solution(2,new String[] {"A 3","B 2"},
				new String[] {"A 1","A 2","B 3","B 4"}));

	}

	static class Solution {
	    public int solution(int n, String[] recipes, String[] orders) {
	    	int answer = 0;
	        int[] using = new int[n];//분화구 마다 사용시간 업데이트
	        HashMap<String, Integer> map = new HashMap<>();
	        for(String r:recipes) {
	        	StringTokenizer st = new StringTokenizer(r, " ");
	        	map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
	        }

	        for(String order : orders) {
	        	String[] a = order.split(" ");
	        	int cookingTime = map.get(a[0]);
	        	int nth = Integer.parseInt(a[1]);

	        	int min = nth;

	        	int position=0;
	        	for(int i=0; i<n; i++) {
	        		if(nth <= using[i]) {//주문 들어온 시간 이후일때중 가장 작은 곳을 구해 요리하기
	        			if(min > using[i]) {
	        				min = Math.min(min, using[i]);
	        				position = i;
	        			}
	        		}
	        	}
	        	using[position] += cookingTime;
	        }
	        int max = 0;
	        for(int x : using) {
	        	max = Math.max(max, x);
	        }

	        return answer;
	    }
	}

}
