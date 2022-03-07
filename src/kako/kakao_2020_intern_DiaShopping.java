package kako;
//https://programmers.co.kr/learn/courses/30/lessons/67258
//카카오 인턴 보석쇼핑 레벨3
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class kakao_2020_intern_DiaShopping {

	public static void main(String[] args) {
		/*System.out.println(Arrays.toString( new Solution().solution(
				new String[] {"ZZZ", "YYY", "NNNN", "YYY", "BBB"})));

		System.out.println(Arrays.toString( new Solution().slidingWindow(
				new String[] {"ZZZ", "YYY", "NNNN", "YYY", "BBB"})));*/
		System.out.println(Arrays.toString( new Solution().slidingWindow(
				new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"})));
		System.out.println(Arrays.toString( new Solution().slidingWindow(
				new String[] {"A", "A", "B"})));//[2,3]나와야됨 testcase6
		System.out.println(Arrays.toString( new Solution().slidingWindow(
				new String[] {"DIA", "EM", "EM", "RUB", "DIA"})));//[3,5]나와야됨 testcase7

	}
//시작이 1일때 보석모두 찾으면 스톱
//시작을 1늘려 2일때 보석 모두 찾으면 스톱...
	static class Solution {
		public static PriorityQueue<int[]> result;
	    public int[] solution(String[] gems) {
	        int[] answer = {};
	        HashMap<String, Boolean> reference = new HashMap<>();
	        for(String gem: gems) {
	        	reference.put(gem, false);
	        }
	        result = new PriorityQueue<>((int[] o1, int[] o2)->{
	        	if(o1[0]==o2[0]) {
	        		return o1[1]-o2[1];
	        	}
	        	return o1[0]-o2[0];
	        });//queue<int[] {거리, 시작인덱스}>

	        shortest(reference, 0, 0, gems);
	        int[] temp = result.peek();
	        return new int[] {temp[1]+1,temp[0]+temp[1]};
	    }

	    void shortest(HashMap<String, Boolean> map, int start, int end, String[] gems) {

	    	// 채점 결과 : 정확성50 효율성0
	    	if(start>=gems.length||end>=gems.length) {
	    		result.add(new int[] {end-start, start});
	    		return;
	    	}
	    	if(!map.containsValue(false)) {//다 트루면

	    		result.add(new int[] {end-start, start});

	    		for(String str:map.keySet()) map.put(str, false);
	    		shortest(map, start+1, start+1, gems);
	    		return;
	    	}

	    	map.put(gems[end], true);
	    	shortest(map, start, end+1, gems);

	    }

	    //슬라이딩 윈도우로 풀어보기
	    // map으로 보석 갯수 관리
	   public int[] slidingWindow(String[] gems) {
		   HashSet<String> set = new HashSet<>();
	        for(String gem: gems) {
	        	set.add(gem);
	        }

	    	HashMap<String, Integer> map = new HashMap<>();// dq내의 map = 보석이름, 보석개수

	    	int[] answer = new int[2];
	    	answer[0] = 0;
	    	answer[1] = gems.length;//최대길이구간으로 초기화
	    	int start =0;
	    	int end = 0;
	    	Deque<String> dq = new LinkedList<>();//쓸어담을구간 보석이름나열

	    	while(start<gems.length) {
	    		//map.containsValue(0)하지말고 -> dq안에 있는 보석갯수와 타입갯수를 비교하는 알고리즘으로 하기

	    		if(map.size()>=set.size()) {//보석이 다 찼을때
	    			if(answer[1]-answer[0] > end-start) {// 새로운게 더 작으면 갈아치우기
	    				answer[0]=start; answer[1]=end;
	    			}

	    			dq.removeFirst();
	    			if(map.get(gems[start])==1) {
	    				map.remove(gems[start]);
	    			}else {
	    				map.put(gems[start], map.get(gems[start])-1);
	    			}

	    			start++;

	    		}else {//보석이 모자를때
	    			if(end==gems.length) break;
	    			dq.add(gems[end]);

	    			if(map.containsKey(gems[end])) {
	    				map.put(gems[end], map.get(gems[end])+1);
	    			}else {
	    				map.put(gems[end], 1);
	    			}

	    			end++;
	    		}
	    	}
	    	answer[0]++;
	    	return answer;
	    }

	}

}
