package level3;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42861
//섬 연결하기
//kruskal, union_find
//간선 오름차순으로 두고 연결하는데, 최상위 노드가 같은 것(사이틀 없는)만 연결시켜줌
public class greedy_link_islands {

	public static void main(String[] args) {
		/*
		 * System.out.println(new Solution().solution(4,
				new int[][] {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}}));
		System.out.println(new Solution().solution(5,
				new int[][] {{0, 1, 1},{3, 4, 1},{1, 2, 2},{2, 3, 4}}));//8
				*/
		System.out.println(new Solution().solution(5,
				new int[][] {{0, 1, 5},{1, 2, 3},{2, 3, 3},{3, 1, 2},{3, 0, 4},{2, 4, 6},{4, 0, 7}}));//15

	}

	static class Solution {
	    public int solution(int n, int[][] costs) {
	        int answer = 0;
	        Arrays.sort(costs, (o1, o2)->{
	        	return o1[2] - o2[2];
	        });//거리 오름차순으로 간선 정렬

	        int[] union_find = new int[n];
	        for(int i=0; i<n; i++) {
	        	union_find[i] = i;
	        }

	        for(int[] cost : costs) {
	        	if(!findParent(union_find, cost[0], cost[1])) {//연결하기도 전에 부모가 같으면 사이클이므로, 연결하지 않음(연결전에 부모가 다르면 연결시켜줌)
	        		unionParent(union_find, cost[0], cost[1]);// 사이클 아닌 두 노드를 연결해줌
	        		answer += cost[2];
	        	}
	        }

	        return answer;
	    }

	    int getParent(int[] union_find, int node) {//이 노드의 부모를 찾아라
	    	if(union_find[node]==node) return node;//자기 자신을 가리키면 그건 루트(최상위 부모) 노드임
	    	return getParent(union_find, union_find[node]);
	    }

	    void unionParent(int[] union_find, int a, int b) {//간선을 선택했을떄 두 노드를 연결하자
	    	int aParent = getParent(union_find, a);
	    	int bParent = getParent(union_find, b);
	    	if(aParent < bParent) {
	    		union_find[bParent] = aParent;//더 작은 노드를 따라라
	    	}else {
	    		union_find[aParent] = bParent;
	    	}
	    }

	    boolean findParent(int[] union_find, int a, int b) {//부모가 같은지 확인하기
	    	int aParent = getParent(union_find, a);
	    	int bParent = getParent(union_find, b);
	    	if(aParent==bParent) return true;
	    	return false;
	    }

	}

}
