package kako;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * 2022 kakao 사라지는 발판과 비슷한 문제임. 연습해보자
 */
public class baekjoon_p16571 {
	public static int[][] arr;

	public static void main(String[] args) throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		arr = new int[3][3];
		int cnt=0;
		for(int i=0; i<3; i++) {
			String[] line;
			line = br.readLine().split(" ");
			for(int j=0; j<3; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
				cnt++;
			}
		}
		//입력-3*3빙고판 0: 빈칸, 1: x, 2: o  //출력-이기는 경우 "W", 무승부인 경우 "D", 지는 경우 "L"을 출력한다.
		//x가 선공일때 가로세로대각선 먼저 한줄 채우는 사람이 이기는 게임, 이번 차례인 플레이어의 최선의 결과를 내라
//최선의 결과 -> 승리면 끝내기, 무승부나 지면 끝까지 하기
		//지는 경우 = 상대편이 이길때
		//--게임 끝까지 하다가 둘다 점수를 못얻으면 무승부
		int starter = cnt%2==0 ? 1 : 2;
		int result = play(cnt, -10, starter);
		if(result==1) System.out.println('W');
		else if(result==0) System.out.println('D');
		else System.out.println('L');
	}

	private static int play(int cnt, int result, int starter) {
		int thisTurn = cnt%2==0 ? 1 : 2;//이번턴은 x : o 차례다

		while(true) {
			if(cnt==9) {
				return result;
			}

			for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(arr[i][j]>0) continue;
				arr[i][j] = thisTurn;
				cnt+=1;
				if( won(new int[] {i,j}) ) {
					if(starter==thisTurn) return 1;//starter가 이겼다면
					else{//상대가 이겼다면 -1, 다음턴도 보기
						result = Math.max(-1, result);
						play(cnt, result, starter);
						cnt-=1;
					}
				}else {//비겼으면
					result = Math.max(0, result);
					play(cnt, result, starter);
					cnt-=1;
				}
			}//이중 for문
			}
		}
	}

	static boolean won(int[] point) {
		int x = point[0]; int y = point[1];
		int team = arr[x][y];
		if(team==arr[x][0] && team==arr[x][1] && team==arr[x][2]) {
			return true;//가로
		}
		if(team==arr[0][y] && team==arr[1][y] && team==arr[2][y]) {
			return true;//세로
		}
		if(team==arr[0][0] && team==arr[1][1] && team==arr[2][2]) {
			return true;//하향대각선
		}
		if(team==arr[2][0] && team==arr[1][1] && team==arr[0][2]) {
			return true;//상향대각선
		}
		return false;//비기거나 진경우
	}
}
