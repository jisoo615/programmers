package level2;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/12978
//배달
public class delivery {

	public static void main(String[] args) {
		Solution s = new Solution();
		int N = 6;
		int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int K=4;
		System.out.print(s.solution(N, road, K));

	}

	static class Solution {
	    public int solution(int N, int[][] road, int K) {
	    	//1번 마을에 있는 음식점이 K 이하의 시간에 배달이 가능한 마을의 개수를 return
	        int answer = 0;
	        int[][] town = new int[N+1][N+1];

	        for(int i=0; i<=N; i++) {
	        	Arrays.fill(town[i], 500002);;
	        	town[i][i] = 0;//같은 노드의 거리는 0임 1-1거리는 0
	        }

	        for(int[] r : road) {
	    		//원래있던 것보다 더 빠른 길로 교체한다.
	        	int weight = Math.min(r[2], town[r[0]][r[1]]);
    			town[r[0]][r[1]] = weight;
    			town[r[1]][r[0]] = weight;
	        }
	        //1에서 각 노드까지 걸리는 시간을 구한 후 k이하의 시간이 걸리는 노드개수를 반환하자
	        //풀로이드 워셜 - a-b-c 가 있을때 a-c거라는 a-b + b-c 거리다.
	        for(int k=1; k<=N; k++) {//k가 먼저 있어야 틀리지 않음. k를 하나씩 늘려가며 최단거리를 구해야함
		        for(int i=1; i<=N; i++) {
		        	for(int j=1; j<=N; j++) {
	        			town[i][j] = Math.min(town[i][j], town[i][k]+town[k][j]);
	        		}
	        	}
	        }

	        for(int i=1; i<=N; i++) {
        		if(town[1][i]<=K) answer+=1;
	        }

	        return answer;
	    }
	}

}
