package level3;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/72413
//합승 택시 요금
public class kakao2021_blind_carpoolFare {

	public static void main(String[] args) {
		int n=6, s=4, a=6, b=2;//정점개수, 출발지, 무지도착지, 어피치도착지
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		System.out.print(solution(n, s, a, b, fares));
	}

	static public int solution(int n, int s, int a, int b, int[][] fares) {
		s -= 1; a-=1; b-=1;
		int[][] arr = new int[n][n];
		for(int i=0; i<n; i++) {
			Arrays.fill(arr[i], 100000001);
		}
		//정점연결 안되어있는 부분은 모두 제일 큰값을 가지고 있어야됨. 더 작은 값이 뭔지 구할것이기 때문에 0이 되도록 두면 안됨
		//Integer.MAX_VALUE로 값을 줘버리면 나중에 연산중에 음수로 바뀔수 있으니(자료형크기때문에) 적당히 큰 100000001로 지정해준다.

		for(int[] node : fares) {
			int x = node[0];
			int y = node[1];
			arr[x-1][y-1] = node[2];
			arr[y-1][x-1] = node[2];
		}

		//플루이드 워셜 알고리즘
		for(int k=0; k<n; k++) {//경우지
			//u에서 v로 가는데 k를 거치느냐 마느냐, 더 적은 비용이 무엇인지 계산
			arr[k][k] = 0;
			for(int u=0; u<n; u++) {//출발지
				for(int v=0; v<n; v++) {//도착지

					if(u==v) continue;

					if(arr[u][k]+arr[k][v] < arr[u][v]) {//경우지 거치는게 더 작다면 갱신
						arr[u][v] = arr[u][k]+arr[k][v];
					}
				}
			}
		}
		int answer = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {//모든 정점을 비교하여 최소비용을 구함
			int temp = arr[s][i] + arr[i][a] + arr[i][b];
			answer = Math.min(answer, temp);
		}

		return answer;
	}

}
