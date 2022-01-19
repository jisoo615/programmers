/**
 *
 */
package kako;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 2022 kakao 사라지는 발판과 비슷한 문제임. 연습해보자
 *
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
		//승리인 경우 = 가로세로대각선이한줄 / 지는 경우 = 상대편이 가로세로대각선일때
		//--게임 끝까지 하다가 둘다 점수를 못얻으면 무승부
		int thisTurn = cnt%2==0 ? 1 : 2;
		int rest = 9-thisTurn;
		play(thisTurn);

	}

	private static int play(int thisTurn) {

		int min = 10;
		while(true) {
			for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(arr[i][j]>0) continue;
				arr[i][j] = thisTurn;
				if(won(new int[] {i,j})) {
					//지금 놓은 곳에서 이겼다면
				}
			}
			}
			break;
		}


		return 0;

	}

	static boolean won(int[] point) {

		int x = point[0]; int y = point[1];
		int team = arr[x][y];
		if(team==arr[x][0] && team==arr[x][1] && team==arr[x][2]) {
			//가로 같은 x에서 다른 y의 값이 같은지확인
			return true;
		}
		if(team==arr[0][y] && team==arr[1][y] && team==arr[2][y]) {
			//세로가 같은 y에서 다른 x의 값이 같은지확인
			return true;
		}
		//왼쪽위에서 오른족 아래로 대각선
		if(team==arr[0][0] && team==arr[1][1] && team==arr[2][2]) {
			return true;
		}
		//왼쪽아래에서 오른쪽 위로 대각선
		if(team==arr[2][0] && team==arr[1][1] && team==arr[0][2]) {
			return true;
		}

		return false;
	}



}
