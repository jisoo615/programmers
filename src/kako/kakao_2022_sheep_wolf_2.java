package kako;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class kakao_2022_sheep_wolf_2 {

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(
				s.solution(new int[] {0,0,1,1,1,0,1,0,1,0,1,1},
				new int[][] {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}} )
				);

		System.out.println(
				s.solution(new int[] {0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0},
				new int[][] {{0, 1},{0, 2},{1, 3},{1, 4},{2, 5},{2, 6},{3, 7},{4, 8},{6, 9},{9, 10}} )
				);

	}

	static class Solution {
		private static int max = 0;
		private static HashMap<Integer, ArrayList<Integer>> map;
	    public int solution(int[] info, int[][] edges) {
	        map = new HashMap<>();
	        for(int[] edge:edges){
	        	if(!map.containsKey(edge[0])) map.put(edge[0], new ArrayList<Integer>());

	        	map.get(edge[0]).add(edge[1]);
	        }

	        List<Integer> list = new ArrayList<>(); list.add(0);// 시작은 0
	        dfs(0, info, list, 0, 0);

	        return max;
	    }

	    private void dfs(int index, int[] info, List<Integer> list, int sheep, int wolf) {//cnt[0]:양, cnt[1]:늑대
	    	// 왜 sheep과 wolf를 배열로 받으면 틀리고, int로 따로 받으면 정답이지?
	    	if(info[index]==0) {
	    		sheep++;;
	    	}else {wolf++;}
	    	if(sheep <= wolf) return;

	    	max = Math.max(max, sheep);//더많은 양

	    	List<Integer> next = new ArrayList<>();
	    	next.addAll(list);
	    	if(map.containsKey(index)) next.addAll(map.get(index));
	    	next.remove(Integer.valueOf(index));

	    	for(int x:next) {
	    		dfs(x, info, next, sheep, wolf);
	    	}
	    	return;
	    }
	}

}
