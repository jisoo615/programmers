package kako;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

//https://programmers.co.kr/learn/courses/30/lessons/17684
//압축
public class kakao_2018_3rd_zip {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.solution("KAKAO")));
		// TOBEORNOTTOBEORTOBEORNOT 24글자

	}

	static class Solution {
		static ArrayList<Integer> list;
        static TreeMap<String, Integer> map;

	    public int[] solution(String msg) {
	    	list = new ArrayList<Integer>();
	    	map = new TreeMap<>();

	        for(int i=0; i<26; i++) {
	        	map.put( Character.toString('A'+i), i+1);
	        }
	        int T=0;
	        while(T < msg.length()) {
	        	T = zip(msg, T);
	        }

	        int[] answer = new int[list.size()];
	        for(int i=0; i<list.size(); i++) {
	        	answer[i] = list.get(i);
	        }

	        return answer;
	    }

	    int zip(String msg, int start) {

	    	int i= start;
        	for(int j=start+1; j<msg.length()+1; j++) {
        		if( map.containsKey(msg.substring(i, j)) ) continue;
        		else {
        			list.add(map.get(msg.substring(i, j-1)));
        			map.put(msg.substring(i, j), map.size()+1);
        			return j-1;
        		}
        	}

        	list.add(map.get(msg.substring(start)));
			return msg.length();
	    }

	}

}
