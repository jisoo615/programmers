package dev_matching_2021_fw;

public class glassToy {

	public static void main(String[] args) {
		String[] drum = {"######",">#*###","####*#","#<#>>#",">#*#*<","######"};
		Solution s = new Solution();
		System.out.print(s.solution(drum));
	}

	static class Solution {
		static boolean[] goal;
		static boolean isOk;
	    public int solution(String[] drum) {
	        int answer = 0;
	        goal = new boolean[drum[0].length()];
	        for(int j=0; j<drum[0].length(); j++) {
	        	isOk = false;
	        	dfs(0, j, drum.length, drum, false);
	        	if(isOk) answer++;
	        }
	        return answer;
	    }

	    public void dfs(int x, int y, int depth, String[] drum, boolean asterisk) {
	    	if(x==depth-1) {
	    		isOk = true;
	    		return;
	    	}
	    	char command =drum[x].charAt(y);
	    	switch(command) {
	    	case '#':
	    		dfs(x+1, y, depth, drum, asterisk);
	    		break;
	    	case '>':
	    		dfs(x, y+1, depth, drum, asterisk);
	    		break;
	    	case '<':
	    		dfs(x, y-1, depth, drum, asterisk);
	    		break;
	    	case '*':
	    		if(asterisk) {
	    			isOk = false;
	    			return;
	    		}
	    		dfs(x+1, y, depth, drum, true);
	    		break;
	    	}

	    }
	}

}
