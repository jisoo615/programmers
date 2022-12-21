package kako;

import java.util.ArrayList;

class kakao_2020_blind_WallCheck{
	public static ArrayList<int[]> list;
        public static void main(String[] args) {
//            System.out.println(new Solution().solution(
//                    12,
//                    new int[] {1, 5, 6, 10},
//                    new int[] {1, 2, 3, 4}
//            ));// 2
//            System.out.println(new Solution().solution(
//                    12,
//                    new int[] {1, 3, 4, 9, 10},
//                    new int[] {3, 5, 7}
//            ));// 1
            System.out.println(new Solution().solution(
                    200,
                    new int[] {1,100},
                    new int[] {1,1}
            ));// 2

        }
    /**
     * 최소의 친구를 섭외해야 함
     * 많은거리 갈수 있는 친구부터 배치
     */
    static class Solution {
    	static public int[] weak_append;
    	static public int answer;
        public int solution(int n, int[] weak, int[] dist) {
            /**
             * 반시계방향도 커버하는 확장배열 만들기 1,5,6,12, 13,17,18,22
             */
        	answer = Integer.MAX_VALUE;
            weak_append = new int[weak.length*2];
            int i=0;
            while (i<weak.length){
                weak_append[i] = weak[i];
                weak_append[i + weak.length] = weak[i++]+n;
            }

            // int 타입(primitive)은 comparator 못씀. Object 타입이여야 쓸 수 있음(double, int, char, flost)
            // int[][] 는 int[]끼리 비교하니까 그냥 할수있음
//            Integer[] tmp = Arrays.stream(dist).boxed().toArray(Integer[]::new);
//            Arrays.sort(tmp, Collections.reverseOrder());

            for(int k=0; k<weak.length; k++) {// 시작점 옮기기
            	dfs(k, 0, dist, new boolean[dist.length], new int[dist.length]);
            }

            if(answer==Integer.MAX_VALUE) return -1;

            return answer;
        }

        public void dfs(int start, int depth, int[] dist, boolean[] visited, int[] permuted) {
        	/**
        	 * dist의 순열
        	 */
        	if(depth==dist.length) {
        		answer = Math.min(answer, check(start, start+weak_append.length/2, permuted));
        		return;
        	}
        	for(int i=0; i<dist.length; i++) {
        		if(visited[i]) continue;

        		visited[i] = true;
        		permuted[depth] = dist[i];
        		dfs(start, depth+1, dist, visited, permuted);
        		visited[i] = false;
        	}


        }

        public int check(int start, int end, int[] permuted) {
//        	System.out.println(Arrays.toString(permuted));
        	// 해당 weak범위 에서, dist의 순열중 한 케이스
        	// 맽 첫 취약점 위치에 친구를 하나 추가해서 그 안에 취약점이 몇개 있는지 새고, 다음 시작을 또 새 취약점부터 시작하기
        	int friend = 0;// permuted의 index
        	int pos = weak_append[start++]+permuted[friend++];// 첫 취약점의 위치+친구거리 에서 시작
        	//1,5,6,12
        	while(start<=end) {
        		/*
        		 * TODO: 여기 인덱스 부분에서 계속 틀림 문제가 있음...
        		 */
        		if(pos >= weak_append[start]) {// 현위치 전에 취약점이 또 있으면
        			start++;
        		}else {// 더이상 그 안에 취약점 없으면, 다음지점+친구거리
        			if(friend==permuted.length)  return Integer.MAX_VALUE;
        			pos = weak_append[start]+permuted[friend++];
        		}

        	}

//        	System.out.println(friend-1);
        	return friend-1;
        }

    }
}