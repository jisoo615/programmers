package level2;
//https://programmers.co.kr/learn/courses/30/lessons/77485
//행렬 테두리 회전하기
public class square_rotate {

	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};

		for(int x:solution(rows, columns, queries)) {
			System.out.print(x+" ");
		}

	}

	public static int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] matrix = new int[rows][columns];
		int n = 1;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				matrix[i][j] = n;
				n++;
			}
		}

		int last=0;
		int min = Integer.MAX_VALUE;
		for(int[] query : queries) {
			int x1 = query[0]; int y1 = query[1]; int x2 = query[2]; int y2 = query[3];
			//근데 이 방식도 아닌것 같음 다시 풀기
			int temp1 = lastValue(x1, y1, x1, y2, matrix);
			int temp2 = lastValue(x1, y2, x2, y2, matrix);
			matrix[x1][y2] = temp1;
			int temp3 = lastValue(x2, y2, x2, y1, matrix);
			matrix[x2][y2] = temp2;
			int temp4 = lastValue(x2, y1, x1, y1, matrix);
			matrix[x2][y1] = temp3;
			matrix[x1][y1] = temp4;

		}

		return answer;
	}

	public static int lastValue(int x1, int y1, int x2, int y2, int[][] matrix) {
		int last = 0;

		return last;
	}

}
