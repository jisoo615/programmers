package level2;
//https://programmers.co.kr/learn/courses/30/lessons/12980
//점프와 순간이동
public class jump_teleport {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 5;
		System.out.print(s.solution(n));

	}

	static class Solution {
	    public int solution(int n) {
	        //k칸 이동->배터리 k가 줄음, 지금까지온거리*2만큼 순간이동 가능(배터리소모없이)

	        int ans = recur(n);

	        return ans;
	    }

	    public int recur(int k) {
	    	if(k==0) return 0;
	    	if(k==1) return 1;

	    	if(k%2==0) {
	    		return recur(k/2);
	    	}else {
	    		return recur(k/2)+1;
	    	}
	    }
	}

}
