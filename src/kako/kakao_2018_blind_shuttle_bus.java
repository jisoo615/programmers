package kako;

import java.util.ArrayList;
import java.util.Arrays;

public class kakao_2018_blind_shuttle_bus {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(2,10,2,new String[] {"09:10", "09:09", "08:00"}));//09:09


	}

	static class Solution {
	    public String solution(int n, int t, int m, String[] timetable) {//9시부터 최대m명 수용 t간격으로 n회 오는 버스
	        String answer = "";

	        Arrays.sort(timetable);

	        //n이 1일때 무조건 타야함
	        //자리 남았으면 버스 도착시간에 가도 됨
	        //자리 없으면 마지막 사람 전에 가야 함
	        int time = 9*60;// 첫 버스 도착 시간 9:00
	        ArrayList<Integer> list = new ArrayList<>();
	        int index = 0;
	        while(n>0) {
	        	list.removeAll(list);
	        	for(int i=index; i<timetable.length; i++) {
	        		int crewTime = Integer.parseInt(timetable[i].substring(0,2))*60
	        				+ Integer.parseInt(timetable[i].substring(3,5));
	        		if(crewTime<=time) {
	        			list.add(crewTime);
	        			index = i+1;
	        			if(list.size()==m) {
	        				break;
	        			}
	        		}else {//버스시작 시간 보다 이후면 이 for문 나가기
	        			break;
	        		}
	        	}

	        	if(n==1) {//콘은 마지막일때만 탐
	        		if(list.size()<m) {//자리가 남았으면 맨 버스 도착시간에
	        			return toHHmm(time);
	        		}
	        		else {//자리가 없을때, 맨 마지막 보다 하나 작은거 선택
	        			return toHHmm(list.get(m-1)-1);
	        		}
	        	}

	        	time += t;
	        	n--;
	        }

	        return answer;
	    }

	    String toHHmm(int n) {
	    	StringBuilder sb = new StringBuilder();
	    	int h = n/60;
	    	int m = n%60;
	    	sb.append(h<10 ? "0":"").append(h).append(":").append(m<10 ? "0":"").append(m);
	    	return sb.toString();
	    }
	}



}
