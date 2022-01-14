package level3;
//https://programmers.co.kr/learn/courses/30/lessons/43105
//정수 상각형
public class digit_triangle {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(s.solution(triangle));

	}

	static class Solution {
	    public int solution(int[][] triangle) {
	        int answer = 0;

	        for(int i=triangle.length-2; i>=0; i--) {//layer
	        	for(int j=0; j<triangle[i].length; j++) {
	        		int left = triangle[i+1][j];
	        		int right =triangle[i+1][j+1];
	        		triangle[i][j] += left>right ? left : right;
	        	}
	        }
	        answer = triangle[0][0];

	        return answer;
	    }
	}

}
