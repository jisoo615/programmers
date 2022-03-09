package level3;
//https://programmers.co.kr/learn/courses/30/lessons/76503
//모두 0으로 만들기
import java.util.ArrayList;

public class MakeAllZero_graph_dfs {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] {-5,0,2,1,2},
				new int[][] {{0,1},{3,4},{2,3},{0,3}}));

	}

	static class Solution {
		boolean[] visited;
	    long[] data;
	    ArrayList<Integer>[] children;
	    long answer=0;
//자식 가중치를 부모로 옮기기 반복
	    public long solution(int[] a, int[][] edges) {
	        int sum = 0;
	        this.data = new long[a.length];
	        this.children = new ArrayList[a.length];
	        this.visited = new boolean[a.length];

	        for(int i=0; i<a.length; i++){
	            sum += a[i];
	            this.data[i] = a[i];
	            this.children[i] = new ArrayList<>();
	        }
	        if(sum!=0) return -1;//합이 0이 아니면 -1 반환
	    //합이 0이 될때
	        for(int[] edge : edges){
	            children[edge[0]].add(edge[1]);
	            children[edge[1]].add(edge[0]);
	        }

	        dfs(0);//루트 0 부터 시작 깊이우선탐색

	        return this.answer;
	    }

	    long dfs(int node){
	    	visited[node] = true;

	    	for(int i=0; i<this.children[node].size(); i++) {
	    		int next = this.children[node].get(i);
	    		if(visited[next]) continue;

	    		this.data[node] += dfs(next);
	    	}

	    	this.answer += Math.abs(this.data[node]);

	    	return this.data[node];
	}
	}

}
