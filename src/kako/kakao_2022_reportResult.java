package kako;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

//https://programmers.co.kr/learn/courses/30/lessons/92334
//카카오 2022 신고결과받기
public class kakao_2022_reportResult {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report= {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		for(int x : s.solution(id_list, report, k)) System.out.println(x);

	}

	static class Solution {
	    public int[] solution(String[] id_list, String[] report, int k) {
	        ArrayList<ArrayList<String>> list = new ArrayList<>();
	        HashMap<String, Integer> indexMap = new HashMap<>();//id, 인덱스
	        HashMap<String, Integer> reported = new HashMap<>();//인덱스, 신고받은 수
	        for(int i=0; i<id_list.length; i++) {
	        	list.add(new ArrayList<String>());
	        	indexMap.put(id_list[i], i);
	        	reported.put(id_list[i], 0);
	        }
	        //신고를 k번 받은 사람을 구하고, 신고한 사람에게 자신이 신고한 사람중 몇명이 정지되엇는지 알려주기
	        for(String reporting : report) {
	        	String[] arr = reporting.split(" ");
	        	for(int i=1; i<arr.length; i++) {
	        		reported.put(arr[i], reported.get(arr[i])+1);
	        		list.get(indexMap.get(arr[0])).add(arr[i]);
	        	}
	        }
 	        HashSet<String> stopped = new HashSet<>();
 	        for(Entry<String, Integer> entry : reported.entrySet()) {
 	        	if(entry.getValue()>=k) stopped.add(entry.getKey());
 	        }
 	       int[] answer = new int[id_list.length];
 	       for(int i=0; i<list.size(); i++) {
 	    	   for(int j=0; j<list.get(i).size(); j++) {
 	    		   if(stopped.contains(list.get(i).get(j))) {
 	    			   answer[i] += 1;
 	    		   }
 	    	   }
 	       }

	        return answer;
	    }
	}

}
