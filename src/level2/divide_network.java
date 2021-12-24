package level2;

import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/86971
//전력망을 둘로 나누기
public class divide_network {

	public static void main(String[] args) {

		Solution s = new Solution();
		int n = 9;
		int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		System.out.print(s.solution(n, wires));

	}

	static class Solution {
		//간선을 하나씩 끊어보며 차이가 가장 적게 날때의 차를 반환한다.
		public static int[][] graph;

	    public int solution(int n, int[][] wires) {
	        int min =n;
	        graph = new int[n+1][n+1];
	        for(int[] wire : wires) {
	        	graph[wire[0]][wire[1]] = graph[wire[1]][wire[0]] = 1;
	        }

	        for(int[] wire : wires) {
	        	//맨 처음부터 마지막까지 하나의 간선만 제외하기
	        	graph[wire[0]][wire[1]] = graph[wire[1]][wire[0]] = 0;
	        	int differ = Math.abs(dfs(wire[0]) - dfs(wire[1]));
	        	min = Math.min(min, differ);
	        	graph[wire[0]][wire[1]] = graph[wire[1]][wire[0]] = 1;//원상태로 돌려놓기
	        }

	        return min;
	    }

	    public int dfs(int start) {
	    	//두로 나눠진 각 그래프의 노드를 구하고 차를 반환하라
	    	Queue<Integer> que = new LinkedList<>();
	    	boolean[] visited = new boolean[graph.length];

	    	que.add(start);
	    	visited[start] = true;
	    	while(!que.isEmpty()) {
	    		int node = que.poll();
	    		for(int i=1; i<graph.length; i++) {
	    			if(graph[node][i]>0 && visited[i]==false) {
	    				visited[i] = true;
	    				que.add(i);
	    			}
	    		}
	    	}

	    	int cnt=0;
	    	for(int i=1; i<visited.length; i++) {
	    		if(visited[i]) cnt++;
	    	}

	    	return cnt;
	}
	}

}
