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

		int q = 0;
		for(int[] query : queries) {
			int x1 = query[0]-1; int y1 = query[1]-1; int x2 = query[2]-1; int y2 = query[3]-1;
			//근데 이 방식도 아닌것 같음 다시 풀기
			int temp = matrix[x1][y1];
			int min = temp;

			for(int i=x1; i<x2; i++) {//왼쪽의 아래에서 위로
				matrix[i][y1] = matrix[i+1][y1];
				min = Math.min(min, matrix[i][y1]);
			}
			for(int i=y1; i<y2; i++) {//아래쪽의 오른쪽에서 왼쪽으로 이동 저장
				matrix[x2][i] = matrix[x2][i+1];
				min = Math.min(min, matrix[x2][i]);
			}
			for(int i=x2; i>x1; i--) {//오른쪽의 위에서 아래로
				matrix[i][y2] = matrix[i-1][y2];
				min = Math.min(min, matrix[i][y2]);
			}
			for(int i=y2; i>y1; i--) {//위쪽의 왼쪽에서 오른쪽으로
				matrix[x1][i] = matrix[x1][i-1];
				min = Math.min(min, matrix[x1][i]);
			}
			matrix[x1][y1+1] = temp;

			answer[q] = min;
			q += 1;
		}

		return answer;
	}

}
