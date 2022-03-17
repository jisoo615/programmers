package level2_re;
//https://programmers.co.kr/learn/courses/30/lessons/12980
//점프와 순간이동
public class jump_teleport {

	public static void main(String[] args) {
		System.out.println(new Solution().solution(5000));
		System.out.println(new Solution().solution2(5000));
	}

	static class Solution {
	    public int solution(int n) {
	    	/**
	    	 * 홀수와 짝수, 2와 관련
	    	 */

	    	return recur(n);
	    }

	    int recur(int k) {
	    	if(k==0) return 0;
	    	if(k==1) return 1;

	    	if(k%2==0) return recur(k/2);
	    	else return recur(k/2)+1;
	    }

	    int solution2(int n) {
	    	int answer=0;
	    	char[] bi = Integer.toBinaryString(n).toCharArray();
	    	System.out.println(bi);
	    	for(char b:bi) if(b=='1') answer++;
	    	return answer;
	    }
}

}
