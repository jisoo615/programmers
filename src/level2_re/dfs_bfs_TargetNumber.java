package level2_re;

//https://programmers.co.kr/learn/courses/30/lessons/43165
//타겟넘버
//numbers를 모두 가지고 더하거나 빼서 target이 될 수 있는 경우의 수는?
public class dfs_bfs_TargetNumber {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(new int[] {1, 1, 1, 1, 1}, 3));

	}

	static class Solution {

		private int answer=0;
		private int target;
	    public int solution(int[] numbers, int target) {
	    	this.target=target;

	    	dfs(numbers, 0, 0);

	    	return this.answer;
	    }

	    void dfs(int[] numbers, int result, int index) {
	    	if(index==numbers.length) {
	    		if(result==this.target) {
	    			this.answer += 1;
	    		}
	    		return;
	    	}

	    	dfs(numbers, result+numbers[index], index+1);
	    	dfs(numbers, result-numbers[index], index+1);

	}
	}
}
