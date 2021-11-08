package kako;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/81302
//카카오 2021 채용연계형 인턴십
//거리두기 확인하기
public class kakao_2021_intern_social_distance {
	public static int[][] room;

	public static void main(String[] args) {
		String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}
		, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}
		, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}
		, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}
		, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};//5*5로 되어있는 대기실 5개가 주어진다.
		//사람: P, 빈테이블: O, 파이션: X
		//빈테이블 기준 사람과 사람 사이가 2이하면 안됨.
		for(int x : solution(places)) System.out.print(x+" ");
	}

	static public int[] solution(String[][] places) {
        int[] answer =new int[5];
        Arrays.fill(answer, 1);
        for(int T=0; T<5; T++) {

        	room = new int[5][5];
        	for(int i=0; i<5; i++) {
        		for(int j=0; j<5; j++) {
        			char c = places[T][i].charAt(j);
        			if(c=='P') {
        				process(i, j);
        			}
        			else if(c=='X') {
        				room[i][j] += 10;
        			}
        		}
        	}

        	//-2가 존재하는지 탐색
        	for(int i=0; i<5; i++) {
        		for(int j=0; j<5; j++) {
        			if(room[i][j]<=-2) {//-2이하를 발견하면 거리두기 실패
	        			answer[T] = 0;
        				break;
        			}
        		}
        		if(answer[T]==0) break;
        	}

        }
        return answer;
    }

	public static void process(int x, int y) {
		int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
		room[x][y] -= 1;
		for(int d=0; d<4; d++) {
			int nx = x + dir[d][0];
			int ny = y + dir[d][1];
			if(nx <0 || nx>=5 || ny<0 || ny>=5) continue;
			room[nx][ny] -= 1;
		}
	}
}
