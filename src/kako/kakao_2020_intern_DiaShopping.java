package kako;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class kakao_2020_intern_DiaShopping {

	public static void main(String[] args) {
		System.out.println(Arrays.toString( new Solution().solution(
				new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA",
						"EMERALD", "SAPPHIRE", "DIA"})));

	}

	static class Solution {
		public static PriorityQueue<int[]> result;
	    public int[] solution(String[] gems) {
	        int[] answer = {};
	        HashMap<String, Boolean> map = new HashMap<>();
	        for(String gem: gems) {
	        	map.put(gem, false);
	        }
	        result = new PriorityQueue<>((int[] o1, int[] o2)->{
	        	if(o1[0]==o2[0]) {
	        		return o1[1]-o2[1];
	        	}
	        	return o1[0]-o2[0];
	        });//queue<int[] {거리, 시작인덱스}>

	        shortest(map, 0, 0, gems);

	        return answer;
	    }

	    void shortest(HashMap<String, Boolean> map, int start, int end, String[] gems) {
	    	if(start>=gems.length||end>=gems.length) return;
	    	if(!map.containsValue(false)) {//다 트루면

	    		result.add(new int[] {end-start-1, start});
	    		return;
	    	}

	    	map.put(gems[end], true);
	    	shortest(map, start, end+1, gems);
	    	map.put(gems[end], false);
	    	shortest(map, start+1, end+1, gems);

	    }
	}

}
