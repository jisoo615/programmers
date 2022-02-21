package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//https://programmers.co.kr/learn/courses/30/lessons/43164
//여행경로
public class travel_route_ticket_dfs {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[][] tickets = {{"ICN", "SFO"},{"ICN", "ATL"},{"SFO", "ATL"},
				{"ATL", "ICN"},{"ATL","SFO"}};

		System.out.println(Arrays.toString(s.solution(tickets)));
}

	static class Solution {
		public static boolean[] visited;
		public static ArrayList<String> list;
	    public String[] solution(String[][] tickets) {
	    	list=new ArrayList<>();
	    	visited=new boolean[tickets.length];
	    	//항공권을 다 쓸수 있는 경우를 모두 찾고
	    	//루트들을 정렬해 맨 첫번째 루트를 반환
	    	dfs("ICN", tickets, 0, "ICN", 0);
	    	Collections.sort(list);
	    	String[] answer = list.get(0).split(" ");
	        return answer;
	    }
	    void dfs(String ticket, String[][] tickets, int cnt, String route, int last){
	    	if(cnt==tickets.length) {
	    		//맨처음 icn지우기
	    		route+=" "+tickets[last][1];
	    		list.add(route.substring(4));
	    	}

	    	for(int i=0; i<tickets.length; i++) {
	    		if(ticket.equals(tickets[i][0]) && visited[i]==false) {
	    			visited[i]=true;
	    			dfs(tickets[i][1],tickets, cnt+1, route+" "+tickets[i][0], i);
	    			visited[i]=false;
	    		}
	    	}
	}

}
}
