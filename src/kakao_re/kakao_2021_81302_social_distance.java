package kakao_re;
//https://programmers.co.kr/learn/courses/30/lessons/81302
//거리두기 확인하기
import java.util.Arrays;

public class kakao_2021_81302_social_distance {

	public static void main(String[] args) {
		System.out.println( Arrays.toString(
				new Solution()
				.solution(new String[][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
			{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
			{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
			{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
			{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})
				)
				);
		}

	}

	class Solution {
		int[] answer;

	    public int[] solution(String[][] places) {
	    	answer = new int[places.length];
	    	int T = 0;
	    	for(String[] place : places) {
	    		// o의 상하좌우에 p가 있으면 false -> 대각선에 있는 p도 거를수 있음
	    		// p의 상하좌우에 p가 있으면 false
	    		if(find(place)) {
	    			answer[T++] = 1;
	    		}else answer[T++] = 0;
	    	}
	    	return answer;
	    }

		private boolean find(String[] place) {

			for(int i=0; i<5; i++) {
				for(int j=0; j<5; j++) {
					if(place[i].charAt(j)=='P') {//p의 상하좌우에 p가 있으면 false
						if(!bfs(i, j, place, 'P')){//거짓일때
							return false;
						}
					}
					else if(place[i].charAt(j)=='O') {//O의 상하좌우에 p가 2개이상 있으면 false -> 대각선에 있는 p도 거를수 있음
						if(!bfs(i, j, place, 'O')) {
							return false;
						}
					}
				}
			}
			return true;
		}

		private boolean bfs(int y, int x, String[] place, char pORo) {
			int[] dx = {1, -1, 0, 0};//-> <- 위 아래 : 4분면 좌표처럼 봄
			int[] dy = {0, 0, 1, -1};

			int pcnt = 0;//case O

			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0 || ny<0 || nx>=5 || ny>=5) continue;//범위넘어가면 검사안함

				switch(pORo) {
				case 'P':
					if(place[ny].charAt(nx)=='P') return false;
					break;
				case 'O':
					if(place[ny].charAt(nx)=='P') pcnt++;
					if(pcnt>=2) return false;
					break;
				}

			}
			return true;
		}

}