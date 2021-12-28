package level2;

import java.util.LinkedList;
import java.util.Queue;

public class length_of_visiting {

	public static void main(String[] args) {
		Solution s = new Solution();
		String dirs = "ULURRDLLU";
		System.out.print(s.solution(dirs));

	}

	static class Solution {
		//지나간 '경로'를 확인해야됨
	    public int solution(String dirs) {
	        int answer = 0;
	        boolean[][][][] visited = new boolean[11][11][11][11];
	        //좌표x,y에서 좌표x2,y2로 가는 경로를 구현하기 위해 -> [x][y][x2][y2] 를 선언한다.
	        // 0->1 경로는 1->0 경로와 같기 떄문에 방향성을 없애줘야함 즉, visited[0][1] = visited[1][0] = true;

	        Queue<int[]> que = new LinkedList<>();
	        que.add(new int[] {5, 5});
	        char[] arr = dirs.toCharArray();
	        int idx =0;
	        while(true) {
	        	int[] p = que.poll();

	        	if(idx>=dirs.length()) break;

	        	int[] next = {p[0], p[1]};
	        	switch(arr[idx++]) {
	        	case 'U' : next[1] += 1; break;
	        	case 'D' : next[1] -= 1; break;
	        	case 'L' : next[0] -= 1; break;
	        	case 'R' : next[0] += 1; break;
	        	}

	        	if(next[0]<=10 && next[0]>=0 && next[1]<=10 && next[1]>=0) {//범위내에 있을때
	        		if(!visited[p[0]][p[1]][next[0]][next[1]]) {
	        		answer++;
	        		visited[p[0]][p[1]][next[0]][next[1]] = true;
	        		visited[next[0]][next[1]][p[0]][p[1]] = true;

	        		}
	        		que.add(next);//세로운 좌표 넣어줌
	        	}else {//범위 밖에 있으면 기존 좌표를 다시 넣어줌
	        		que.add(p);
	        	}

	        }
	        return answer;
	    }
	}

}
