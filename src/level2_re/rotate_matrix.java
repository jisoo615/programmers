package level2_re;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/77485
//행렬 테두리 회전하기
public class rotate_matrix {

	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(Solution.solution(6, 6,
						new int[][] {{2,2,5,4},{3,3,6,6},{5,1,6,3}})
				));
		/*System.out.println(
				Arrays.toString(Solution.solution(100, 97,
						new int[][] {{1,1,100,97}})
				));*/
	}
	static class Solution {
		public static int[][] arr;

	    public static int[] solution(int rows, int columns, int[][] queries) {
	    arr = new int[rows][columns];
	    int num = 0;
	    for(int i=0; i<rows; i++) {
	    	for(int j=0; j<columns; j++) {
	    		arr[i][j] = ++num;
	    	}
	    }
	    int[] answer = new int[queries.length];
	    int index=0;
	    for(int[] query : queries) {
	    	answer[index++] = rotate(query);
	    	for(int i=0; i<arr.length; i++) {
	    		System.out.println(Arrays.toString(arr[i]));
	    	}
	    	System.out.println("================");
	    }

	    return answer;
	}

	    static private int rotate(int[] point) {
	    	//사분면 좌표처럼 바꿈
	    	int y1=point[0]-1, x1=point[1]-1, y2=point[2]-1, x2=point[3]-1;

	    	int temp=arr[y1][x1];
	    	int min = temp;
	    	for(int i=y1; i<y2; i++) {//왼쪽: 아래->위로
	    		arr[i][x1] = arr[i+1][x1];
	    		min = Math.min(min, arr[i][x1]);
	    	}
	    	for(int j=x1; j<x2; j++) {//아래: <-
	    		arr[y2][j] = arr[y2][j+1];
	    		min = Math.min(min, arr[y2][j]);
	    	}
	    	for(int i=y2; i>y1; i--) {
	    		arr[i][x2] = arr[i-1][x2];
	    		min = Math.min(min, arr[i][x2]);
	    	}
	    	for(int j=x2; j>x1; j--) {
	    		arr[y1][j] = arr[y1][j-1];
	    		min = Math.min(min, arr[y1][j]);
	    	}
	    	arr[y1][x1+1] = temp;
	    	return min;

}
}
}
