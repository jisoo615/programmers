package level3;
//https://programmers.co.kr/learn/courses/30/lessons/49189
//가장 먼 노드
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class farest_node {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n=6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.print(s.solution(n, edge));
		System.out.print(s.sb.toString());
	}

	static class Solution {
		static Queue<Integer> que;
		static ArrayList<ArrayList<Integer>> list;
		static boolean[] visited;
		StringBuilder sb = new StringBuilder();

	    public int solution(int n, int[][] edge) {
	    	int answer=0;
	    	que = new LinkedList<>();
	    	list = new ArrayList<>();
	    	for(int i=0; i<=n; i++) {
	    		list.add(new ArrayList<>());
	    	}
	    	for(int[] e : edge) {
	    		int node1 = e[0];
	    		int node2 = e[1];
	    		list.get(node1).add(node2);
	    		list.get(node2).add(node1);
	    	}
	    	for(int i=1; i<=n; i++) {
	    		Collections.sort(list.get(i));
	    	}

	    	visited = new boolean[n+1];
	    	answer = bfs();

	     return answer;
	}

	    int bfs() {
	    	//맨 마지막까지 1과 이어져 있는 노드들이 가장 먼 노드기 때문에 마지막 연결된 노드들의 크기인
	    	//que.size를 answer로 반환하면 답이 딘다.
	    	que.offer(1);
	    	visited[1] = true;
	    	int que_size = 0;

	    	while(!que.isEmpty()) {
	    		que_size = que.size();
	    		for(int q=0; q<que_size; q++) {
	    			int key = que.poll();
	    			ArrayList<Integer> temp = list.get(key);

	    			for(int i=0; i<temp.size(); i++) {
	    				if(!visited[temp.get(i)]) {
	    					que.add(temp.get(i));
	    					visited[temp.get(i)] = true;
	    				}
	    			}
	    		}
	    	}

	    	return que_size;
	}
}
}
