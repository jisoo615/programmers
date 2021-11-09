package kako;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//https://programmers.co.kr/learn/courses/30/lessons/81304
//미로탈출 level 5
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
		Map<Integer, Boolean> state;//함정상태
		Location(int no, int distance, Map<Integer, Boolean> state){
			this.no = no;
			this.distance = distance;
			this.state = state;
		}
	}

	static public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        Map<Integer, Boolean> state = new HashMap<>();//함정상태
		Map<Integer, List<int[]>> graph = new HashMap<>();

		for(int t : traps) state.put(t, false);//함정들 false로 초기화해 넣어둠
		for(int[] r :roads) {
			addLink(graph, r[0], r);
			addLink(graph, r[1], r);//함정 발동되면 반대 방향으로 가야하기 때문에 r[1]->r[0]방향도 넣어줌
		}

    	int[] visited = new int[n+1];//boolean의 방문여부가 아니라 방문횟수 체트해야됨->int
    	PriorityQueue<Location> queue = new PriorityQueue<>((a, b)->{
    		return a.distance - b.distance;
    	});

    	queue.add(new Location(start, 0, state));//시작점 등록
    	while(!queue.isEmpty()) {
    		Location p = queue.poll();
    		if(p.no==end) return p.distance;//도착점에 도달했으면 총 거리반환
    		if(visited[p.no]>2) continue;//3번째방문은 1번째 방문한것과 같음으로 최대 2번까지만 방문해야 한다.
    		visited[p.no] += 1;//방문+1해주기

    		state = p.state;//현재노드일때 상태
    		if(state.get(p.no) != null) {//현재 노드가 함정노드일때
    			Map<Integer, Boolean> new_state = new HashMap<>();//새로운 상태 생성해놓고
    			new_state.putAll(state);
    			state = new_state;//새로운상태와 현재상태를 같게 한 후,
    			state.put(p.no, !state.get(p.no));//방문한 함정상태를 변경해 준다.
    		}

    		for(int[] rr :graph.get(p.no)) {//rr:{출발, 도착, 거리}, ...
    			boolean state1 = state.get(rr[0])==null ? false:state.get(rr[0]);
    			//이 링크의 출발 노드가 함정이 아니거나 홀수번 방문하면 false, 함정이고 짝수번 방문하면 true됨
    			boolean state2 = state.get(rr[1])==null ? false:state.get(rr[1]);
    			//이 링크의 도착 노드가 함정이 아니거나 홀수번 방문하면 false, 함정이고 짝수번 방문하면 true됨
    			//방문 0번: false	 |  1번: true  |  2번 false

    			// 상태1, 상태2 값이 false, false 이거나 true, true 이면 이 링크의 방향은 처음과 같다.
    			// false, true 이거나 true, false 이면 이 링크의 방향은 뒤집어졌다.
    			int from=0, to=1;
    			if(state1 != state2) {//false, true 이거나 true, false 이면
    				from=1; to=0;//링크 방향 반대로
    			}
    			if(rr[from]==p.no) {//현재 노드 도착지와 같은 rr링크가 있으면 큐에 넣어줌
    				queue.add(new Location(rr[to], p.distance + rr[2], state));
    			}
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
