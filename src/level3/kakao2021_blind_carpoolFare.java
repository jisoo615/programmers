package level3;

public class kakao2021_blind_carpoolFare {
	static public int[][] arr;

	public static void main(String[] args) {
		int n=6, s=4, a=6, b=2;
		int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
		System.out.print(solution(n, s, a, b, fares));
	}

	static public int solution(int n, int s, int a, int b, int[][] fares) {
		s -= 1; a-=1; b-=1;
		arr = new int[n][n];
		for(int[] node : fares) {
			int x = node[0];
			int y = node[1];
			arr[x-1][y-1] = node[2];
			arr[y-1][x-1] = node[2];
		}
		int s_a = dijkstra(s, a, 0);
		int s_b = dijkstra(s, b, 0);
		int a_b = dijkstra(a, b, 0);
		return s_a+s_b+a_b;
	}

	static int dijkstra(int start, int end, int fare) {
		if(start==end) return fare;
		for(int i=0; i<arr.length; i++) {
			if(arr[start][i]!=0) dijkstra(i, end, fare+arr[start][i]);
		}

		return 0;
	}

}
