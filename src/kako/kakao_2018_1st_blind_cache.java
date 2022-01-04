package kako;

import java.util.ArrayList;

//https://programmers.co.kr/learn/courses/30/lessons/17680
//캐시 최근사용된것을 이용함Least Recently used 캐시힛=1 캐시미스=5 임.
public class kakao_2018_1st_blind_cache {

	public static void main(String[] args) {
		Solution s = new Solution();
		int cacheSize = 0;
		String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.print(s.solution(cacheSize, cities));

	}

	static class Solution {
	    public int solution(int cacheSize, String[] cities) {
	        int answer = 0;

	        if(cacheSize==0) return cities.length*5;

	        ArrayList<String> list = new ArrayList<>();
	        for(String city : cities) {
	        	city = city.toLowerCase();
	        	int index = list.indexOf(city);
	        	if(index == -1) {
	        		if(list.size() < cacheSize) {//캐시가 아직 비었을때
	        			list.add(city);
	        		}else {//캐시가 찼을때
	        			list.remove(0);
	        			list.add(city);
	        		}
	        		answer += 5;
	        	}else {//캐시에 있을때
	        		list.remove(index);
	        		list.add(city);
	        		answer += 1;
	        	}
	        }

	        return answer;
	    }
	}

}
