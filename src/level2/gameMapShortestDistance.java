package level2;

import java.util.LinkedList;
import java.util.Queue;

//https://programmers.co.kr/learn/courses/30/lessons/1844
//게임 맵 푀단거리
//이번엔 통과된 이유 : 배열을 인큐디큐했다. x값과 y값을 따로 인큐디큐하면 시간이 두배로 걸리기 때문
public class gameMapShortestDistance {

	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.print(solution(maps));
	}

	static public int solution(int[][] maps) {
		Queue<int[]> que = new LinkedList<>();
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int x_max = maps.length-1;
        int y_max = maps[0].length-1;
        int nowX, nowY, nextX, nextY;
        boolean visited[][] = new boolean[x_max+1][y_max+1];
        que.offer(new int[] {0, 0});
        visited[0][0] = true;

        while(!que.isEmpty()){
        	int[] now = que.poll();
        	nowX = now[0]; nowY = now[1];
            System.out.print("("+nowX+", "+nowY+")"+" ");

            for(int i=0; i<4; i++){
                nextX = nowX+direction[i][0];
                nextY = nowY+direction[i][1];

                if(nextX <0 || nextX>x_max || nextY<0 || nextY>y_max) continue;
                if(maps[nextX][nextY]==0) continue;
                if(!visited[nextX][nextY]){
                    que.offer(new int[] {nextX, nextY});
                    maps[nextX][nextY] = maps[nowX][nowY] + 1;
                    visited[nextX][nextY] = true;
                    }
            }

            if(maps[x_max][y_max]>1) return maps[x_max][y_max];
        }

        return -1;
    }

}
