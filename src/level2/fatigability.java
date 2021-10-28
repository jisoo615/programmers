package level2;

public class fatigability {
	static public int[][] matrix;
	static boolean[] visited;
	static int answer=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] dungeons = {{80,20},{50,40},{30,10}};
		int k = 80;//현재 피로도
		System.out.print(solution(k, dungeons));

	}

	static public int solution(int k, int[][] dungeons) {
		matrix = dungeons.clone();
		visited= new boolean[dungeons.length];
		for(int i=0; i<dungeons.length; i++) {
			if(dungeons[i][0]<=k) dfs(i, k, 1);
		}
		return answer;
	}

	static public void dfs(int current, int fatigue, int depth) {
		visited[current] = true;
		fatigue -= matrix[current][1];
		for(int i=0; i<visited.length; i++) {
			if(!visited[i] && matrix[i][0]<=fatigue) {
				dfs(i, fatigue, depth+1);
			}
		}
		visited[current] = false;
		answer = Math.max(depth, answer);
	}

}
