package level2;
//https://programmers.co.kr/learn/courses/30/lessons/86971
//전력망을 둘로 나누기
public class divide_network {

	public static void main(String[] args) {

		Solution s = new Solution();
		int n = 9;
		int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
		System.out.print(s.solution(n, wires));

	}

	static class Solution {
	    public int solution(int n, int[][] wires) {
	        int answer = -1;
	        boolean visited[] = new boolean[101];
	        for(int[] node : wires){

	        }

	        return answer;
	    }
	}

}
