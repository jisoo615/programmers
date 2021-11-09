package kako;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/81304
//미로탈출 level 5
//일단 함정 생각하지 않고 다익스트라로 풀어보기
public class kakao_2021_intern_exitMaze {

	public static void main(String[] args) {
		//노드 1부터 시작
		int n=4, start=1, end=4;
		int[][] roads= {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
		int[] traps = {2,3};
		System.out.print(solution(n, start, end, roads, traps));

	}

	static class Location{
		int no, distance;
		Location(int no, int distance){
			this.no = no;
			this.distance = distance;
		}
	}

	static public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int[] r :roads) addLink(graph, r[0], r);

    	boolean[] visited = new boolean[n+1];
    	PriorityQueue<Location> queue = new PriorityQueue<>((a, b)->{
    		return a.distance - b.distance;
    	});

    	queue.add(new Location(start, 0));//시작점 등록
    	while(!queue.isEmpty()) {
    		Location p = queue.poll();
    		if(p.no==end) return p.distance;//도착점에 도달했으면 총 거리반환
    		if(visited[p.no]) continue;//방문했던 곳이면 넘어가라
    		visited[p.no] = true;//방문안했으면 방문체크해줌

    		List<int[]> links = graph.get(p.no);
    		if(links==null) continue;
    		for(int[] rr :links) {
    			queue.add(new Location(rr[1], p.distance + rr[2]));
    		}
    	}

        return -1;
    }

	static void addLink(Map<Integer, List<int[]>> map, int no, int[] r) {
		List<int[]> links = map.get(no);
		if(links==null) {
			map.put(no, links = new ArrayList<>());
		}
		links.add(r);
	}

}
