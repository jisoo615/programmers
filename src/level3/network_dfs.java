package level3;
//https://programmers.co.kr/learn/courses/30/lessons/43162
//네트워크 -쉬운 dfs
public class network_dfs {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] computers = {{1, 1, 0},{1, 1, 0},{0, 0, 11}};
		System.out.println(s.solution(3, computers));
	}

	static class Solution {
		boolean[] visited;
	    public int solution(int n, int[][] computers) {
	        int answer = 0;

	        visited = new boolean[n];
	        for(int i=0; i<n; i++) {
	        	if(visited[i]==true) continue;
	        	else {
	        		answer++;
	        		dfs(visited, i, computers);
	        	}
	        }


	        return answer;
	    }

	    void dfs(boolean[] visited, int start, int[][] computers) {
	    	for(int i=0; i<visited.length; i++) {
	    		if(visited[i]==true) continue;
	    		if(computers[start][i]==1) {
	    			visited[i]=true;
	    			dfs(visited, i, computers);
	    		}
	    	}
	    }
	}

}
